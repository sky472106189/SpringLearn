package com.myself.set方法注入;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {
    @Test
    public void test(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean.xml");
        Book book = (Book) context.getBean("book");
        book.display();//图书id:101
    }
}
