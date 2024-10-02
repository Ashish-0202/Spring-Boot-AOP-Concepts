package com.ashish.AspectOrientedProgramming.Aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(0)
public class MyDemoAspect3 {

    @Pointcut("execution(* com.ashish.AspectOrientedProgramming.Dao.*.*(..))")
    private void forDaoPackages(){}

    @Pointcut("execution(* com.ashish.AspectOrientedProgramming.Dao.*.addAccount(..)))")
    private void forAccountDao(){}

    @Before("forDaoPackages() && forAccountDao()")
    public void ApiAnalytics(){
        System.out.println("=======> Performing API analytics");
    }
}
