package com.ashish.AspectOrientedProgramming.Aspect;

import com.ashish.AspectOrientedProgramming.Dao.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(-1)
public class LoggingAspect {

    @Before("com.ashish.AspectOrientedProgramming.Aspect.PointcutExpressions.forDaoPackages() && !(com.ashish.AspectOrientedProgramming.Aspect.PointcutExpressions.getter() || com.ashish.AspectOrientedProgramming.Aspect.PointcutExpressions.setter())")
    public void daoAspect(JoinPoint joinPoint){
        System.out.println("=======> Executing @Before advice on forDaoPackages()");

        //displaying method signature
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

        System.out.println("Method: "+methodSignature);

        //displaying method arguments
        Object[] args = joinPoint.getArgs();

        for(Object tempArgs: args){
            if(tempArgs instanceof Account){
                //Down casting the tempArg into Account object
                Account account = (Account) tempArgs;
                System.out.println("Account Name: "+account.getName());
                System.out.println("Account type: "+account.getType());
            }
        }
    }
}

//Access modifier is optional

//JoinPoint will contain the method signatures

//MethodSignature interface will store method signature