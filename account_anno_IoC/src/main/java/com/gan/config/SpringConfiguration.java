package com.gan.config;


import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

/**
 * @ClassName 该类是一个配置类，它的作用和xml一样
 * @Author Jason
 * @Description //TODO com.gan.config
 * @Date 21:34 2019/9/28
 * @Version 1.0
 *
 * Spring 中的注解
 * Configuration
 *      作用：
 */

@Configuration//标记为配置类
@ComponentScan("com.gan")   //创建容器时要扫描的包
@PropertySource("jdbcConfig.properties")    //读取配置文件
public class SpringConfiguration {

    @Value("${jdbc.driver}")
    private String driver;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.user} ")
    private String user;
    @Value("")
    private String password;


    /**
     * @Author Jason
     * @Description //TODO 用于创建一个QueryRunner对象
     * @Date 22:02 2019/9/28
     * @Param [dataSource]
     * @return org.apache.commons.dbutils.QueryRunner
     */
    @Bean(name = "runner")
    public QueryRunner createQueryRunner(DataSource dataSource){
        return new QueryRunner(dataSource);
    }


    /**
     * @Author Jason
     * @Description //TODO 创建数据源对象
     * @Date 22:05 2019/9/28
     * @Param []
     * @return javax.sql.DataSource
     */

    @Bean("dataSource")
    public DataSource createDataSource(){
        try{
            ComboPooledDataSource ds=new ComboPooledDataSource();
            ds.setDriverClass(driver);
            ds.setJdbcUrl(url);
            ds.setUser(user);
            ds.setPassword("");
            return ds;
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}
