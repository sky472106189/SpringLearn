package com.myself.ui;

import com.myself.dao.impl.AccountDaoImpl;
import com.myself.service.impl.AccountServiceImpl;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;


/*
    ApplicationContext 接口的三个常用实现类：
        ClassPathXmlApplicationContext：它可以加载类路径下的配置文件。要求：配置文件必须在类路径下，不在的话加载不了。
        FileSystemXmlApplicationContext：它可以加载磁盘任意路径下的配置文件（必须有访问权限）
        AnnotationConfigApplicationContext：它是用于读取注解创建容器的。

    核心容器的两个接口引发出的问题：
     ApplicationContext(单例对象适用**更常用这个方法)
        它在构建核心容器时，创建对象采用的策略是[立即加载]的方式。即：只要一读取配置文件马上就创建配置文件中配置的对象。
     BeanFactory(多例对象适用)
        它在构建核心容器时，创建对象采用的策略是[延迟加载]的方式。即：什么时候根据id获取对象了，什么时候才真正的创建对象。
*/
public class Client {
    public static void main(String[] args) {
        //1.获取核心容器对象
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
//        ApplicationContext context = new FileSystemXmlApplicationContext("C:\\Users\\15173\\IdeaProjects\\spring\\new_spring_01_ioc\\src\\main\\resources\\bean.xml");

        //2.根据id获取bean对象
        AccountServiceImpl accountService = (AccountServiceImpl) context.getBean("accountService");
        AccountDaoImpl accountDao = context.getBean("accountDao",AccountDaoImpl.class);//方法2

        System.out.println(accountService);
        System.out.println(accountDao);
/*
        //-----BeanFactory-------延迟加载----
        Resource resource = new ClassPathResource("bean.xml");
        BeanFactory beanFactory= new XmlBeanFactory(resource);
        AccountServiceImpl accountService = (AccountServiceImpl) beanFactory.getBean("accountService");
        System.out.println(accountService);
        */
    }
}
