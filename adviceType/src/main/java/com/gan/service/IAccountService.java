package com.gan.service;

public interface IAccountService {
    /**
     * ģ�Ᵽ���˻�
     */
    void saveAccount();

    /**
     * ģ������˻�
     *
     * @param i
     */
    void updateAccount(int i);

    /**
     * ɾ���˻�
     *
     * @return
     */
    int deleteAccount();

}
