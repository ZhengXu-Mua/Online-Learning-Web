package com.xms.dao;


import com.xms.annotation.MyAnnotation;
import com.xms.entity.User;

@MyAnnotation
public interface UserDao {
	
	User findByEmail(String email);

	void save(User user);

}
