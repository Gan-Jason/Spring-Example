package com.gan.utils;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 * @ClassName �����������صĹ����࣬�������˿��������ύ���񣬻ع������ͷ�����
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
     * @Description //TODO ��ʼ����
     * @Date 22:28 2019/9/30
     * @Param []
     */
    //@Before("pt()")
    public void beginTransaction() {

        try {
            connectionUtils.getThreadConnection().setAutoCommit(false);
            System.out.println("----------ǰ��֪ͨ");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * @return void
     * @Author Jason
     * @Description //TODO �ύ����
     * @Date 22:29 2019/9/30
     * @Param []
     */
    //@AfterReturning("pt()")
    public void commit() {
        try {
            connectionUtils.getThreadConnection().commit();
            System.out.println("----------����֪ͨ");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @return void
     * @Author Jason
     * @Description //TODO �ع�����
     * @Date 22:29 2019/9/30
     * @Param []
     */
    //@AfterThrowing("pt()")
    public void rollBack() {
        try {
            connectionUtils.getThreadConnection().rollback();
            System.out.println("----------�쳣֪ͨ");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @return void
     * @Author Jason
     * @Description //TODO �ͷ�����
     * @Date 22:30 2019/9/30
     * @Param []
     */
    //@After("pt()")
    public void release() {
        try {
            connectionUtils.getThreadConnection().close();//���������رգ����ǻ��س���
            connectionUtils.removeConnection(); //�̺߳����ӽ��
            System.out.println("----------����֪ͨ");
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
