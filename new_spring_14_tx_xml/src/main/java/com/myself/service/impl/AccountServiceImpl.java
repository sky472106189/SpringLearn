package com.myself.service.impl;

import com.myself.dao.IAccountDao;
import com.myself.domain.Account;
import com.myself.service.IAccountService;

/*
    业务层实现类
*/
public class AccountServiceImpl implements IAccountService {

    private IAccountDao accountDao;

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public Account findAccountById(int id) {
        return accountDao.findAccountById(id);
    }

    public void transfer(String sourceName, String targetName, Float money) {
        Account source = accountDao.findAccountByName(sourceName);
        Account target = accountDao.findAccountByName(targetName);
        source.setMoney(source.getMoney() - money);
        target.setMoney(target.getMoney() + money);
        accountDao.updateAccount(source);
        accountDao.updateAccount(target);
    }
}
