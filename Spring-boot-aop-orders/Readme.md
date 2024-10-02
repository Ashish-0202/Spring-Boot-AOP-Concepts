**Order:**

If we have multiple advices need to be executed then we can set the order of execution by using @Order annotation.

    @Aspect
    @Component
    @Order(1)
    public class LoggingAspect {
        //Code
    }

    @Aspect
    @Component
    @Order(2)
    public class APIAnalytics {
        //Code
    }

**JointPoint:**

Using JointPoint class we can actually get and log the method signatures and arguments while using @Before advice.

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
