package com.myself.untils;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;

/*
    连接工具类，用于从数据源中获取一个连接，并且实现和线程的绑定
*/
@Component("connectionUtils")
public class ConnectionUtils {

    private ThreadLocal<Connection> tl = new ThreadLocal<Connection>();

    @Resource(name = "datasource")
    private DataSource dataSource;

    /**
     * 获取当前线程上的连接
     * @return
     */
    public Connection getThreadConnection() {
        try {
            //1.先从ThreadLocal上获取
            Connection con = tl.get();
            //2.判断当前线程上是否有连接
            if (con == null) {
                //3.从数据源获取一个连接，并且存入ThreadLocal中
                con = dataSource.getConnection();
                tl.set(con);
            }
            //4.返回当前线程连接
            return con;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 把连接和线程解绑
     */
    public void removeConnection(){
        tl.remove();
    }
}
