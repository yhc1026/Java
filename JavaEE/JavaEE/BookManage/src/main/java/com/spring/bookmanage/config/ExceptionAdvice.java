package com.spring.bookmanage.config;


import com.spring.bookmanage.entity.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@ControllerAdvice
@ResponseBody
public class ExceptionAdvice {

    @ExceptionHandler
    public Result handler(Exception e){
        log.error("error: "+e);
        return Result.fail("inner error, please connect manager");
    }
}
