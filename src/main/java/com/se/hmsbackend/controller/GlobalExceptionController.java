package com.se.hmsbackend.controller;

import com.se.hmsbackend.common.R;
import com.se.hmsbackend.exception.BusinessException;
import com.se.hmsbackend.exception.SystemException;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionController {
    @ExceptionHandler(Exception.class)
    public R<String> exceptionHandler(Exception e, HttpServletResponse response){
        e.printStackTrace();
        return R.error("服务器错误,请稍后再试");
    }
    @ExceptionHandler(BusinessException.class)
    public R<String> businessExceptionHandler(BusinessException e){
        e.printStackTrace();
        return R.error("非法操作");
    }
    @ExceptionHandler(SystemException.class)
    public R<String> systemExceptionHandler(SystemException e){
        e.printStackTrace();
        return R.error("服务器错误,请稍后再试");
    }
}
