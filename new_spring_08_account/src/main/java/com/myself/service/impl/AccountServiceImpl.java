package com.myself.service.impl;

import com.myself.dao.IAccountDao;
import com.myself.doman.Account;
import com.myself.service.IAccountService;
import com.myself.untils.TransactionManager;

import java.util.List;

/*
    账户的业务层实现类
    使用代理模式将事务管理交给代理对象BeanFactory
*/
public class AccountServiceImpl implements IAccountService {

    private IAccountDao accountDao;

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public void transfer(String sourceName, String targetName, Float money) {
            Account source = accountDao.findAccountByName(sourceName);
            Account target = accountDao.findAccountByName(targetName);
            source.setMoney(source.getMoney()-money);
            target.setMoney(target.getMoney()+money);
            accountDao.updateAccount(source);
            int i= 1/0;
            accountDao.updateAccount(target);
    }

    public List<Account> findAll() {
            List<Account> accounts = accountDao.findAll();
            return accounts;
    }

    public Account findAccountById(int id) {
            Account account = accountDao.findAccountById(id);
            return account;
    }

    public int insertAccount(Account account) {
            int i = accountDao.insertAccount(account);
            return i;

    }

    public int updateAccount(Account account) {
            int i = accountDao.updateAccount(account);
            return i;
    }

    public int deleteAccount(int id) {
            int i = accountDao.deleteAccount(id);
            //4.返回结果
            return i;
    }
}
