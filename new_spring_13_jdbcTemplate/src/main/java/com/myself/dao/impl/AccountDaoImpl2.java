package com.myself.dao.impl;

import com.myself.dao.IAccountDao;
import com.myself.domain.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

/*
    继承JdbcDaoSupport可以省略JdbcTemplate的书写
    优点：美观
    缺点：使用注解开发很麻烦
    注意：要在配置文件中配置DriverManagerDataSource,不然找不到你要的数据库连接
*/
public class AccountDaoImpl2 extends JdbcDaoSupport implements IAccountDao{

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
        return super.getJdbcTemplate().update("UPDATE account SET id=?,name=?,money=?",acc.getId(),acc.getName(),acc.getMoney());
    }
}
