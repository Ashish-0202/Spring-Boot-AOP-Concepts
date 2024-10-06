package com.ashish.AspectOrientedProgramming.Aspect;


import org.aspectj.lang.annotation.Pointcut;

public class PointcutExpressions {

    @Pointcut("execution(* com.ashish.AspectOrientedProgramming.Dao.*.*(..))")
    public void forDaoPackages(){}

    @Pointcut("execution(* addAccount())")
    public void forDoaAccount(){}

    @Pointcut("execution(* get*(..))")
    public void getter(){}

    @Pointcut("execution(* set*(..))")
    public void setter(){}

    @Pointcut("execution(* getAll*(..))")
    public void listAccount(){}
}
