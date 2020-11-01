package com.myself.service.impl;

import com.myself.dao.IAccountDao;
import com.myself.dao.impl.AccountDaoImpl;
import com.myself.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

/*
    曾经的XML配置：
    <bean id = "accountService" class = "com.myself.service.AccountServiceImpl"
            scope = "" init-method=""  destory-method="">
        <property name ="" value = ""/>
    </bean>

    用于创建对象的
        他们的作用范围和在xml配置文件中编写一个<bean>标签实现的功能是一样的
        @Component：
            作用：用于把当前类对象存入spring容器中
            属性：
                value:用于指定bean的id。不写默认值是当前类名，且首字母改小写
        @Controller：一般用在表现层
        @Service：一般用在业务层
        @Repository：一般用在持久层
            以上三个注解作用和属性与Component一样
            他们三个是spring框架为我们提供明确的三层使用的注解，使我们的三层对象更加清晰

    用于注入数据的
        他们的作用范围和在xml配置文件中写一个<property>标签作用是一样的
        @Autowired:：
            作用：自动按照类型注入。只要容器中只有唯一的一个bean对象要和注入的变量类型匹配，就可以注入成功
                  如果ioc容器中没有任何类型bean和要注入的变量类型匹配，则报错
                  如果ioc容器中有多个类型匹配时：会先找类型，然后根据类型匹配变量名称
            出现位置：
                变量上，方法上
            细节：
                使用注解时，set方法就不是必须的了。

        @Qualifier
            作用：在按照类注入的基础之上再按照名称注入。也就是要和@Autowired一起用
            它在给类成员注入时不能单独使用，但是在给方法参数注入时可以
            属性：
                value：用于指定注入bean的id

        @Resource
            作用：直接按照bean的id注入。它可以独立使用
            属性：
                name:用于指定bean的id。

        @Value
            作用：用于注入基本类型和String类型的数据
            属性：
                value：用于指定数据的值，它可以实现spring中SpEL（spring的el表达式）
                        SpEL语法格式：${表达式}

    用于改变作用范围
        他们的作用就和在bean标签中使用scope属性实现的功能是一样的

    和生命周期相关
        他们的作用就和在bean标签中使用init-method和destory-method是一样的(注解方式默认单例)
        @PreDestroy
            作用：用于指定销毁方法
        @PostConstruct
            作用：用于指定初始化方法
*/
@Service("accountService")
public class AccountServiceImpl implements IAccountService {

//    @Autowired
//    @Qualifier("accountDao")
    @Resource(name = "accountDao")
    private IAccountDao accountdao;

    @PostConstruct
    public void init(){
        System.out.println("已初始化");
    }

    @PreDestroy
    public void destory(){
        System.out.println("已销毁");
    }
    public void saveAccount() {
        accountdao.saveAccount();
    }
}
