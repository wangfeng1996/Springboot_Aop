package com.wang.cacah_demo.aop;

import com.alibaba.fastjson.JSON;
import com.wang.cacah_demo.pojo.User;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @author 一只永不言弃的小乌龟
 * @create 2020/11/3 2:35 下午
 */
@Aspect
@Component
public class CacheAspect {
    @Autowired
    private StringRedisTemplate redisTemplate;


    /**
     * 声明切点,切入点表达式设置为注解
     */
    @Pointcut(value = "@annotation(com.wang.cacah_demo.aop.CacheAnnotation)")
    public void pointCut(){

    }


    /**
     *  声明切面
     * @param joinPoint
     */
    @AfterReturning(pointcut = "pointCut()")
    public  void advice(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        User user= (User) args[0];
        String s = JSON.toJSONString(user);
        redisTemplate.boundValueOps(user.getId().toString()).set(s);
    }

}
