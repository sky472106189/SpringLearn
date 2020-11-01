package com.myself.jdbctemplate;

import com.myself.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/*
    JdbcTemplate基于Spring的CRUD操作
*/
public class JdbcTemplateDemo3 {
    public static void main(String[] args) {
        //1.获取容器
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        //2.获取对象
        JdbcTemplate jdbcTemplate = (JdbcTemplate) context.getBean("jdbcTemplate");
        //执行操作
        //插入
        jdbcTemplate.update("insert into account(id,name,money)VALUES (4,'张三',1000)");
        //更新
        jdbcTemplate.update("update account SET name=?,money=? where id=?", "test", 2000, 4);
        //删除
        jdbcTemplate.update("delete from account where name='test'");

        //查询所有
        //方法一：臃肿且要写封装策略
        //List<Account> list = jdbcTemplate.query("select * from account", new AccountRowTemplate());
        //方法二：使用spring自带的封装策略(推荐)
        List<Account> list = jdbcTemplate.query("select * from account", new BeanPropertyRowMapper<Account>(Account.class));
        for(Account a:list){
            System.out.println(a);
        }
        //查询一个
        List<Account> list1 = jdbcTemplate.query("select * from account where id = ?", new BeanPropertyRowMapper<Account>(Account.class),1);
        for(Account a:list1){
            System.out.println(a);
        }

        //返回钱大于999的人数(使用分组函数count)
        Integer i = jdbcTemplate.queryForObject("select count(*) from account where money>?", Integer.class, 999f);
        System.out.println(i);
    }
}

//定义Account的封装策略
class AccountRowTemplate implements RowMapper<Account>{

    /**
     *  把结果集中的数据封装到Account，然后由Spring把每个Account加到集合中
     * @param rs
     * @param i
     * @return
     * @throws SQLException
     */
    @Nullable
    public Account mapRow(ResultSet rs, int i) throws SQLException {
        Account account = new Account();
        account.setId(rs.getInt("id"));
        account.setName(rs.getString("name"));
        account.setMoney(rs.getFloat("money"));
        return account;
    }
}






























