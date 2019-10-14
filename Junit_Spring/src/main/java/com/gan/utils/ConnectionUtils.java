package com.gan.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;


/**
 * @ClassName ���ӵĹ����࣬���ڴ�����Դ�л�ȡһ�����ӣ�����ʵ�ֺ��̵߳İ�
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
            //1.�ȴ�ThreadLocal�ϻ�ȡ
            Connection conn = tl.get();
            //2.�жϵ�ǰ�߳����Ƿ�������
            if (conn == null) {
                //3.������Դ�л�ȡһ�����ӣ����Ҵ���ThreadLocal��
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
