package com.spring.bookmanage.aspect;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;


@Slf4j
@Aspect
@Component
public class TimeAspect {

    @Around("execution(* com.spring.bookmanage.controller.*.*(..))")
    public Object timeRecord(ProceedingJoinPoint pjp) throws Throwable {
        Long startTime = System.currentTimeMillis();
        Object proceed=pjp.proceed();
        Long endTime = System.currentTimeMillis();
        log.info(pjp.getSignature().toString()+"耗时："+(endTime-startTime)+"ms");
        return proceed;
    }

    @Before("execution(* com.spring.bookmanage.controller.*.*(..))")
    public void method1(ProceedingJoinPoint pjp) throws Throwable {
        log.info("已经执行method1"+pjp.getSignature().toString());
    }

    @After("execution(* com.spring.bookmanage.controller.*.*(..))")
    public void method2(ProceedingJoinPoint pjp) throws Throwable {
        log.info("已经执行method2"+pjp.getSignature().toString());
    }

    @AfterReturning("execution(* com.spring.bookmanage.controller.*.*(..))")
    public void method3(ProceedingJoinPoint pjp) throws Throwable {
        log.info("已经执行method3"+pjp.getSignature().toString());
    }

    @AfterThrowing("execution(* com.spring.bookmanage.controller.*.*(..))")
    public void method4(ProceedingJoinPoint pjp) throws Throwable {
        log.info("已经执行method4"+pjp.getSignature().toString());
    }
}
