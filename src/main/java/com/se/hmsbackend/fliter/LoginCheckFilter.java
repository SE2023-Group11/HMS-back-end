package com.se.hmsbackend.fliter;

import com.alibaba.fastjson.JSON;
import com.se.hmsbackend.common.Const;
import com.se.hmsbackend.common.R;
import com.se.hmsbackend.utils.AuthorityUtil;
import com.se.hmsbackend.utils.TokenUtil;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;

@Slf4j
@WebFilter(filterName = "loginCheckFilter",urlPatterns = "/*")
public class LoginCheckFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
//        HttpSession session = request.getSession();

        response.setHeader("Access-Control-Allow-Origin","http://localhost:8080");
        response.setHeader("Access-Control-Allow-Credentials","true");
        response.setHeader("Access-Control-Allow-Methods", "*");
        response.setHeader("Access-Control-Max-Age", "3600");

        String requestURI =request.getRequestURI();
        String authority = AuthorityUtil.getAuthority(requestURI);

        log.info("拦截： "+requestURI);
//        Enumeration<String> headerNames = request.getHeaderNames();
//        while (headerNames.hasMoreElements())             //读取请求消息头
//        {
//            String name = headerNames.nextElement();
//            String value = request.getHeader(name);
//            log.info(name+": "+value);
//        }
//        log.info("coocie: "+ Arrays.toString(request.getCookies()));

        //测试，直接放行
        filterChain.doFilter(request,response);
        if(true)return;

//        不需要权限，放行
        if(Const.NO_AUTHORITY.equals(authority)){
            filterChain.doFilter(request,response);
            return;
        }

        String token = request.getParameter(Const.TOKEN);
        if(!TokenUtil.isRight(token)){
            response.getWriter().write(JSON.toJSONString(R.error("Token已过期")));
            return;
        }
//        有管理员权限，放行
        if(Const.ADMIN_AUTHORITY.equals(authority)){
//            Object type = session.getAttribute(Const.NOW_LOGGED_IN_TYPE);
            Object type = TokenUtil.parse(token).get(Const.NOW_LOGGED_IN_TYPE);
            if(Const.NOW_LOGGED_IN_TYPE_ADMIN.equals(type)){
                filterChain.doFilter(request,response);
                return;
            }
        }

//        Object tokenInSession = session.getAttribute(Const.TOKEN);
////        token不一致,不放行
//        if(token == null || tokenInSession==null || !token.equals(tokenInSession)){
//            response.getWriter().write(JSON.toJSONString(R.error("Access denied")));
//            return;
//        }

        if(Const.PATIENT_AUTHORITY.equals(authority)){
            Object type = TokenUtil.parse(token).get(Const.NOW_LOGGED_IN_TYPE);
            if(Const.NOW_LOGGED_IN_TYPE_PATIENT.equals(type)){
                filterChain.doFilter(request,response);
                return;
            }
        }

        if(Const.DOCTOR_AUTHORITY.equals(authority)){
            Object type = TokenUtil.parse(token).get(Const.NOW_LOGGED_IN_TYPE);
            if(Const.NOW_LOGGED_IN_TYPE_DOCTOR.equals(type)){
                filterChain.doFilter(request,response);
                return;
            }
        }

        response.getWriter().write(JSON.toJSONString(R.error("Access denied")));
    }
}
