/*
package com.gan.factory;

import com.gan.domain.Account;
import com.gan.service.IAccountService;
import com.gan.utils.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;


@Component("beadFactory")
public class Beanfactory {
    @Autowired
    @Qualifier("accountService")
    private IAccountService accountService;
    @Autowired
    private TransactionManager txManager;

    */
/**
     * @Author Jason
     * @Description //TODO 获取service代理对象，此方法是一个AccountServiceImpl的一个代理商
     * @Date 8:24 2019/10/2
     * @Param []
     * @return com.gan.service.IAccountService
     *//*

    @Bean("proxyAccountService")
    public IAccountService getAccountService() {
        return (IAccountService) Proxy.newProxyInstance(accountService.getClass().getClassLoader(),
                accountService.getClass().getInterfaces(),
                new InvocationHandler() {
                    //添加事务的支持
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object rtValue=null;
                        try {
                            //1.开启事务
                            txManager.beginTrasaction();
                            //2.执行操作，当次操作调用过程中出现错误时，则会及时的捕捉到，从而进行事务回滚，而不会继续提交
                            rtValue=method.invoke(accountService,args);
                            //3.提交事务
                            txManager.commit();
                            //4.返回结果
                            return rtValue;

                        } catch (Exception e) {
                            //5.回滚操作
                            txManager.rollBack();
                            throw new RuntimeException(e);
                        } finally {
                            //6.释放连接
                            txManager.release();
                        }
                    }
                });
    }

    public final void setAccountService(IAccountService accountService) {
        this.accountService = accountService;
    }
}


*/
