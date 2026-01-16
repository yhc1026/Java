package com.spring.aop.advice;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class AOPAdviceClassic {

    @Around("execution(* com.spring.aop.controller.*.testAOPClassic(..))")
    public Object timeRecord(ProceedingJoinPoint pjp) throws Throwable {
        log.info("方法执行前，开始计时");
        Long startTime = System.currentTimeMillis();
        Object proceed=pjp.proceed();
        Long endTime = System.currentTimeMillis();
        log.info("方法执行后，停止计时");
        log.info(pjp.getSignature().toString()+"耗时："+(endTime-startTime)+"ms");
        return proceed;
    }
}
