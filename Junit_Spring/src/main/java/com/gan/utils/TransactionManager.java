package com.gan.utils;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 * @ClassName 和事务管理相关的工具类，它包含了开启事务，提交事务，回滚事务，释放连接
 * @Author Jason
 * @Description //TODO com.gan.utils
 * @Date 22:27 2019/9/30
 * @Version 1.0
 */

@Component("txManager")
@Aspect
@EnableAspectJAutoProxy
public class TransactionManager {

    @Pointcut("execution(* com.gan.service.impl.*.*(..))")
    private void pt(){}
    @Autowired
    private ConnectionUtils connectionUtils;


    /**
     * @return void
     * @Author Jason
     * @Description //TODO 开始事务
     * @Date 22:28 2019/9/30
     * @Param []
     */
    //@Before("pt()")
    public void beginTransaction() {

        try {
            connectionUtils.getThreadConnection().setAutoCommit(false);
            System.out.println("----------前置通知");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * @return void
     * @Author Jason
     * @Description //TODO 提交事务
     * @Date 22:29 2019/9/30
     * @Param []
     */
    //@AfterReturning("pt()")
    public void commit() {
        try {
            connectionUtils.getThreadConnection().commit();
            System.out.println("----------后置通知");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @return void
     * @Author Jason
     * @Description //TODO 回滚事务
     * @Date 22:29 2019/9/30
     * @Param []
     */
    //@AfterThrowing("pt()")
    public void rollBack() {
        try {
            connectionUtils.getThreadConnection().rollback();
            System.out.println("----------异常通知");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @return void
     * @Author Jason
     * @Description //TODO 释放连接
     * @Date 22:30 2019/9/30
     * @Param []
     */
    //@After("pt()")
    public void release() {
        try {
            connectionUtils.getThreadConnection().close();//不是真正关闭，而是还回池中
            connectionUtils.removeConnection(); //线程和连接解绑
            System.out.println("----------结束通知");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Around("pt()")
    public Object arroundPrintLog(ProceedingJoinPoint  proceedingJoinPoint){
        Object[] args=null;
        Object rtValue=null;
        try{
            args=proceedingJoinPoint.getArgs();
            this.beginTransaction();
            rtValue=proceedingJoinPoint.proceed(args);
            this.commit();
            return rtValue;
        }catch(Throwable throwable){
            this.rollBack();
            throw new RuntimeException(throwable);
        }finally{
            this.release();
        }
    }



}
