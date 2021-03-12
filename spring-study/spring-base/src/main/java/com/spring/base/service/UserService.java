package com.spring.base.service;

import com.spring.base.entities.User;

/**
 * @Description: TODO
 * @author: chenjun
 * @date: 2020年7月23日 上午11:28:38
 */
public interface UserService {
    User save(User user);

    User findById(int id);
}
