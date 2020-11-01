package com.myself.jdbctemplate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/*
    JdbcTemplate基于spring用法
*/
public class JdbcTemplateDemo2 {
    public static void main(String[] args) {
        //获取容器
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        JdbcTemplate jdbcTemplate = (JdbcTemplate) context.getBean("jdbcTemplate");
        jdbcTemplate.execute("DELETE FROM account where name = '张三'");

    }
}
