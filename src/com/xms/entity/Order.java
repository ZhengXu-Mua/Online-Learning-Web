package com.xms.entity;

import java.sql.Timestamp;

public class Order {
	private Integer id;
	private Integer u_id;
	private Timestamp order_time;
	private Double total_price;
	private String pay_type;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getU_id() {
		return u_id;
	}
	public void setU_id(Integer uId) {
		u_id = uId;
	}
	public Timestamp getOrder_time() {
		return order_time;
	}
	public void setOrder_time(Timestamp orderTime) {
		order_time = orderTime;
	}
	public Double getTotal_price() {
		return total_price;
	}
	public void setTotal_price(Double totalPrice) {
		total_price = totalPrice;
	}
	public String getPay_type() {
		return pay_type;
	}
	public void setPay_type(String payType) {
		pay_type = payType;
	}
	
}
