package com.example.mybaties.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mybaties.entity.User;
import com.example.mybaties.service.UserService;
import com.example.mybaties.utils.JsonData;

/**
 * @Description: UserController
 * @author: chenjun
 * @date: 2020年7月9日 下午4:42:05
 */
@RestController
@RequestMapping("/api")
public class UserController {
	@Autowired
	private UserService userService;

	/**    
	 * @Description: 增加用户 {"name":"Tony","tel":"13800246532","age":25,"weight":98,"height":178}，注意：要用别名传参数
	 * @param: @param user
	 * @param: @return      
	 * @return: JsonData      
	 * @throws   
	 */
	@PostMapping("/user/add")
	public JsonData addUser(@RequestBody User user) {
		userService.addUser(user);
		return JsonData.buildSuccess();
	}

	/**    
	 * @Description: 查询用户所有信息
	 * @param: @return      
	 * @return: JsonData      
	 * @throws   
	 */
	@GetMapping("/users")
	public JsonData getAllUserInfo() {
		List<User> list = userService.getAllUserInfo();
		if (list.size() > 0) {
			return JsonData.buildSuccess(list);
		}
		return JsonData.buildError("暂无数据");
	}

	/**    
	 * @Description: 根据ID来查询用户
	 * @param: @param id
	 * @param: @return      
	 * @return: JsonData      
	 * @throws   
	 */
	@GetMapping("/user/get/{id}")
	public JsonData findById(@PathVariable("id") int id) {
		User user = userService.getUserById(id);
		if (user != null) {
			return JsonData.buildSuccess(user);
		}
		return JsonData.buildError("暂无数据");
	}

	/**    
	 * @Description: 更新用户，注意：需要用动态sql语句，user类里字段定义了别名，传参也需要用别名。{"id":1,"name":"James","age":30,"tel":"13480682697"}
	 * @param: @param user
	 * @param: @return      
	 * @return: JsonData      
	 * @throws   
	 */
	@PutMapping("/user/update")
	public JsonData updateUser(@RequestBody User user) {
		int result = userService.updateUser(user);
		if (result >= 1) {
			return JsonData.buildSuccess("修改成功");
		} else {
			return JsonData.buildSuccess("修改失败");
		}
	}
	
	/**    
	 * @Description: 删除
	 * @param: @param id
	 * @param: @return      
	 * @return: JsonData      
	 * @throws   
	 */
	@GetMapping("/user/delete/{id}")
	public JsonData deleteById(@PathVariable("id") int id) {
		int result = userService.deleteUserById(id);
		if (result >= 1) {
			return JsonData.buildSuccess("删除成功");
		} else {
			return JsonData.buildSuccess("删除失败");
		}
	}
}
