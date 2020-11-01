package com.myself.dao;

import com.myself.doman.Account;

import java.util.List;

/*
    账户的持久层接口
*/
public interface IAccountDao {

    /**
     * 根据名称查账户
     * @param accountName 账户名称
     * @return  账户有一个就返回，没有结果就返回null
     *           结果超过一个就抛出异常
     */
    Account findAccountByName(String accountName);

    //查询所有
    List<Account> findAll();

    //根据id查
    Account findAccountById(int id);

    //插入
    int insertAccount(Account account);

    //更新
    int updateAccount(Account account);

    //删除
    int deleteAccount(int id);
}

