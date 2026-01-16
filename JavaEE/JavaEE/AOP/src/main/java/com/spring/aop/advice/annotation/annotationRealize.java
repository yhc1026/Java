package com.spring.aop.advice.annotation;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import com.spring.aop.advice.annotation.annotationTest;

/**
 * 切面类，用于实现annotation自定义注解
 * 通过添加@Before，@After等注解映射到匹配的注解定义
 */

@Aspect
@Component
@Slf4j
public class annotationRealize {

    public Long timeBefore;
    public Long timeAfter;

    @Before("@annotation(com.spring.aop.advice.annotation.annotationTest)")
    public void before(){
        log.info("自定义注解，before");
        timeBefore= System.currentTimeMillis();
    }

    @After("@annotation(com.spring.aop.advice.annotation.annotationTest)")
    public void after(){
        log.info("自定义注解，after");
        timeAfter= System.currentTimeMillis();
        log.info("自定义注解测试接口耗时: "+(timeAfter-timeBefore)+"ms");
    }
}
