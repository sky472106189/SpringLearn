package com.myself.service.impl;

import com.myself.dao.IAccountDao;
import com.myself.dao.impl.AccountDaoImpl;
import com.myself.factory.BeanFactory;
import com.myself.service.IAccountService;

/*
    账户业务层实现类
*/
public class AccountServiceImpl implements IAccountService {

    //private IAccountDao accountDao = new AccountDaoImpl();
    private IAccountDao accountDao = (IAccountDao) BeanFactory.getBean("accountDao");

    public void saveAccount() {
        accountDao.saveAccount();
    }
}
