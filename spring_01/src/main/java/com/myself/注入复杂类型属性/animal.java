package com.myself.注入复杂类型属性;

import java.util.List;
import java.util.Map;
import java.util.Properties;

public class animal {
    private String[] arrs;
    private List<String> list;
    private Map<String,String> map;
    private Properties properties;

    public void setArrs(String[] arrs) {
        this.arrs = arrs;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public void display(){
        for(String i :arrs)
        System.out.println("arrs:"+i);
        System.out.println("list:"+list);
        System.out.println("map:"+map);
        System.out.println("pro:"+properties);
    }
}
