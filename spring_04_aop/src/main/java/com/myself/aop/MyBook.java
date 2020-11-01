package com.myself.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class MyBook {

    public void before1(){
        System.out.println("前置通知");
    }

    public void after1(){
        System.out.println("后置通知");
    }

    //环绕通知
    public void surround(ProceedingJoinPoint pjp) throws Throwable {
        //方法之前
        System.out.println("方法之前");

        //执行被增强方法
        pjp.proceed();

        //方法之后
        System.out.println("方法之后");
    }
}
