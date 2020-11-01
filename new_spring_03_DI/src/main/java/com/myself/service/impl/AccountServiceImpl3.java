package com.myself.service.impl;

import com.myself.service.IAccountService;

import java.util.*;

/*
    账户业务层实现类
*/
public class AccountServiceImpl3 implements IAccountService {
    private String[] myStrs;
    private List<String> list;
    private Set<String> set;
    private Map<String,String> map;
    private Properties properties;

    public void setMyStrs(String[] myStrs) {
        this.myStrs = myStrs;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public void display() {
        System.out.println("myStrs:"+Arrays.toString(myStrs));
        System.out.println("list:"+list);
        System.out.println("set:"+set);
        System.out.println("map:"+map);
        System.out.println("pro:"+properties);
    }

}
