package com.example.mybaties.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mybaties.entity.User;
import com.example.mybaties.mapper.UserMapper;
import com.example.mybaties.service.UserService;

/**
 * @Description: TODO
 * @author: chenjun
 * @date: 2020年7月9日 下午4:47:33
 */
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;

	@Override
	public void addUser(User user) {
		userMapper.addUser(user);
	}

	@Override
	public List<User> getAllUserInfo() {
		return userMapper.getAllUserInfo();
	}

	@Override
	public User getUserById(int id) {
		return userMapper.getUserById(id);
	}

	@Override
	public int updateUser(User user) {
		return userMapper.updateUser(user);
	}

	@Override
	public int deleteUserById(int id) {
		return userMapper.deleteUserById(id);
	}
}
