package com.myself.test;

import com.myself.service.IAccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOPTest {
    @Test
    public void test01(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        IAccountService accountService = (IAccountService) context.getBean("accountService");
        accountService.updateAccount(1);
    }
}
