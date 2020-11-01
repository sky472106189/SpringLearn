package com.myself.jdbctemplate;

import com.myself.dao.impl.AccountDaoImpl;
import com.myself.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
    JdbcTemplate基于spring用法
*/
public class JdbcTemplateDemo4 {
    public static void main(String[] args) {
        //获取容器
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        AccountDaoImpl accountDao = (AccountDaoImpl) context.getBean("accountDao");
        Account byId = accountDao.findAccountById(1);
        System.out.println(byId);

    }
}
