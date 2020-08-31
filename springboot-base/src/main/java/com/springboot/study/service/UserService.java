package com.springboot.study.service;

import java.util.List;

import com.springboot.study.entity.User;

/**
 * @description: user接口
 * @author: chenjun
 * @date: 2020年6月29日 下午2:31:38
 */
public interface UserService {

	public void add(User user);

	public List<User> getAll();

	public User findById(int id);

	public void update(User user);

	public void delete(int id);

	public User getUserWithAccount(int id);

	public User getUserWithCompany(int id);
	
	public List<User>  getUserInfo();
}
