package com.myself.service.impl;

import com.myself.dao.IAccountDao;
import com.myself.domain.Account;
import com.myself.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/*
    业务层实现类
*/
@Service("accountService")
@Transactional
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private IAccountDao accountDao;

    //对查找业务单独设置业务属性
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Account findAccountById(int id) {
        return accountDao.findAccountById(id);
    }

    //对转账业务单独设置事务属性
    @Transactional(propagation = Propagation.REQUIRED,readOnly = false)
    public void transfer(String sourceName, String targetName, Float money) {
        Account source = accountDao.findAccountByName(sourceName);
        Account target = accountDao.findAccountByName(targetName);
        source.setMoney(source.getMoney() - money);
        target.setMoney(target.getMoney() + money);
        accountDao.updateAccount(source);
        accountDao.updateAccount(target);
    }
}
