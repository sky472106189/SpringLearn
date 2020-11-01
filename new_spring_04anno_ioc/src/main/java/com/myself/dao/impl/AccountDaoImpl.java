package com.myself.dao.impl;


import com.myself.dao.IAccountDao;
import org.springframework.stereotype.Repository;

/*
    账户持久层实现类
*/
@Repository("accountDao")
public class AccountDaoImpl implements IAccountDao {
    public void saveAccount() {
        System.out.println("保存账户");
    }
}
