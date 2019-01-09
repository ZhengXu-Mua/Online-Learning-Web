package com.xms.entity;

import java.sql.Timestamp;



public class User {
	private Integer id;
	private String email;
	private String password;
	private String nickname;
	private Timestamp registedate;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Timestamp getRegistedate() {
		return registedate;
	}
	public void setRegistedate(Timestamp timestamp) {
		this.registedate = timestamp;
	}
	
	
}
