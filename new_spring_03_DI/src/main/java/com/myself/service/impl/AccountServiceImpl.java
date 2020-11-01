package com.myself.service.impl;

import com.myself.service.IAccountService;

import java.util.Date;

/*
    账户业务层实现类
*/
public class AccountServiceImpl implements IAccountService {
    private String name;
    private Integer age;
    private Date birthday;

    public AccountServiceImpl() {
    }

    public AccountServiceImpl(String name, Integer age, Date birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public void display() {
            System.out.println("name:"+name+"age"+age+"birthday:"+birthday);
    }

}
