package com.spring.base_learn.entity;

import java.util.Date;

/**
 * @Description: TODO
 * @author: chenjun
 * @date: 2020年7月22日 下午2:12:40
 */
public class Order {
	private int id;
	private String orderNumber;
	private Date createTime = new Date();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", orderNumber=" + orderNumber + ", createTime=" + createTime + "]";
	}
}
