package com.myself.service.impl;

import com.myself.dao.IAccountDao;
import com.myself.doman.Account;
import com.myself.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/*
    账户的业务层实现类
*/
@Service("accountService")
public class AccountServiceImpl implements IAccountService {

    @Resource(name = "accountDao")
    private IAccountDao accountDao;

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public List<Account> findAll() {
        return accountDao.findAll();
    }

    public Account findAccountById(int id) {
        return accountDao.findAccountById(id);
    }

    public int insertAccount(Account account) {
        return accountDao.insertAccount(account);
    }

    public int updateAccount(Account account) {
        return accountDao.updateAccount(account);
    }

    public int deleteAccount(int id) {
        return accountDao.deleteAccount(id);
    }
}
