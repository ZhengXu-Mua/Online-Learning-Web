package com.xms.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xms.dao.UserDao;
import com.xms.entity.User;
import com.xms.entity.UserLogin;
import com.xms.exception.PasswordException;
import com.xms.exception.UsernameException;

@Service
public class LoginService {
	
	@Resource
	UserDao userDao;
	public User checkLogin(UserLogin userLogin) {
		if(userLogin.getEmail()==null || userLogin.getEmail().trim()==""){
			throw new UsernameException("账号不能为空");
		}
		User user = userDao.findByEmail(userLogin.getEmail());
		if(user == null){
			throw new UsernameException("账号或密码错误");
		}else if(!user.getPassword().equals(userLogin.getPassword())){
			//密码错误
			throw new PasswordException("账号或密码错误");
		}
		//登录成功
		return user;
	}
}
