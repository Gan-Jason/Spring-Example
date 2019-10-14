package com.gan.utils;


import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @ClassName ���ڼ�¼��־�Ĺ����࣬�ṩ�����Ĵ���
 * @Author Jason
 * @Description //TODO com.gan.utils
 * @Date 11:16 2019/10/2
 * @Version 1.0
 */
public class Logger {

    /**
     * @return void
     * @Author Jason
     * @Description //TODO ���ڴ�ӡ��־���ƻ�����������㷽��ִ��֮ǰ ִ�У�����㷽������ҵ��㷽����
     * @Date 11:17 2019/10/2
     * @Param []
     * 
     * ǰ��֪ͨ
     */
    public void beforePrintLog() {
        System.out.println("Before printing log");

    }
    
    
/**
 * @Author Jason
 * @Description //TODO ����֪ͨ
 * @Date 12:35 2019/10/2
 * @Param []
 * @return void
 */
    public void afterReturningPrintLog() {
        System.out.println("After returning printing log");

    }

    
    /**
     * @Author Jason
     * @Description //TODO �쳣֪ͨ
     * @Date 12:35 2019/10/2
     * @Param []
     * @return void
     */
    public void afterThrowingPrintLog() {
        System.out.println("Throwing printing log");

    }

    /**
     * @Author Jason
     * @Description //TODO ����֪ͨ
     * @Date 12:36 2019/10/2
     * @Param []
     * @return void
     */
    public void afterPrintLog() {
        System.out.println("After printing log");

    }


    /**
     * @Author Jason
     * @Description //TODO ����֪ͨ
     * @Date 16:58 2019/10/2
     * @Param []
     * @return java.lang.Object
     *
     *
     * Spring���Ϊ�����ṩ��һ���ӿڣ�ProceedingJoinPoint���ýӿ���һ������proceed()���˷������൱����ȷ��������㷽����
     * �ýӿڿ�����Ϊ����֪ͨ�ķ����������ڳ���ִ��ʱ��spring��ܻ�Ϊ�����ṩ�ýӿڵ�ʵ���๩����ʹ�á�
     *
     */
    public Object aroundPrintLog(ProceedingJoinPoint proceedingJoinPoint){

        Object rtValue=null;
        try{
            Object[] args= proceedingJoinPoint.getArgs();//�õ�����ִ������Ĳ���
            System.out.println("Logger���е�aroundPrintLog������ʼ��¼��־�ˡ�----ǰ��֪ͨ");
            rtValue= proceedingJoinPoint.proceed(args);
            System.out.println("Logger���е�aroundPrintLog������ʼ��¼��־�ˡ�----����֪ͨ");
            return rtValue;
        }catch (Throwable throwable){
            System.out.println("Logger���е�aroundPrintLog������ʼ��¼��־�ˡ�----�쳣֪ͨ");
            throw new RuntimeException(throwable);
        }finally {
            System.out.println("Logger���е�aroundPrintLog������ʼ��¼��־�ˡ�----����֪ͨ");
        }


    }
}
