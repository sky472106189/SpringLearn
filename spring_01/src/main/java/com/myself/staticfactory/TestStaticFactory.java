package com.myself.staticfactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
    使用静态工厂创建（了解）
*/
public class TestStaticFactory {
    @Test
    public void test1(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean.xml");
        Car car = (Car) context.getBean("carFactory");
        System.out.println(car);
        car.add();
    }
}
