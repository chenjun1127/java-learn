package com.example.mybaties.mapper;

import java.util.List;

import com.example.mybaties.entity.User;

/**
 * @Description: 用户表持久层接口
 * @author: chenjun
 * @date: 2020年7月9日 下午4:48:13
 */
public interface UserMapper {
	public List<User> getAllUserInfo();

	public void addUser(User user);

	public User getUserById(int id);

	public int updateUser(User user);

	public int deleteUserById(int id);
}
