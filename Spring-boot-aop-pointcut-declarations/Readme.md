Pointcut declaration is helpful if we want pointcut expressions for multiple advices then we can have a private method with @Pointcut expression and reuse it.

    @Pointcut("execution(* com.ashish.AspectOrientedProgramming.Dao.*.*(..))")
    private void forDaoPackages(){}

    @Before("forDaoPackages()")
    public void daoAspect(){
        System.out.println("=======> Executing @Before advice on addAccount()");
    }

    @Before("forDaoPackages()")
    public void ApiAnalytics(){
        System.out.println("=======> Performing API analytics");
    }

    //Resusability of Pointcut expressions by declaring a @Pointcut.