package com.springboot.study.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.study.entity.User;
import com.springboot.study.utils.JsonData;
import com.springboot.study.utils.JsonUtils;
import com.springboot.study.utils.RedisClient;

/**
 * @Description: redis
 * @author: chenjun
 * @date: 2020年6月30日 上午10:57:49
 */
@RestController
@RequestMapping("/api/redis")
public class RedisController {
	private static final Logger logger = LoggerFactory.getLogger(RedisController.class);
	private Map<String, Object> params = new HashMap<String, Object>();
	@Autowired
	private StringRedisTemplate redisTpl;
	@Autowired
	private RedisClient redisClient;

	/**    
	 * @Description: 采用下面的工具类更方便
	 * @param: @return      
	 * @return: Object      
	 * @throws   
	 */
	@GetMapping("add")
	public Object addRedisData() {
		redisTpl.opsForValue().set("name", "redis test");
		return JsonData.buildSuccess(null, "添加redis数据成功");
	}

	@GetMapping("get")
	public Object getRedisData() {
		String name = redisClient.get("name");
		params.clear();
		params.put("name", name);
		return JsonData.buildSuccess(params, "读取redis数据成功");
	}

	@GetMapping("saveObj")
	public Object saveObj() {
		User user = new User();
		user.setName("Kevin");
		user.setAge(25);
		user.setCountry("China");
		boolean flag = redisClient.set("user", JsonUtils.toString(user));
		logger.info("获取flag [{}]", flag);
		return JsonData.buildSuccess(user, "添加字符串对象成功");
	}

	@GetMapping("getObj")
	public Object getObj() {
		User user = JsonUtils.toBean(redisClient.get("user"), User.class);
		return JsonData.buildSuccess(user, "读取字符串对象成功");
	}

}
