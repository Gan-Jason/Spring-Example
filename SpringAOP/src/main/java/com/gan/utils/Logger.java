package com.gan.utils;


/**
 * @ClassName 用于记录日志的工具类，提供公共的代码 
 * @Author Jason
 * @Description //TODO com.gan.utils
 * @Date 11:16 2019/10/2
 * @Version 1.0
 */
public class Logger {
    
    /**
     * @Author Jason
     * @Description //TODO 用于打印日志，计划让其在切入点方法执行之前 执行（切入点方法就是业务层方法）
     * @Date 11:17 2019/10/2
     * @Param []
     * @return void
     */
    public void printLog(){
        System.out.println("Logger printing log");
    }
}
