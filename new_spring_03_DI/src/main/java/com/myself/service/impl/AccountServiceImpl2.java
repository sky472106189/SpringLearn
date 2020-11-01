package com.myself.service.impl;

import com.myself.service.IAccountService;

import java.util.Date;

/*
    账户业务层实现类
*/
public class AccountServiceImpl2 implements IAccountService {
    private String name;
    private Integer age;
    private Date birthday;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void display() {
            System.out.println("name:"+name+"age"+age+"birthday:"+birthday);
    }

}
