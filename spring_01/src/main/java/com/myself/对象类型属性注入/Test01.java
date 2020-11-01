package com.myself.对象类型属性注入;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {
    @Test
    public void test(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean.xml");
        UserService service = (UserService) context.getBean("service");
        service.add();
        /*  service..
            dao......*/
    }
}
