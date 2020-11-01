package com.myself;

import com.myself.dao.IAccountDao;
import com.myself.domain.Account;
import com.myself.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class AccountTest {

    @Resource(name="accountService")
    private IAccountService accountService;
    @Autowired
    private IAccountDao accountDao;

    @Test
    public void test1(){
        accountService.transfer("aaa","bbb",500f);
    }
}
