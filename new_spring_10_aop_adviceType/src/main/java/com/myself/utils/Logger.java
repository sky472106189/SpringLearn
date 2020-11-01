package com.myself.utils;

import org.aspectj.lang.ProceedingJoinPoint;

/*
    用于记录日志的工具类，它里面提供了公共的代码
*/
public class Logger {

    //前置通知
    public void beforePrintLog(){
        System.out.println("Logger开始记录...");
    }

    //后置通知
    public void afterPrintLog(){
        System.out.println("Logger后置记录...");
    }

    //异常通知
    public void errorPrintLog(){
        System.out.println("出现异常...");
    }

    //最终通知
    public void finalPrintLog(){
        System.out.println("Logger结束记录...");
    }

    /*环绕通知
    问题:
        当我们配置了环绕通知后，切入点方法没有执行(saveAccount()没有执行)，但通知方法执行了
    分析:
        通过对比动态代理的唤醒通知，发现环绕通知有明确的切入点方法调用，而此代码没有
    解决：
        Spring框架提供了一个接口:ProceedingJoinPoint 该接口有一个方法:proceed(),此方法就相当于明确调用切入点方法
        该接口可以作为环绕通知的方法参数，在程序执行时，spring框架会为我们提供该接口的实现类供我们使用。

    环绕通知另一种解释：
        它是Spring框架为我们提供的一种可以在代码中手动控制，增强方法何时执行的方式。
    */
    public Object aroundPrintLog(ProceedingJoinPoint pjp){
        Object returnValue = null;
        try {
            Object[] args = pjp.getArgs();//得到方法参数

            System.out.println("Logger环绕通知——前置");
            returnValue = pjp.proceed();//明确调用切入点方法
            System.out.println("Logger环绕通知——后置");
            return returnValue;
        } catch (Throwable throwable) {
            System.out.println("Logger环绕通知——异常");
            throwable.printStackTrace();
        }finally {
            System.out.println("Logger环绕通知——最终");
        }
        return returnValue;
    }
}
