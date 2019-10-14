package com.gan.service.impl;

import com.gan.service.IAccountService;

public class AccountServiceImpl implements IAccountService {
    @Override
    public void saveAccount() {
        System.out.println("Executed saving");
    }

    @Override
    public void updateAccount(int i) {
        System.out.println("Executed updating");
    }

    @Override
    public int deleteAccount() {
        System.out.println("Executed deleting");
        return 0;
    }
}
