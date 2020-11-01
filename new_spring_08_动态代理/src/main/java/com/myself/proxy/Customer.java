package com.myself.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/*
动态代理：
    特点：字节码随用随创建，随用随加载
    作用：不修改源码的基础之上对方法增强
    分类：
        基于接口的动态代理
        基于子类的动态代理
    基于接口的动态代理：
        涉及得的类：Proxy
        提供者：JDK官方
    如何创建代理对象：
        使用Proxy类的new ProxyInstance方法
    创建代理对象的要求：
        被代理类至少实现一个接口，如果没有则不能使用
    new ProxyInstance(newProxyInstance(ClassLoader loader,
                                  Class<?>[] interfaces,
                                  InvocationHandler h))
        ClassLoader loader:类加载器
            定义被代理类(生产厂家)的类加载器
        Class<?>[] interfaces:代理类要实现的接口列表
            用于让代理对象(经销商)和被代理对象(生产厂家)有相同的方法
        InvocationHandler h:用于提供增强的代码
            它是让我们写如何代理。一般都是写一个该接口的实现类，通常情况下是匿名内部类。
            此接口的实现类都是谁用谁写。
*/
//消费者
public class Customer {
    public static void main(String[] args) {

        //为什么final 因为匿名内部类调用外部类成员，需要final修饰
        final IProducer producer = new Producer();
        //消费者直接找生产厂家买电脑(便宜)
        producer.saleProduct(1000);

        //proxyProducer就是代理商
        IProducer proxyProducer = (IProducer) Proxy.newProxyInstance(producer.getClass().getClassLoader(),
                producer.getClass().getInterfaces(),
                new InvocationHandler() {
                    /**
                     *  执行被代理对象的任何接口方法
                     * @param proxy  代理对象的引用
                     * @param method 当前执行的方法
                     * @param args   当前执行方法的形参
                     * @return       和被代理对象有相同的返回值
                     * @throws Throwable
                     */
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object returnValue = null;
                        //1.获取方法的执行参数
                        Double money = (Double) args[0];
                        //2.增强方法
                            //2.1判断当前方法是不是出售
                        if("saleProduct".equals(method.getName())){
                            //开始增强方法
                            //经销商谋取0.8的利润
                            returnValue = method.invoke(producer,money*0.8);
                        }
                        return returnValue;
                    }
                });
        //消费者找经销商商买电脑
        proxyProducer.saleProduct(2000);
    }
}
