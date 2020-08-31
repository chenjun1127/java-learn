package com.example.mybaties.service;

import java.util.List;

import com.example.mybaties.entity.User;

/**
 * @Description: UserService
 * @author: chenjun
 * @date: 2020年7月9日 下午4:45:59
 */

public interface UserService {
	public void addUser(User user);

	public User getUserById(int id);

	public int updateUser(User user);

	public List<User> getAllUserInfo();

	public int deleteUserById(int id);
}
