package com.myself.factory;

import com.sun.corba.se.spi.ior.ObjectKey;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/*
    bean:在计算机英语中，有可重用组件的含义
    javabean:不等于实体类，用java语言编写的可重用组件

    创建bean对象的一个工厂
    它就是创建service和dao对象的

    第一步：需要一个配置文件来配置我们的service和dao
                配置的内容：唯一标识=全限定类型(key = value)
    第二步：通过读取配置文件中配置的内容，反射创建对象

    配置文件可以是xml也可以是properties

*/
public class BeanFactory {
    //定义一个properties对象
    private static Properties properties;

    //定义一个容器，用于存放我们要创建的对象，我们把它称之为容器(单例)
    private static Map<String, Object> beans;

    //静态代码块为Properties对象赋值
    static {
        try {
            FileInputStream fis = new FileInputStream("C:\\Users\\15173\\IdeaProjects\\spring\\工厂模式解耦\\src\\main\\resources\\bean.properties");
            properties = new Properties();
            properties.load(fis);
            //实例化容器
            beans = new HashMap<String, Object>();
            //取出配置文件中所有的key
            Enumeration keys = properties.keys();
            //遍历枚举
            while (keys.hasMoreElements()) {
                //取出每个key
                String key = keys.nextElement().toString();
                //根据key获取value
                String beanPath = properties.getProperty(key);
                //反射创建对象
                Object value = Class.forName(beanPath).newInstance();
                //把key和value存入容器之中
                beans.put(key, value);
            }
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据bean名称获取对象（单例）
     * @param beanName
     * @return
     */
    public static Object getBean(String beanName) {
        return beans.get(beanName);
    }
}
    /**
     * 根据bean名称获取bean对象（多例）
     * @param beanName
     * @return Object

    public static Object getBean(String beanName) {
        Object bean = null;
        String beanPath = properties.getProperty(beanName);
        try {
            bean = Class.forName(beanPath).newInstance(); //newInstance方法调用默认构造函数，是多例的
        } catch (Exception e) {
           e.printStackTrace();
        }
        return bean;
    }

    */
