package com.spring.aop.advice.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 注解的定义
 * 定义生命周期
 * 定义目标（方法 或 类）
 * 定义属性（非必须，此处未定义）
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface annotationTest {
}
