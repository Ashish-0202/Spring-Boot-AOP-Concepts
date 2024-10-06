package com.ashish.AspectOrientedProgramming.Aspect;

import com.ashish.AspectOrientedProgramming.Dao.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.awt.desktop.ScreenSleepEvent;
import java.util.List;

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

    @AfterReturning(pointcut = "com.ashish.AspectOrientedProgramming.Aspect.PointcutExpressions.listAccount()",returning = "result")
    public void AccountInfo(JoinPoint joinPoint, List<Account> result){
        //Getting method signature
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("=====> Method signature: "+methodSignature);

        //Printing the result
        System.out.println("===>Account details After Advice: "+result);

        if(!result.isEmpty()){
            Account tempAccouunt = result.get(0);

            tempAccouunt.setName("Ashish Shenoy");
        }

        //Printing the result after modification
        System.out.println("===>Account details After Advice and modification: "+result);
    }

    @AfterThrowing(pointcut = "com.ashish.AspectOrientedProgramming.Aspect.PointcutExpressions.listAccount()",throwing = "theExp")
    public void ExceptionInfo(JoinPoint joinPoint, Throwable theExp){
        System.out.println("I caught exception before throwing it to main app..!:" +theExp);
    }

    @After("execution(* getAllAccounts(..))")
    public void finalInfo(JoinPoint joinPoint){

        //Method signature
        MethodSignature methodSignature=(MethodSignature)joinPoint.getSignature();

        System.out.println("Method :"+methodSignature);

        System.out.println("Executing @After advice for getAllAccounts()");
    }

    //@Around("execution(* com.ashish.AspectOrientedProgramming.Service.TrafficFortuneServiceImpl.getFortune(..))")
    public Object logAroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable{
        //print out the method we are advising
        String data = joinPoint.getSignature().toString();
        System.out.println("Method: "+data);
        //get begin timestamp
        long begin = System.currentTimeMillis();

        //now proceed
        Object result = joinPoint.proceed();

        //get end timestamp
        long end = System.currentTimeMillis();

        //display duration
        long duration = end -begin;
        System.out.println("Duration: "+duration/1000.0+ " Milliseconds");

        return result;
    }

    @Around("execution(* com.ashish.AspectOrientedProgramming.Service.TrafficFortuneServiceImpl.getFortune(..))")
    public Object logAroundAdviceWithException(ProceedingJoinPoint joinPoint) throws Throwable{
        //print out the method we are advising
        String data = joinPoint.getSignature().toString();
        System.out.println("Method: "+data);
        //get begin timestamp
        long begin = System.currentTimeMillis();

        //now proceed
        Object result=null;

        try {
            result = joinPoint.proceed();
        }catch (Exception e){
            System.out.println("Exception:"+e.getMessage());
            System.out.println("Don't worry we have our AOP Rescue helicopter");
        }

        //get end timestamp
        long end = System.currentTimeMillis();

        //display duration
        long duration = end -begin;
        System.out.println("Duration: "+duration/1000.0+ " Milliseconds");

        return result;
    }
}

//Access modifier is optional

//JoinPoint will contain the method signatures

//MethodSignature interface will store method signature