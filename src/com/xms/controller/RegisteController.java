package com.xms.controller;

import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xms.dao.UserDao;
import com.xms.entity.User;

@Controller
@RequestMapping("/registe")
public class RegisteController {
	@Resource
	private UserDao userDao;
	
	@RequestMapping("/toRegiste.do")
	public String toRegiste(){
		
		return "register";
	}
	
	@RequestMapping("/validateEmail.do")
	@ResponseBody
	public boolean validateEmail(String email){
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		User user = userDao.findByEmail(email);
		if(user == null){
			return true;
		}else{
			return false;
		}
	}
	
	@RequestMapping("/createCode.do")
	@ResponseBody
	public boolean createCode(HttpServletRequest request){
		String [] numbers = {"1","2","3","4","5","6","7","8","9","0"};
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i <6; i++) {
			sb.append(numbers[random.nextInt(numbers.length)]);
		}
		System.out.println(sb.toString());
		request.getSession().setAttribute("code", sb.toString());
		return true;
	}
	
	@RequestMapping("/checkCode.do")
	@ResponseBody
	public boolean checkCode(String code,HttpServletRequest request){
		if(code.equals(request.getSession().getAttribute("code"))){
			return true;
		}
		return false;
	}
	@RequestMapping("/registe.do")
	public String registe(User user,HttpServletRequest request){
		
		userDao.save(user);
		
		request.getSession().setAttribute("User", user);
		return "redirect:/main/toIndex.do";
	}
	
}





























