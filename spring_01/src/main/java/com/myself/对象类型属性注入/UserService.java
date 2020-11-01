package com.myself.对象类型属性注入;


public class UserService {
    //1.定义dao类型属性
    private UserDao Dao;
    //2.生成set方法
    public void setDao(UserDao dao) {
        Dao = dao;
    }

    public void add(){
        System.out.println("service..");
        //原始的办法，new出来才能调用dao里的方法
//        UserDao dao = new UserDao();
//        dao.add();
        //spring方法
        Dao.add();
    }
}
