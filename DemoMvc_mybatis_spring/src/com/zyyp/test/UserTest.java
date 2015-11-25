package com.zyyp.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zyyp.model.User;
import com.zyyp.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml", "classpath:spring-mybatis.xml" })
public class UserTest {

	UserService userService;

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Test
	public void testAddUser() {
		User user = new User();
		user.setUid(3);
		user.setPhone("120");
		user.setPassword("123456");
		user.setCreatetime("2015/01/06");
		System.err.println(userService.addUser(user) == 1 ? "注册成功！" : "注册失败！");
	}

	@Test
	public void testGetUser() {
		User user = new User();
		user.setPhone("120");
		user.setPassword("123456");
		System.err.println(userService.getUser(user) == 1 ? "登录成功！" : "登录失败！");
	}
}
