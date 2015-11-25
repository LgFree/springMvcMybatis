package com.zyyp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zyyp.model.User;
import com.zyyp.service.UserService;

@Controller
@RequestMapping("userController")
public class UserController {

	public UserService userService;

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping("reg")
	public String regAction(User user) {
		return userService.addUser(user) == 1 ? "success" : "fail";
	}

	@RequestMapping("login")
	public String loginAction(User user) {
		return userService.getUser(user) == 1 ? "success" : "fail";
	}

}
