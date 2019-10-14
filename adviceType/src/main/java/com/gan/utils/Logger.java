package com.gan.utils;


import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @ClassName 用于记录日志的工具类，提供公共的代码
 * @Author Jason
 * @Description //TODO com.gan.utils
 * @Date 11:16 2019/10/2
 * @Version 1.0
 */
public class Logger {

    /**
     * @return void
     * @Author Jason
     * @Description //TODO 用于打印日志，计划让其在切入点方法执行之前 执行（切入点方法就是业务层方法）
     * @Date 11:17 2019/10/2
     * @Param []
     * 
     * 前置通知
     */
    public void beforePrintLog() {
        System.out.println("Before printing log");

    }
    
    
/**
 * @Author Jason
 * @Description //TODO 后置通知
 * @Date 12:35 2019/10/2
 * @Param []
 * @return void
 */
    public void afterReturningPrintLog() {
        System.out.println("After returning printing log");

    }

    
    /**
     * @Author Jason
     * @Description //TODO 异常通知
     * @Date 12:35 2019/10/2
     * @Param []
     * @return void
     */
    public void afterThrowingPrintLog() {
        System.out.println("Throwing printing log");

    }

    /**
     * @Author Jason
     * @Description //TODO 最终通知
     * @Date 12:36 2019/10/2
     * @Param []
     * @return void
     */
    public void afterPrintLog() {
        System.out.println("After printing log");

    }


    /**
     * @Author Jason
     * @Description //TODO 环绕通知
     * @Date 16:58 2019/10/2
     * @Param []
     * @return java.lang.Object
     *
     *
     * Spring框架为我们提供了一个接口：ProceedingJoinPoint。该接口有一个方法proceed()，此方法就相当于明确调用切入点方法。
     * 该接口可以作为环绕通知的方法参数，在程序执行时，spring框架会为我们提供该接口的实现类供我们使用。
     *
     */
    public Object aroundPrintLog(ProceedingJoinPoint proceedingJoinPoint){

        Object rtValue=null;
        try{
            Object[] args= proceedingJoinPoint.getArgs();//得到方法执行所需的参数
            System.out.println("Logger类中的aroundPrintLog方法开始记录日志了。----前置通知");
            rtValue= proceedingJoinPoint.proceed(args);
            System.out.println("Logger类中的aroundPrintLog方法开始记录日志了。----后置通知");
            return rtValue;
        }catch (Throwable throwable){
            System.out.println("Logger类中的aroundPrintLog方法开始记录日志了。----异常通知");
            throw new RuntimeException(throwable);
        }finally {
            System.out.println("Logger类中的aroundPrintLog方法开始记录日志了。----最终通知");
        }


    }
}
