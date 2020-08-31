package com.springboot.study.entity;

/**
 * @Description: TODO
 * @author: chenjun
 * @date: 2020年7月8日 下午6:02:27
 */
public class BankAccount {
	private int id;
	private String name;
	private String cardNumber;
	private int userId;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
}
