package com.myself.service.impl;

import com.myself.service.IAccountService;

/*
    账户业务层实现类
*/
public class AccountServiceImpl implements IAccountService {

    public void saveAccount() {
            System.out.println("service中的saveAccount执行..");
    }

    public void init(){
        System.out.println("对象初始化");
    }

    public void destroy(){
        System.out.println("对象销毁");
    }
}
