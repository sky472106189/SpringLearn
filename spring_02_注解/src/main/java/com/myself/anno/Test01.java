package com.myself.anno;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {
    @Test
    public void test(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean.xml");
        User user = (User) context.getBean("user");
        System.out.println(user);
        user.add();
    }
}
