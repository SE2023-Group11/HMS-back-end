package com.se.hmsbackend.fliter;

import com.alibaba.fastjson.JSON;
import com.se.hmsbackend.common.Const;
import com.se.hmsbackend.common.R;
import com.se.hmsbackend.utils.AuthorityUtil;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
@WebFilter(filterName = "loginCheckFilter",urlPatterns = "/*")
public class LoginCheckFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();

        //测试，直接放行
//        filterChain.doFilter(request,response);
//        if(true)return;

        String requestURI =request.getRequestURI();
        String authority = AuthorityUtil.getAuthority(requestURI);
//        System.out.println("拦截："+requestURI);
        log.info("拦截： "+requestURI);
//        不需要权限，放行
        if(Const.NO_AUTHORITY.equals(authority)){
            filterChain.doFilter(request,response);
            return;
        }
//        有管理员权限，放行
        if(Const.ADMIN_AUTHORITY.equals(authority)){
            Object type = session.getAttribute(Const.NOW_LOGGED_IN_TYPE);
            if(Const.NOW_LOGGED_IN_TYPE_ADMIN.equals(type)){
                filterChain.doFilter(request,response);
                return;
            }
        }
        String token = request.getParameter(Const.TOKEN);
        Object tokenInSession = session.getAttribute(Const.TOKEN);
//        token不一致,不放行
        if(token == null || tokenInSession==null || !token.equals(tokenInSession)){
            response.getWriter().write(JSON.toJSONString(R.error("Access denied")));
            return;
        }

        if(Const.PATIENT_AUTHORITY.equals(authority)){
            Object type = session.getAttribute(Const.NOW_LOGGED_IN_TYPE);
            if(Const.NOW_LOGGED_IN_TYPE_PATIENT.equals(type)){
                filterChain.doFilter(request,response);
                return;
            }
        }

        if(Const.DOCTOR_AUTHORITY.equals(authority)){
            Object type = session.getAttribute(Const.NOW_LOGGED_IN_TYPE);
            if(Const.NOW_LOGGED_IN_TYPE_DOCTOR.equals(type)){
                filterChain.doFilter(request,response);
                return;
            }
        }

        response.getWriter().write(JSON.toJSONString(R.error("Access denied")));
    }
}
