package com.ashish.AspectOrientedProgramming.Aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoAspect {

    //Pointcut expression - predicate method which will only apply the advice if the given expression matched
    //@Before("execution(public void addAccount())")
    //@Before("execution(public void updateAccount())")
    //@Before("execution(public void com.ashish.AspectOrientedProgramming.Dao.MemberShipDaoImpl.addAccount())")
    //Above advice will only work for the specified class addAccount() method

    //@Before("execution(void add*())") //This will match any method starting with add
    //@Before("execution(* add*())")
    //@Before("execution(* addAccount(com.ashish.AspectOrientedProgramming.Dao.Account))") //matching with account object param type
    //@Before("execution(int add*())")

    @Pointcut("execution(* com.ashish.AspectOrientedProgramming.Dao.*.*(..))")
    private void forDaoPackages(){}

    @Pointcut("execution(* com.ashish.AspectOrientedProgramming.Dao.*.addAccount(..)))")
    private void forAccountDao(){}

    @Pointcut("execution(* com.ashish.AspectOrientedProgramming.Dao.*.get*(..))")
    private void getter(){}



    @Before("forDaoPackages() && !(getter())")
    public void daoAspect(){
        System.out.println("=======> Executing @Before advice on forDaoPackages()");
    }

    //Here we are combining two pointcut expressions and using and operator so based on condition advice will be applied
    @Before("forDaoPackages() && forAccountDao()")
    public void ApiAnalytics(){
        System.out.println("=======> Performing API analytics");
    }

//    @Before("forDaoPackages()")
//    public void daoAspectForAll(){
//        System.out.println("=======> Executing @Before advice on forDaoPackages Including getters & setters()");
//    }

}

//Access modifier is optional
