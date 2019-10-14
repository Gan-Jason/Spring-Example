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
     * @Description //TODO ��ȡservice������󣬴˷�����һ��AccountServiceImpl��һ��������
     * @Date 8:24 2019/10/2
     * @Param []
     * @return com.gan.service.IAccountService
     *//*

    @Bean("proxyAccountService")
    public IAccountService getAccountService() {
        return (IAccountService) Proxy.newProxyInstance(accountService.getClass().getClassLoader(),
                accountService.getClass().getInterfaces(),
                new InvocationHandler() {
                    //��������֧��
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object rtValue=null;
                        try {
                            //1.��������
                            txManager.beginTrasaction();
                            //2.ִ�в��������β������ù����г��ִ���ʱ����ἰʱ�Ĳ�׽�����Ӷ���������ع�������������ύ
                            rtValue=method.invoke(accountService,args);
                            //3.�ύ����
                            txManager.commit();
                            //4.���ؽ��
                            return rtValue;

                        } catch (Exception e) {
                            //5.�ع�����
                            txManager.rollBack();
                            throw new RuntimeException(e);
                        } finally {
                            //6.�ͷ�����
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
