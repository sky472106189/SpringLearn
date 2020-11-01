package com.myself.test;

import com.myself.service.IAccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOPTest {
    @Test
    public void test01(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        IAccountService accountService = (IAccountService) context.getBean("accountService");
        accountService.saveAccount();
    }





//    public static void main(String[] args) {
//        final IAccountService accountService= new AccountServiceImpl();
//
//        IAccountService proxyService = (IAccountService) Proxy.newProxyInstance(accountService.getClass().getClassLoader(),
//                accountService.getClass().getInterfaces(),
//                new InvocationHandler() {
//                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                        Object obj = null;
//                        if ("saveAccount".equals(method.getName())) {
//                            System.out.println("Logger日志开始记录");
//                            obj = method.invoke(accountService, args);
//                            System.out.println("Logger日志记录结束");
//                        }
//                        return obj;
//                    }
//                });
//        proxyService.saveAccount();
//    }
}
