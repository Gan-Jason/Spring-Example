package com.gan.test;


import com.gan.config.SpringConfiguration;
import com.gan.domain.Account;
import com.gan.service.IAccountService;
import com.gan.service.impl.AccountServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @ClassName 使用Junits单元测试，测试配置
 * @Author Jason
 * @Description //TODO com.gan.test
 * @Date 18:29 2019/9/28
 * @Version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)    //告诉运行器，容器是通过xml还是配置类
public class AccountServiceTest {


    /**
     * IAccountService此时是一个小消费者，从代理商那里买来东西as，此后他的as一切动作都是经过代理商，
     */
    @Autowired
    private IAccountService as;

    @Test
    public void testFindAll() {
//        //1.获取容器
//        //ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
//        ApplicationContext ac= new AnnotationConfigApplicationContext(SpringConfiguration.class);
//        //2.得到业务层对象
//        IAccountService as =  etBean("accountService", IAccountService.class);
        //3.执行方法
        List<Account> accounts = as.findAllAccount();
        for (Account account : accounts) {
            System.out.println(account);
        }

    }

    @Test
    public void testFindOne() {

        //3.执行方法
        Account account = as.findAccountById(1);

        System.out.println(account);

    }

    @Test
    public void testSave() {
        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.得到业务层对象
        IAccountService as = ac.getBean("accountService", IAccountService.class);
        //3.执行方法
        Account aaa = new Account();
        aaa.setId(5);
        aaa.setName("zhangsan");
        aaa.setMoney(888.888f);
        as.saveAccount(aaa);

        System.out.println(as.findAccountById(4));
    }

    @Test
    public void testUpdate() {
        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.得到业务层对象
        IAccountService as = ac.getBean("accountService", IAccountService.class);
        //3.执行方法
        Account account = new Account();
        account.setId(2);
        account.setName("lisi");
        account.setMoney(888888.888888f);
        as.updateAccount(account);
        for (Account a : as.findAllAccount()) {
            System.out.println(a);
        }

    }

    @Test
    public void testDelete() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        IAccountService as = ac.getBean("accountService", AccountServiceImpl.class);
        as.deleteAccount(6);
        for (Account a : as.findAllAccount()) {
            System.out.println(a);
        }

    }


    @Test
    public void testTransfer() {
        as.transfer("aaa", "bbb", -100f);
        List<Account> accounts = as.findAllAccount();
        for (Account account : accounts) {
            System.out.println(account);
        }
    }


}
