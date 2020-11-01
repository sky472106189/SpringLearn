package com.myself.service;

import com.myself.domain.Account;

/*
    账户业务层接口
*/
public interface IAccountService {

    Account findAccountById(int id);

    void transfer(String sourceName, String targetName, Float money);
}
