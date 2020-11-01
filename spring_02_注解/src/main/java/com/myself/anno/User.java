package com.myself.anno;

import org.springframework.stereotype.Component;

@Component(value = "user") //<bean id = "user" class ="com.myself.anno.User">
public class User {
    public void add(){
        System.out.println("add...");
    }
}
