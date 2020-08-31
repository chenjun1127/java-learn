package com.example.mybaties.entity;

/**    
 * @Description: TODO
 * @author: chenjun
 * @date: 2020年7月9日 下午5:11:11    
 */
public class BankAccount {
	private int id;
	private String name;
	private String cardNumber;
	private int userId;
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
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
}
