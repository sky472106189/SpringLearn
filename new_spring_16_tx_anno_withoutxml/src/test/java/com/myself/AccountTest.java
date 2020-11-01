package com.myself;

import com.myself.service.IAccountService;
import config.SpringConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class AccountTest {

    @Resource(name="accountService")
    private IAccountService accountService;

    @Test
    public void test1(){
        accountService.transfer("aaa","bbb",500f);
    }
}
