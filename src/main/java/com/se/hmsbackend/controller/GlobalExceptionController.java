package com.se.hmsbackend.controller;

import com.se.hmsbackend.common.R;
import com.se.hmsbackend.exception.BusinessException;
import com.se.hmsbackend.exception.SystemException;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@CrossOrigin
@ControllerAdvice
public class GlobalExceptionController {
    @ExceptionHandler(Exception.class)
    public R<String> exceptionHandler(Exception e, HttpServletResponse response){
        log.error(e.getMessage(),e);
        return R.error("服务器错误,请稍后再试");
    }
    @ExceptionHandler(BusinessException.class)
    public R<String> businessExceptionHandler(BusinessException e){
        log.error(e.getMessage(),e);
        return R.error("非法操作");
    }
    @ExceptionHandler(SystemException.class)
    public R<String> systemExceptionHandler(SystemException e){
        log.error(e.getMessage(),e);
        return R.error("服务器错误,请稍后再试");
    }
}
