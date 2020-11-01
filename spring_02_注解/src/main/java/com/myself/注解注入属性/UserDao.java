package com.myself.注解注入属性;

import org.springframework.stereotype.Component;

@Component("userDao123")
public class UserDao {
    public void add(){
        System.out.println("dao..");
    }
}
