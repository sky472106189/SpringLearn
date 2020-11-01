package com.myself.有参构造注入属性;

public class propertyDemo1 {
    private String username;

    public propertyDemo1(String username) {
        this.username = username;
    }

    public void display(){
        System.out.println("demo1:"+username);
    }
}
