package config;

import org.springframework.context.annotation.*;


/*
该类是一个配置类，它的作用和bean.xml一样
spring中的新注解：
    @Configuration
        作用：指定当前类是一个配置类
        细节：当配置类作为AnnotationConfigApplicationContext对象创建的参数时，该注解可以不写。
    @ComponentScan
        作用：用于通过注解指定spring在创建容器时要扫描的包
        属性：
            value:它和basePackages作用一样，都是用于指定要扫描的包
            我们使用此注解就等同于在xml中配置了
            <context:component-scan base-package="com.myself"></context:component-scan>

    @Bean:
        作用：用于把当前方法的返回值作为bean对象存入spring的ioc容器中
        属性：
            name:指定bean的id。默认值为当前方法的名称
        细节：
            使用注解配置方法时，如果方法有参数，spring会去容器中查找有没有可用的bean对象
            查找的方式和Autowired一样

    @Import
        作用：用于导入其他的配置类
        属性：
            value:指定需要导入的配置类名,使导入的类可以省略@Configuration

    @PropertySource
        作用：用于指定properties文件位置
        属性：
            value:指定文件名和路径
                    关键字classpath:表示类路径下
*/
@Configuration
@ComponentScan(basePackages = "com.myself")
@Import(JdbcConfig.class)
@PropertySource("classpath:jdbcConfig.properties")
public class SpringConfiguration {

}
