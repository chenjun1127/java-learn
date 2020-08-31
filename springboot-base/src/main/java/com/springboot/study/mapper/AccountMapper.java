package com.springboot.study.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.springboot.study.entity.BankAccount;

/**
 * @Description: TODO
 * @author: chenjun
 * @date: 2020年7月9日 上午9:24:44
 */
public interface AccountMapper {
	@Select("SELECT * FROM `bank_account` WHERE user_id = #{userId}")
	@Results({ @Result(property = "name", column = "name"),@Result(property = "cardNumber", column = "card_number") ,@Result(property = "userId", column = "user_id") })
	List<BankAccount> getAccountByUseId(int id);
}
