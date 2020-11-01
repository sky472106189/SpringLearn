package com.myself.test;

import com.myself.doman.Account;
import com.myself.service.IAccountService;
import com.sun.xml.internal.bind.annotation.XmlLocation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;


/*
    使用Junit单元测试，测试我们配置
*/

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:bean.xml")
public class AccountServiceTest {

    @Resource(name = "proxyAccountService")
    private IAccountService accountService;

    @Test
    public void test1(){
        accountService.transfer("aaa","bbb", 500f);
    }
}
