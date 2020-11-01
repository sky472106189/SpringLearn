package com.myself.dao.impl;

import com.myself.dao.IAccountDao;
import com.myself.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("accountDao")
public class AccountDaoImpl implements IAccountDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Account findAccountById(int id) {
        List<Account> list = jdbcTemplate.query("select * from account where id = ?", new BeanPropertyRowMapper<Account>(Account.class), id);
        if(list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public Account findAccountByName(String name) {
        List<Account> list = jdbcTemplate.query("select * from account where name = ?", new BeanPropertyRowMapper<Account>(Account.class),name);
        if(list.isEmpty()) {
            return null;
        }if(list.size()>1){
            throw new RuntimeException("结果集不唯一");
        }
        return list.get(0);
    }

    public int updateAccount(Account acc) {
        return jdbcTemplate.update("UPDATE account SET name=?,money=?where id=?",acc.getName(),acc.getMoney(),acc.getId());
    }
}
