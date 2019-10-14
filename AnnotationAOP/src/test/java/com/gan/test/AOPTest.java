package com.gan.test;


import com.gan.config.Configuration;
import com.gan.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath:bean.xml"})
@ContextConfiguration(classes= Configuration.class)
public class AOPTest {

    @Autowired
    private IAccountService as;

    @Test
    public void testSaveAccount(){
        as.saveAccount();

    }

    @Test
    public void testUpdateAccount(){
        as.updateAccount(2);
    }
}
