package com.gan.service.impl;


import com.gan.dao.IAccountDao;
import com.gan.domain.Account;
import com.gan.service.IAccountService;
import com.gan.utils.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName �˻���ҵ���ʵ����
 * @Author Jason
 * @Description //TODO com.gan.service.impl
 * @Date 13:03 2019/9/28
 * @Version 1.0
 */
@Service("accountService")
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private IAccountDao accountDao;




    public List<Account> findAllAccount() {

        return accountDao.findAllAccount();
/*        try{
            //1.��������
            txManager.beginTrasaction();
            //2.ִ�в���
            List<Account> accounts = accountDao.findAllAccount();
            //3.�ύ����
            txManager.commit();
            //4.���ؽ��
            return accounts;

        }catch (Exception e){
            //5.�ع�����
            txManager.rollBack();
            throw new RuntimeException(e);
        }finally {
            //6.�ͷ�����
            txManager.release();
        }*/

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

    public void transfer(String sourceName, String targetName, Float money) {
        System.out.println("transfer....");
            //2.1�������Ʋ�ѯת���˻�
            Account source = accountDao.findAccountByName(sourceName);
            //2.2�������Ʋ�ѯת���˻�
            Account target = accountDao.findAccountByName(targetName);
            //2.3ת���˻���Ǯ
            source.setMoney(source.getMoney()-money);
            //2.4ת���˻���Ǯ
            target.setMoney(target.getMoney()+money);
            //2.5����ת���˻�
            accountDao.updateAccount(source);

            int i=1/0;

            //2.6����ת���˻�
            accountDao.updateAccount(target);
    }
}
