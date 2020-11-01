package com.myself.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/*
    基于子类的动态代理
        涉及的类：Enhancer
        提供者：第三方cglib库
    如何创建代理对象：
        Enhancer类中的create方法
    创建代理对象的要求
        被代理类不能是最终类(final)
    create方法参数：
        Class:字节码
            用于指定被代理对象的字节码
        Callback:提供增强代码
            一般写的是该接口的子接口实现类：MethodInterceptor

*/
//消费者
public class Customer {
    public static void main(String[] args) {

        final Producer producer = new Producer();

        Producer cglibProducer = (Producer)Enhancer.create(Producer.class, new MethodInterceptor() {
            /**
             * 执行被代理对象的任何方法都会经过该方法
             *
             * @param o           代理对象的引用
             * @param method      当前执行的方法
             * @param objects     当前执行方法的形参
             * @param methodProxy 当前执行方法的代理对象
             * @return
             * @throws Throwable
             */
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                Object returnValue = null;
                //1.获取方法的执行参数
                Double money = (Double) objects[0];
                //2.增强方法
                //2.1判断当前方法是不是出售
                if ("saleProduct".equals(method.getName())) {
                    //开始增强方法
                    //经销商谋取0.8的利润
                    returnValue = method.invoke(producer, money * 0.8);
                }
                return returnValue;
            }
        });
        //基于子类的代理商卖电脑
        cglibProducer.saleProduct(10000);
    }
}
