package com.spring.base_learn.service;

import com.spring.base_learn.entity.User;

/**    
 * @Description: TODO
 * @author: chenjun
 * @date: 2020年7月23日 上午11:28:38    
 */
public interface UserService {
	public User save(User user);
	public User findByid(int id);
}
