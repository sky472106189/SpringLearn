package com.myself.ui;

import com.myself.service.IAccountService;
import com.myself.service.impl.*;
import com.myself.service.impl.AccountServiceImpl2;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
    public static void main(String[] args) {
        //1.获取核心容器对象
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");

        //2.根据id获取bean对象
        IAccountService accountService = (AccountServiceImpl3) context.getBean("accountService3");
        accountService.display();
    }
}
