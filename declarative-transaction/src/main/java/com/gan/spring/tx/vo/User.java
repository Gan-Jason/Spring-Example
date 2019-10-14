/**
 * Welcome to https://waylau.com
 */
package com.gan.spring.tx.vo;

/**
 * @ClassName User
 * @Author Jason
 * @Description //TODO com.waylau.spring.tx.vo
 * @Date 16:31 2019/7/14
 * @Version 1.0
 */
public class User {
	private String username;
	private Integer age;

	public User(String username, Integer age) {
		this.username = username;
		this.age = age;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

}
