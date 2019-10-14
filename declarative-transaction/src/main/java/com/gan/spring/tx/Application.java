/**
 * Welcome to https://waylau.com
 */
package com.gan.spring.tx;

import com.gan.spring.tx.service.UserService;
import com.gan.spring.tx.vo.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName Application
 * @Author Jason
 * @Description //TODO
 * @Date 16:32 2019/7/14
 * @Version 1.0
 */
public class Application {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		UserService UserService = (UserService)context.getBean("userService");
		UserService.saveUser(new User("Way Lau", 30));
	}

}
