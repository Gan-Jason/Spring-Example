package com.gan.service.impl;


import com.gan.dao.IAccountDao;
import com.gan.domain.Account;
import com.gan.service.IAccountService;

import java.util.List;

/**
 * @ClassName 账户的业务层实现类
 * @Author Jason
 * @Description //TODO com.gan.service.impl
 * @Date 13:03 2019/9/28
 * @Version 1.0
 */
public class AccountServiceImpl implements IAccountService {

    private IAccountDao accountDao;

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public List<Account> findAllAccount() {
        return accountDao.findAllAccount();
    }

    public Account findAccountById(Integer id) {
        return accountDao.findAccountById(id);
    }

    public void saveAccount(Account account) {
        accountDao.saveAccount(account);
    }

    public void updateAccount(Account account) {
        accountDao.updateAccount(account);
    }

    public void deleteAccount(Integer accountId) {
        accountDao.deleteAccount(accountId);
    }
}
