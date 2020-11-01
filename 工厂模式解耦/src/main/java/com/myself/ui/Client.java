package com.myself.ui;

import com.myself.factory.BeanFactory;
import com.myself.service.IAccountService;
import com.myself.service.impl.AccountServiceImpl;

/*
    模拟表现层，用于调用业务层
*/
public class Client {
    public static void main(String[] args) {
        //IAccountService service = new AccountServiceImpl();
        IAccountService service = (IAccountService) BeanFactory.getBean("accountService");
        service.saveAccount();
    }
}
