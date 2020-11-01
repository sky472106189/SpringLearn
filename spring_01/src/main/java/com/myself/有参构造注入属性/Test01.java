package com.myself.有参构造注入属性;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {
    @Test
    public void test(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean.xml");
        propertyDemo1 demo1 = (propertyDemo1) context.getBean("demo1");
        demo1.display();//demo1:张三
    }
}
