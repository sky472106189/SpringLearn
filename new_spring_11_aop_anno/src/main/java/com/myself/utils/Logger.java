package com.myself.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/*
    用于记录日志的工具类，它里面提供了公共的代码
*/
@Component("logger")
@Aspect//表示当前类是一个切面类
public class Logger {

    @Pointcut("execution(* com.myself.service.impl.*.*(..))")
    private void pt1(){}

//    //前置通知
//    @Before("pt1()")
//    public void beforePrintLog(){
//        System.out.println("Logger开始记录...");
//    }
//
//    //后置通知
//    @AfterReturning("pt1()")
//    public void afterPrintLog(){
//        System.out.println("Logger后置记录...");
//    }
//
//    //异常通知
//    @AfterThrowing("pt1()")
//    public void errorPrintLog(){
//        System.out.println("出现异常...");
//    }
//
//    //最终通知
//    @After("execution(* com.myself.service.impl.*.*(..))")
//    public void finalPrintLog(){
//        System.out.println("Logger结束记录...");
//    }

    //环绕通知
    @Around("execution(* com.myself.service.impl.*.*(..))")
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
