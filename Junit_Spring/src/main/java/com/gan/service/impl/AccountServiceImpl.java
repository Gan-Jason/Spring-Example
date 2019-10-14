package com.gan.service.impl;


import com.gan.dao.IAccountDao;
import com.gan.domain.Account;
import com.gan.service.IAccountService;
import com.gan.utils.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName 账户的业务层实现类
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
            //1.开启事务
            txManager.beginTrasaction();
            //2.执行操作
            List<Account> accounts = accountDao.findAllAccount();
            //3.提交事务
            txManager.commit();
            //4.返回结果
            return accounts;

        }catch (Exception e){
            //5.回滚操作
            txManager.rollBack();
            throw new RuntimeException(e);
        }finally {
            //6.释放连接
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
            //2.1根据名称查询转出账户
            Account source = accountDao.findAccountByName(sourceName);
            //2.2根据名称查询转入账户
            Account target = accountDao.findAccountByName(targetName);
            //2.3转出账户减钱
            source.setMoney(source.getMoney()-money);
            //2.4转入账户加钱
            target.setMoney(target.getMoney()+money);
            //2.5更新转出账户
            accountDao.updateAccount(source);

            int i=1/0;

            //2.6更新转入账户
            accountDao.updateAccount(target);
    }
}
