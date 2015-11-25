package com.zyyp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyyp.dao.UserMapper;
import com.zyyp.model.User;

@Service("userService")
public class UserServiceImp implements UserService {

	private UserMapper userdao;

	@Autowired
	public void setUserdao(UserMapper userdao) {
		this.userdao = userdao;
	}

	/**
	 * result 0 注册 失败 1 成功
	 */
	@Override
	public int addUser(User user) {
		return userdao.insert(user);
	}

	/**
	 * result 0 : 登陆失败 1 ： 登陆成功
	 */
	@Override
	public int getUser(User user) {
		return userdao.selectByUser(user) == null ? 0 : 1;
	}

}
