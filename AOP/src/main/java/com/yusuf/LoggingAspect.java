package com.yusuf;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    @Pointcut("execution(* com.yusuf.interfaces.IAnimal.*(..))")
    public void test() {}

    @Before("test()")
    public void beforeAdvice() {
        System.out.println("Before advice executed.");
    }

    @After("test()")
    public void afterAdvice() {
        System.out.println("After advice executed.");
    }
}