package com.myself.nonstaticfactory;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/*
    使用实例工厂创建（了解）
*/
public class Test01 {
    @Test
    public void test01(){
        //1.加载spring配置文件，创建对象
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean.xml");
        //2.得到配置创建的对象
        Car car = (Car)context.getBean("car");
        System.out.println(car);
        car.add();
    }
}
