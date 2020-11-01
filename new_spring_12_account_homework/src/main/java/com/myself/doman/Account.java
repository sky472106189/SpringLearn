package com.myself.doman;

import com.myself.service.IAccountService;

import java.io.Serializable;
import java.util.List;

/*
    账户实体类
*/
public class Account implements Serializable{

    private int id;
    private String name;
    private float money;

    public Account() {
    }

    public Account(int id, String name, float money) {

        this.id = id;
        this.name = name;
        this.money = money;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", money=" + money +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public List<Account> findAll() {
        return null;
    }
}
