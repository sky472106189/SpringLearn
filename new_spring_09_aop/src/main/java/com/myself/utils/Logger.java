package com.myself.utils;

/*
    用于记录日志的工具类，它里面提供了公共的代码
*/
public class Logger {

    //打印日志，计划让其在切入点方法执行之前执行
    public void printLog(){
        System.out.println("Logger开始记录...");
    }

}
