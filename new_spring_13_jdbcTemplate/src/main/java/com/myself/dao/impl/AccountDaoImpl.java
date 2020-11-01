package com.myself.dao.impl;

import com.myself.dao.IAccountDao;
import com.myself.domain.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/*
    持久层实现类
*/
public class AccountDaoImpl implements IAccountDao{

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

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
        return jdbcTemplate.update("UPDATE account SET id=?,name=?,money=?",acc.getId(),acc.getName(),acc.getMoney());
    }
}
