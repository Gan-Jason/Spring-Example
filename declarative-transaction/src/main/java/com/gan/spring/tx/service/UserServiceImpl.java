/**
 * Welcome to https://gan.com
 */
package com.gan.spring.tx.service;

import com.gan.spring.tx.vo.User;
import org.springframework.stereotype.Service;

/**
 * @ClassName UserServiceImpl
 * @Author Jason
 * @Description //TODO com.gan.spring.tx.service
 * @Date 16:30 2019/7/14
 * @Version 1.0
 */
@Service("userService")
public class UserServiceImpl implements UserService {

	public void saveUser(User user) {
		throw new UnsupportedOperationException(); // 模拟异常情况
	}

}
