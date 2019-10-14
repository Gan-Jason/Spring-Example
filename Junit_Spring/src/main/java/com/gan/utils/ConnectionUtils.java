package com.gan.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;


/**
 * @ClassName 连接的工具类，用于从数据源中获取一个连接，并且实现和线程的绑定
 * @Author Jason
 * @Description //TODO com.gan.utils
 * @Date 8:01 2019/10/2
 * @Version 1.0
 */

@Component("connectionUtils")
public class ConnectionUtils {
    private ThreadLocal<Connection> tl = new ThreadLocal<>();



    @Autowired
    @Qualifier("dataSource")
    private DataSource dataSource;



    public Connection getThreadConnection() {


        try {
            //1.先从ThreadLocal上获取
            Connection conn = tl.get();
            //2.判断当前线程上是否有连接
            if (conn == null) {
                //3.从数据源中获取一个连接，并且存入ThreadLocal中
                conn = dataSource.getConnection();
                tl.set(conn);
            }
            return conn;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

        /**
         * @Author Jason
         * @Description //TODO removeConnection
         * @Date 22:39 2019/9/30
         * @Param []
         * @return void
         */
    public void removeConnection() {
        tl.remove();
    }
}
