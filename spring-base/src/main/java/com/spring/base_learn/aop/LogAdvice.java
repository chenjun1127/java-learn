package com.spring.base_learn.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @Description: aop配置
 * @Author: chenjun
 * @Date: 2020/7/23 14:59
 */
@Component
@Aspect // 告诉spring，这是一个切面类，里面可以定义切入点和通知；
public class LogAdvice {
    // 切入表达式（切入哪些方法）
    @Pointcut("execution(* com.spring.base_learn.service.impl.AccountServiceImpl.*(..))")
    public void aspect() {

    }

    //前置通知
    @Before("aspect()")
    public void beforeLog(JoinPoint joinPoint) {
        System.out.println("LogAdvice before");
    }

    @After("aspect()")
    public void afterLog(JoinPoint joinPoint) {
        System.out.println("LogAdvice after");
    }

    // 环绕通知
    @Around("aspect()")
    public void around(JoinPoint joinPoint) throws Throwable {
        Object target = joinPoint.getTarget().getClass().getName();
        System.out.println("调用者：" + target);
        System.out.println("调用方法：" + joinPoint.getSignature());
        long start = System.currentTimeMillis();
        System.out.println("环绕通知 环绕前");
        ((ProceedingJoinPoint) joinPoint).proceed();
        long end = System.currentTimeMillis();
        System.out.println("环绕通知 环绕后");
        System.out.println("调用方法总耗时：" + (end - start) + "ms");
    }
}
