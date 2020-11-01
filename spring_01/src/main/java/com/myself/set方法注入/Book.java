package com.myself.set方法注入;

public class Book {
    private int id;

    public void setId(int id) {
        this.id = id;
    }

    public void display(){
        System.out.println("图书id:"+id);
    }
}
