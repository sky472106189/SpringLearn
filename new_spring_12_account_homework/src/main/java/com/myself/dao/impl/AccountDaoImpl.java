package com.myself.dao.impl;

import com.myself.dao.IAccountDao;
import com.myself.doman.Account;
import com.myself.untils.ConnectionUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.List;

/*
    账户的持久层实现类
*/
@Component("accountDao")
public class AccountDaoImpl implements IAccountDao{

    @Resource(name = "queryRunner")
    private QueryRunner runner;
    @Resource(name = "connectionUtils")
    private ConnectionUtils connectionUtils;

    public Account findAccountByName(String accountName) {
        try {
            List<Account> accounts = runner.query(connectionUtils.getThreadConnection(),"select * from account where name = ?", new BeanListHandler<Account>(Account.class),accountName);
            if(accounts==null||accounts.size()==0){
                return null;
            }
            if(accounts.size()>1){
                throw new RuntimeException("结果集不唯一,数据有问题");
            }
            return accounts.get(0);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Account> findAll() {
        try {
            return runner.query(connectionUtils.getThreadConnection(),"select * from account", new BeanListHandler<Account>(Account.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Account findAccountById(int id) {
        try {
            return runner.query(connectionUtils.getThreadConnection(),"select * from account where id = ?", new BeanHandler<Account>(Account.class),id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int insertAccount(Account account) {
        try {
            return runner.update(connectionUtils.getThreadConnection(),"insert into account(id,name,money)values(?,?,?)", account.getId(),account.getName(),account.getId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int updateAccount(Account account) {
        try {
            return runner.update(connectionUtils.getThreadConnection(),"update account set name=?,money=? where id = ?",account.getName(),account.getMoney(),account.getId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int deleteAccount(int id) {
        try {
            return runner.update(connectionUtils.getThreadConnection(),"delete from account where id =?",id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
