package com.ashish.AspectOrientedProgramming.Aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyDemoAspect2 {

    @Before("execution(* add*())")
    public void daoClass(){
        System.out.println("=======> Executing Demo aspect 2");
    }
}
