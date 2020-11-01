package com.myself.test;

import com.myself.doman.Account;
import com.myself.service.IAccountService;
import com.sun.xml.internal.bind.annotation.XmlLocation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/*
    使用Junit单元测试，测试我们配置
*/

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
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
        Account accountById = accountService.findAccountById(1);
        System.out.println(accountById);
    }
    @Test
    public void testInsert(){
        int i = accountService.insertAccount(new Account(4, "李四", 200));
        System.out.println(i);
    }
    @Test
    public void testUpdate(){
        int i = accountService.updateAccount(new Account(4, "王五", 500));
        System.out.println(i);
    }
    @Test
    public void testDelete(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        IAccountService accountService = (IAccountService) context.getBean("accountService");
        int i = accountService.deleteAccount(4);
        System.out.println(i);
    }
}
