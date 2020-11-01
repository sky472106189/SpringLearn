package com.myself.注解注入属性;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {
    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        UserService userService = (UserService) context.getBean("userService");
        System.out.println(userService);
        userService.add();
    }
}
