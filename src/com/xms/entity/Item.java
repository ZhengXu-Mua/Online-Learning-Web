package com.xms.entity;

import java.sql.Timestamp;

public class Item {
	 private int id;
	 private int c_id;
	 private String c_name;
	 private String c_picture_url;
	 private Double c_price;
	 private Timestamp add_time;
	 private Timestamp remove_time;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getC_id() {
		return c_id;
	}
	public void setC_id(int cId) {
		c_id = cId;
	}
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String cName) {
		c_name = cName;
	}
	public String getC_picture_url() {
		return c_picture_url;
	}
	public void setC_picture_url(String cPictureUrl) {
		c_picture_url = cPictureUrl;
	}
	public Double getC_price() {
		return c_price;
	}
	public void setC_price(Double cPrice) {
		c_price = cPrice;
	}
	public Timestamp getAdd_time() {
		return add_time;
	}
	public void setAdd_time(Timestamp addTime) {
		add_time = addTime;
	}
	public Timestamp getRemove_time() {
		return remove_time;
	}
	public void setRemove_time(Timestamp removeTime) {
		remove_time = removeTime;
	}
	 
}
