package com.myself.service.impl;

import com.myself.dao.IAccountDao;
import com.myself.doman.Account;
import com.myself.service.IAccountService;
import com.myself.untils.TransactionManager;

import java.util.List;

/*
    账户的业务层实现类
*/
public class AccountServiceImpl_old implements IAccountService {

    private IAccountDao accountDao;
    private TransactionManager transactionManager;

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public void setTransactionManager(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    public void transfer(String sourceName, String targetName, Float money) {
        //1.开启事务
        transactionManager.beginTransaction();
        try{
            //2.执行操作
                //2.1 根据名称查询转出账户
                Account source = accountDao.findAccountByName(sourceName);
                //2.2 根据名称查询转入账户
                Account target = accountDao.findAccountByName(targetName);
                //2.3 转出账户减钱
                source.setMoney(source.getMoney()-money);
                //2.4 转入账户加钱
                target.setMoney(target.getMoney()+money);
                //2.5 更新转出账户
                accountDao.updateAccount(source);
                int i= 1/0;
                //2.6 更新转入账户
                accountDao.updateAccount(target);
            //3.提交事务
            transactionManager.commit();
        }catch (Exception e){
            //4.回滚事务
            transactionManager.rollback();
            e.printStackTrace();
        }finally {
            //5.释放连接
            transactionManager.relase();
        }

    }

    public List<Account> findAll() {
        try {
            //1.开启事务
            transactionManager.beginTransaction();
            //2.执行操作
            List<Account> accounts = accountDao.findAll();
            //3.提交事务
            transactionManager.commit();
            //4.返回结果
            return accounts;
        }catch(Exception e) {
            //5.回滚操作
            transactionManager.rollback();
            throw new RuntimeException(e);
        }finally {
            //6.释放连接
            transactionManager.relase();
        }
    }

    public Account findAccountById(int id) {
        try {
            //1.开启事务
            transactionManager.beginTransaction();
            //2.执行操作
            Account account = accountDao.findAccountById(id);
            //3.提交事务
            transactionManager.commit();
            //4.返回结果
            return account;
        }catch(Exception e) {
            //5.回滚操作
            transactionManager.rollback();
            throw new RuntimeException(e);
        }finally {
            //6.释放连接
            transactionManager.relase();
        }
    }

    public int insertAccount(Account account) {
        try {
            //1.开启事务
            transactionManager.beginTransaction();
            //2.执行操作
            int i = accountDao.insertAccount(account);
            //3.提交事务
            transactionManager.commit();
            //4.返回结果
            return i;
        }catch(Exception e) {
            //5.回滚操作
            transactionManager.rollback();
            throw new RuntimeException(e);
        }finally {
            //6.释放连接
            transactionManager.relase();
        }
    }

    public int updateAccount(Account account) {
        try {
            //1.开启事务
            transactionManager.beginTransaction();
            //2.执行操作
            int i = accountDao.updateAccount(account);
            //3.提交事务
            transactionManager.commit();
            //4.返回结果
            return i;
        }catch(Exception e) {
            //5.回滚操作
            transactionManager.rollback();
            throw new RuntimeException(e);
        }finally {
            //6.释放连接
            transactionManager.relase();
        }
    }

    public int deleteAccount(int id) {
        try {
            //1.开启事务
            transactionManager.beginTransaction();
            //2.执行操作
            int i = accountDao.deleteAccount(id);
            //3.提交事务
            transactionManager.commit();
            //4.返回结果
            return i;
        }catch(Exception e) {
            //5.回滚操作
            transactionManager.rollback();
            throw new RuntimeException(e);
        }finally {
            //6.释放连接
            transactionManager.relase();
        }
    }
}
