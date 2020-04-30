package com.alice.photo.controller.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author ghj
 * @Description
 * @date 2020/4/30 9:20
 */
@Aspect
@Slf4j
@Component
public class LoginAop {
    @Pointcut("execution(* com.alice.photo.controller.UserController.*(..))")
    public void aopCut() {
    }


    @Around("aopCut()")
    public Object loginInfoPrint(ProceedingJoinPoint jp) throws Throwable {
        log.info("调用的类：{}", jp.getTarget());
        log.info("调用的方法：{}", jp.getSignature().getName());
        log.info("参数：{}", Arrays.toString(jp.getArgs()));
        return jp.proceed();
    }
}
