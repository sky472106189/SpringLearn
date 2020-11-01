package com.myself.dao;

import com.myself.domain.Account;

public interface IAccountDao {

    Account findAccountById(int id);

    Account findAccountByName(String name);

    int updateAccount(Account account);
}
