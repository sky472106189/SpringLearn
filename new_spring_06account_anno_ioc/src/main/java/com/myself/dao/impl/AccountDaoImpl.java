package com.myself.dao.impl;

import com.myself.dao.IAccountDao;
import com.myself.doman.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.List;

/*
    账户的持久层实现类
*/

@Repository("accountDao")
public class AccountDaoImpl implements IAccountDao{

    @Resource(name = "queryRunner")
    private QueryRunner runner;

    public List<Account> findAll() {
        try {
            return runner.query("select * from account", new BeanListHandler<Account>(Account.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Account findAccountById(int id) {
        try {
            return runner.query("select * from account where id = ?", new BeanHandler<Account>(Account.class),id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int insertAccount(Account account) {
        try {
            return runner.update("insert into account(id,name,money)values(?,?,?)", account.getId(),account.getName(),account.getId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int updateAccount(Account account) {
        try {
            return runner.update("update account set name=?,money=? where id = ?",account.getName(),account.getMoney(),account.getId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int deleteAccount(int id) {
        try {
            return runner.update("delete from account where id =?",id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
