package com.springboot.study.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.springboot.study.entity.User;

/**
 * @description: 访问数据库的接口
 * @author: chenjun
 * @date: 2020年6月29日 下午2:07:53
 */
public interface UserMapper {

	@Insert("INSERT INTO user (name,age,work,height,weight,country,hobbies,birthday) VALUES (#{name},#{age},#{work},#{height},#{weight}, #{country},#{hobbies},#{birthday})")
	@Options(keyColumn = "id", useGeneratedKeys = true, keyProperty = "id")
	void insert(User user);

	@Select("SELECT * FROM user")
	@Results({ @Result(column = "create_time", property = "createTime") })
	List<User> getAll();

	@Select("SELECT * FROM user WHERE id=#{id}")
	@Results({ @Result(column = "create_time", property = "createTime") })
	User findById(int id);

	@Update("UPDATE user SET name=#{name} WHERE id=#{id}")
	void update(User user);

	@Delete("DELETE FROM user WHERE id=#{id}")
	void delete(int id);

	/**    
	 * @Description: 一对多查询
	 * @param: @param id
	 * @param: @return      
	 * @return: User      
	 * @throws   
	 */
	@Select("SELECT * FROM user WHERE id = #{id}")
	@Results({ @Result(property = "id", column = "id"), // 加此行，否则id值为空
			@Result(property = "bankAccounts", column = "id", many = @Many(select = "com.springboot.study.mapper.AccountMapper.getAccountByUseId")) })
	User getUserWithAccount(int id);

	/**    
	 * @Description: 一对一查询
	 * @param: @param id
	 * @param: @return      
	 * @return: User      
	 * @throws   
	 */
	@Select("SELECT * FROM user WHERE id = #{id}")
	@Results({
			@Result(property = "company", column = "company_id", one = @One(select = "com.springboot.study.mapper.CompanyMapper.getCompanyById")) })
	User getUserWithCompany(int id);

	/**    
	 * @Description: 同时用一对一、一对多查询
	 * @param: @return      
	 * @return: List<User>      
	 * @throws   
	 */
	@Select("SELECT * FROM user")
	@Results({ @Result(property = "id", column = "id"),
			@Result(property = "bankAccounts", column = "id", many = @Many(select = "com.springboot.study.mapper.AccountMapper.getAccountByUseId")),
			@Result(property = "company", column = "company_id", one = @One(select = "com.springboot.study.mapper.CompanyMapper.getCompanyById")) })
	List<User> getUserInfo();
}
