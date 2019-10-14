package com.gan.dao;

import com.gan.domain.Account;

import javax.swing.*;

public interface IAccountDao {


    Account findAccountById(Integer accountId);

    Account findAccountByName(String accountName);


    void updateAccount(Account account);

}
