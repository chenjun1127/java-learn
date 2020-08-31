package com.springboot.study.mapper;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.springboot.study.entity.Company;

/**
 * @Description: TODO
 * @author: chenjun
 * @date: 2020年7月9日 下午1:47:20
 */
public interface CompanyMapper {
	/*
	 * 根据公司id查询公司信息
	 */
	@Select("SELECT * FROM company WHERE id = #{id}")
	@Results({ @Result(property = "companyName", column = "name") })
	Company getCompanyById(int id);
}