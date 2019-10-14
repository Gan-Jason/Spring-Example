package com.gan.service;

import com.gan.domain.Account;

import java.util.List;

public interface IAccountService {
    /**
     * @Author Jason
     * @Description //TODO ��ѯ����
     * @Date 12:58 2019/9/28
     * @Param []
     * @return java.util.List<com.gan.domain.Account>
     */
    List<Account> findAllAccount();
    
    /**
     * @Author Jason
     * @Description //TODO ��ѯһ��
     * @Date 12:58 2019/9/28
     * @Param []
     * @return java.util.List<com.gan.domain.Account>
     */
    Account findAccountById(Integer id);
    
    /**
     * @Author Jason
     * @Description //TODO ����һ��
     * @Date 12:59 2019/9/28
     * @Param [account]
     * @return void
     */
    void saveAccount(Account account);
    
    /**
     * @Author Jason
     * @Description //TODO ����
     * @Date 12:59 2019/9/28
     * @Param [account]
     * @return void
     */
    void updateAccount(Account account);
    
    
    
    /**
     * @Author Jason
     * @Description //TODO ɾ��
     * @Date 13:07 2019/9/28
     * @Param [accountId]
     * @return void
     */
    void deleteAccount(Integer accountId);

    
}
