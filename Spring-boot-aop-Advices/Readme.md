**@AfterReturning**

After returning advice will be executed after the successful execution of the method.

We can also Post process the data, and also we can get the return data and modify it before final output.


    @AfterReturning(pointcut = "com.ashish.AspectOrientedProgramming.Aspect.PointcutExpressions.listAccount()",returning = "result")
    public void AccountInfo(JoinPoint joinPoint, List<Account> result){
        //Getting method signature
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("=====> Method signature: "+methodSignature);


        //Printing the result
        System.out.println("===>Account details After Advice: "+result);
    }