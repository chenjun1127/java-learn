package com.springboot.study.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @description: redis工具类
 * @author: chenjun
 * @date: 2020年6月30日 上午11:08:58
 */
@Component
public class RedisClient {
	@Autowired
	private StringRedisTemplate redisTpl;

	public boolean set(String key, String value) {
		try {
			redisTpl.opsForValue().set(key, value);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public String get(String key) {
		return redisTpl.opsForValue().get(key);
	}

}
