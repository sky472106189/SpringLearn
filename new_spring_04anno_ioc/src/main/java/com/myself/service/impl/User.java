package com.myself.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("user")
public class User {

    @Value("张三")
    private String name;

    public void display(){
        System.out.println(name);
    }

}
