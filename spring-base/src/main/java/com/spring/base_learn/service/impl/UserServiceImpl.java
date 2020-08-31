package com.spring.base_learn.service.impl;

import com.spring.base_learn.entity.User;
import com.spring.base_learn.service.UserService;

/**
 * @Description: TODO
 * @author: chenjun
 * @date: 2020年7月23日 上午11:29:54
 */
public class UserServiceImpl implements UserService {

	@Override
	public User save(User user) {
		System.out.println("保存用户");
		user.setId(1);
		user.setName("jack");
		user.setPassword("123456");
		return user;
	}

	@Override
	public User findByid(int id) {
		System.out.println("根据ID查找用户");
		User user = new User();
		user.setId(id);
		user.setName("jack");
		user.setPassword("123456");
		return user;
	}

}
