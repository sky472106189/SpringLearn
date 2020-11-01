package com.myself.注入复杂类型属性;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {
    @Test
    public void test01(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        animal animals = (animal) context.getBean("animal");
        animals.display();
    }
}
