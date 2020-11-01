package com.myself.ui;

import com.myself.service.impl.AccountServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
    public static void main(String[] args) {
        //1.获取核心容器对象
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");

        //2.根据id获取bean对象
        AccountServiceImpl accountService = (AccountServiceImpl) context.getBean("accountService");
        accountService.saveAccount();

        //手动关闭容器
        context.close();
    }
}
