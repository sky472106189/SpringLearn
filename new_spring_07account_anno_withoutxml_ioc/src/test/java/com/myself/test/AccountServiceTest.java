package com.myself.test;

import com.myself.doman.Account;
import com.myself.service.IAccountService;
import config.SpringConfiguration;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/*
    使用Junit单元测试，测试我们的配置
    Spring整合junit配置
        1.导入Spring整合junit的jar(坐标)
        2.使用Junit提供的注解将原有的main方法替换了，替换成Spring提供的
            @Runwith
        3.告知Spring的运行器：ioc是基于XML还是基于注解创建，并且说明位置
            @ContextConfiguration
                location:指定Xml文件位置，加上classpath关键字表示类路径下
                classes:指定注解类所在的位置

        当我们使用Spring 5.x版本时，要求Junit的jar包必须是4.12及以上
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class AccountServiceTest {

    @Autowired
    private IAccountService accountService;

    @Test
    public void testfindAll(){
        List<Account> all = accountService.findAll();
        for(Account a : all){
            System.out.println(a);
        }
    }

    @Test
    public void testFindOne(){
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        IAccountService accountService = (IAccountService) context.getBean("accountService");
        Account accountById = accountService.findAccountById(1);
        System.out.println(accountById);
    }
    @Test
    public void testInsert(){
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        IAccountService accountService = (IAccountService) context.getBean("accountService");
        int i = accountService.insertAccount(new Account(4, "李四", 200));
        System.out.println(i);
    }
    @Test
    public void testUpdate(){
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        IAccountService accountService = (IAccountService) context.getBean("accountService");
        int i = accountService.updateAccount(new Account(4, "王五", 500));
        System.out.println(i);
    }
    @Test
    public void testDelete(){
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        IAccountService accountService = (IAccountService) context.getBean("accountService");
        int i = accountService.deleteAccount(4);
        System.out.println(i);
    }

}
