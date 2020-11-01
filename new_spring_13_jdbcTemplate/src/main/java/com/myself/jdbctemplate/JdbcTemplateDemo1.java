package com.myself.jdbctemplate;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/*
    JdbcTemplate最基本用法
*/
public class JdbcTemplateDemo1 {
    public static void main(String[] args) {

        //1.准备数据源,Spring内置数据源
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/eesy_mybatis");
        dataSource.setUsername("root");
        dataSource.setPassword("123");

        //2.创建JdbcTemplate对象
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        //3.装载数据源(方式二:数据源当做参数传入JdbcTemplate构造函数中 )
        jdbcTemplate.setDataSource(dataSource);
        //4.执行操作
        jdbcTemplate.execute("DELETE from account where name = '张三'");

    }
}
