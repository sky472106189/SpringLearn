package com.myself.注解注入属性;


import com.myself.anno.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component("userService")//value = 可以省略不写
public class UserService {
    //得到UserDao对象
    //1.定义dao类型属性
    //2.在dao属性上使用注解

//    @Autowired自动写入，名字不需要一一对应
    @Resource(name = "userDao123")//常用的方法，需要对应到类里注解的value值
    private UserDao userDao;

    //使用注解方式时不需要set方法
    public void add(){
        System.out.println("service.");
        userDao.add();
    }
}
