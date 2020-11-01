package com.myself.factory;

import com.myself.doman.Account;
import com.myself.service.IAccountService;
import com.myself.untils.TransactionManager;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/*
    用于创建Service代理对象的工厂
    进行方法增强（事务管理）
*/
public class BeanFactory {

    //被代理对象(厂家)
    private IAccountService accountService;

    private TransactionManager transactionManager;

    public void setAccountService(IAccountService accountService) {
        this.accountService = accountService;
    }

    //为什么final 因为匿名内部类调用外部类成员，需要final修饰
    //为什么set方法用，因为我们用spring的set方法注入属性，所以在这里修饰
    //如果上面的是new出来的，那就final放上面修饰
    public final void setTransactionManager(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    public IAccountService getAccountService(){
        IAccountService proxyService = (IAccountService) Proxy.newProxyInstance(accountService.getClass().getClassLoader(),
                accountService.getClass().getInterfaces(),
                new InvocationHandler() {
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object returnValue = null;
                        try {
                            //1.开启事务
                            transactionManager.beginTransaction();
                            //2.执行操作
                            returnValue = method.invoke(accountService, args);
                            //3.提交事务
                            transactionManager.commit();
                            //4.返回结果
                            return returnValue;
                        } catch (Exception e) {
                            //5.回滚操作
                            transactionManager.rollback();
                            throw new RuntimeException(e);
                        } finally {
                            //6.释放连接
                            transactionManager.relase();
                        }
                    }
                });
        return proxyService;
    }
}
