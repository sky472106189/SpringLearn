package com.myself.dao;

import com.myself.doman.Account;

import java.util.List;

/*
    账户的持久层接口
*/
public interface IAccountDao {
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

