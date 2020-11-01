package com.myself.ioc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*

*/
public class TestIOC {
    //原始做法:
    public static void main(String[] args) {
        User user = new User();
        user.add();
    }
    //Spring ioc 控制反转，将控制权移交出去
    @Test
    public void testUser(){
        //1.加载spring配置文件，创建对象
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean.xml");
        //2.得到配置创建的对象
        User user = (User)context.getBean("user");
        System.out.println(user);
        user.add();
    }
}
