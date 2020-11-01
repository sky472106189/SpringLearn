package com.myself.service.impl;

import com.myself.service.IAccountService;

/*
    账户业务层实现类
*/
public class AccountServiceImpl implements IAccountService {

    public void saveAccount() {
        System.out.println("保存成功");
    }

    public void updateAccount(int id) {
        System.out.println("更新成功");
    }

    public int deleteAccount() {
        System.out.println("删除成功");
        return 0;
    }
}
