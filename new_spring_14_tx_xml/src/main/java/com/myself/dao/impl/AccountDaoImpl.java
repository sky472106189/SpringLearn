package com.myself.dao.impl;

import com.myself.dao.IAccountDao;
import com.myself.domain.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

public class AccountDaoImpl extends JdbcDaoSupport implements IAccountDao{

    public Account findAccountById(int id) {
        List<Account> list = super.getJdbcTemplate().query("select * from account where id = ?", new BeanPropertyRowMapper<Account>(Account.class), id);
        if(list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public Account findAccountByName(String name) {
        List<Account> list = super.getJdbcTemplate().query("select * from account where name = ?", new BeanPropertyRowMapper<Account>(Account.class),name);
        if(list.isEmpty()) {
            return null;
        }if(list.size()>1){
            throw new RuntimeException("结果集不唯一");
        }
        return list.get(0);
    }

    public int updateAccount(Account acc) {
        return super.getJdbcTemplate().update("UPDATE account SET name=?,money=?where id=?",acc.getName(),acc.getMoney(),acc.getId());
    }
}
