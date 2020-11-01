package com.myself.ui;

import com.myself.dao.impl.AccountDaoImpl;
import com.myself.service.impl.AccountServiceImpl;
import com.myself.service.impl.User;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Client {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");

        AccountServiceImpl accountService = (AccountServiceImpl) context.getBean("accountService");
        accountService.saveAccount();

        context.close();
    }

    @Test
    public void test01(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        User user = (User) context.getBean("user");
        System.out.println(user);
        user.display();
    }
}
