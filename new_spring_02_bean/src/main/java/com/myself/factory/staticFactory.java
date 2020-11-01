package com.myself.factory;

import com.myself.service.IAccountService;
import com.myself.service.impl.AccountServiceImpl;

/*
模拟一个工厂类（该类可能是存在于jar包中，我们无法通过修改源码的方式来提供默认构造函数）
*/
public class staticFactory {

    public static IAccountService getAccountService(){
        return new AccountServiceImpl();
    }
}
