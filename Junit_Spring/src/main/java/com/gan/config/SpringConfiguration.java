package com.gan.config;


import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;

/**
 * @ClassName ������һ�������࣬�������ú�xmlһ��
 * @Author Jason
 * @Description //TODO com.gan.config
 * @Date 21:34 2019/9/28
 * @Version 1.0
 *
 * Spring �е�ע��
 * Configuration
 *      ���ã�
 */

@Configuration//���Ϊ������
@ComponentScan("com.gan")   //��������ʱҪɨ��İ�
@PropertySource("classpath:jdbcConfig.properties")    //��ȡ�����ļ�
public class SpringConfiguration {

    @Value("${jdbc.driver}")
    private String driver;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.user}")
    private String user;
    @Value("${jdbc.password}")
    private String password;


    /**
     * @Author Jason
     * @Description //TODO ���ڴ���һ��QueryRunner����
     * @Date 22:02 2019/9/28
     * @Param [dataSource]
     * @return org.apache.commons.dbutils.QueryRunner
     */
    @Bean(name = "runner")
    @Scope("prototype")
    public QueryRunner createQueryRunner(@Qualifier("dataSource")DataSource dataSource){
        return new QueryRunner(dataSource);
    }


    /**
     * @Author Jason
     * @Description //TODO ��������Դ����
     * @Date 22:05 2019/9/28
     * @Param []
     * @return javax.sql.DataSource
     */
    //�ѵ�ǰ�����ķ���ֵ��Ϊbean������������У�value��bean��id��Ĭ���Ƿ�����
    @Bean("dataSource")
    public DataSource createDataSource(){
        try{
            //System.out.println("password="+password);
            ComboPooledDataSource ds=new ComboPooledDataSource();
            ds.setDriverClass(driver);
            ds.setJdbcUrl(url);
            ds.setUser(user);
            ds.setPassword(password);
            return ds;
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}
