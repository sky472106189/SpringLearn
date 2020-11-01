package com.myself.test;

import com.myself.doman.Account;
import com.myself.service.IAccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/*
    使用Junit单元测试，测试我们配置
*/
public class AccountServiceTest {
    @Test
    public void testfindAll(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        IAccountService accountService = (IAccountService) context.getBean("accountService");
        List<Account> all = accountService.findAll();
        for(Account a : all){
            System.out.println(a);
        }
    }
    @Test
    public void testFindOne(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        IAccountService accountService = (IAccountService) context.getBean("accountService");
        Account accountById = accountService.findAccountById(1);
        System.out.println(accountById);
    }
    @Test
    public void testInsert(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        IAccountService accountService = (IAccountService) context.getBean("accountService");
        int i = accountService.insertAccount(new Account(4, "李四", 200));
        System.out.println(i);
    }
    @Test
    public void testUpdate(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        IAccountService accountService = (IAccountService) context.getBean("accountService");
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
