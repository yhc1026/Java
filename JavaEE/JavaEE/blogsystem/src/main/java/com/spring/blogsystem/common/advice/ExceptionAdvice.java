package com.spring.blogsystem.common.advice;


import com.spring.blogsystem.common.exception.BlogException;
import com.spring.blogsystem.pojo.response.Result;
import jdk.jshell.spi.ExecutionControl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.HandlerMethodValidationException;

@Slf4j
@ResponseBody
@ControllerAdvice
public class ExceptionAdvice {

    public Result exceptionHandler(Exception e) {
        log.error("【系统异常】{}", e);
        return Result.fail(e.getMessage(), null);
    }

    @ExceptionHandler
    public Result blogExceptionHandler(BlogException e) {
        log.error("【抛出异常被捕获】{}", e);
        return Result.fail(e.getErrMsg(), null);
    }

    @ExceptionHandler
    public Result userExceptionHandler(HandlerMethodValidationException e) {
        log.error("【抛出异常被捕获】{}", e);
        return Result.fail("参数校验失败", null);
    }
}
