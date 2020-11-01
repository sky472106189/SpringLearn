package com.myself.xmlanno;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
基于注解+XML方式联合使用
    在service类中同时调用两个dao的方法
*/
public class Test01 {
    @Test
    public void test01(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        BookService bookService = (BookService) context.getBean("bookService");
        bookService.add();
    }
}
