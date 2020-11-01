package com.myself.xmlanno;

import javax.annotation.Resource;

public class BookService {

    @Resource(name="bookDao")//注解方式创建对象
    private BookDao bookDao;
    @Resource(name="ordersDao")
    private OrdersDao ordersDao;

    public void add(){
        System.out.println("bookservice");
        bookDao.buybook();
        ordersDao.buy();
    }
}
