package com.springboot.study.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.study.entity.User;
import com.springboot.study.mapper.UserMapper;
import com.springboot.study.service.UserService;

/**
 * @description: user接口实现
 * @author: chenjun
 * @date: 2020年6月29日 下午2:35:34
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	public UserMapper userMapper;

	@Override
	public void add(User user) {
		userMapper.insert(user);
	}

	@Override
	public List<User> getAll() {
		return userMapper.getAll();
	}

	@Override
	public User findById(int id) {
		return userMapper.findById(id);
	}

	@Override
	public void delete(int id) {
		userMapper.delete(id);
	}

	@Override
	public void update(User user) {
		userMapper.update(user);
	}

	@Override
	public User getUserWithAccount(int id) {
		return userMapper.getUserWithAccount(id);
	}

	@Override
	public User getUserWithCompany(int id) {
		return userMapper.getUserWithCompany(id);
	}

	@Override
	public List<User> getUserInfo() {
		return userMapper.getUserInfo();
	}
}
