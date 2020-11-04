package com.wang.cacah_demo.aop;

import org.aspectj.lang.annotation.Aspect;

import java.lang.annotation.*;

/**
 * @author 一只永不言弃的小乌龟
 * @create 2020/11/3 2:35 下午
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface CacheAnnotation {
    String value() default "";
}
