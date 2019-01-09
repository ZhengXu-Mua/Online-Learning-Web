package com.xms.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.xms.entity.User;
import com.xms.entity.UserLogin;
import com.xms.exception.PasswordException;
import com.xms.exception.UsernameException;
import com.xms.service.LoginService;

@Controller
@RequestMapping("/login")
public class LoginController {
	@Resource
	private LoginService service;
	
	@RequestMapping("/login.do")
	public ModelAndView login()throws Exception{
		
		return new ModelAndView("login");
	}
	
	@RequestMapping("/toLogin.do")
	public ModelAndView toLogin(UserLogin userLogin ,HttpServletRequest request){
		User user = service.checkLogin(userLogin);
		request.getSession().setAttribute("User", user);
		return new ModelAndView("redirect:/main/toIndex.do");
	}
	
	@RequestMapping("/loginOut.do")
	public String loginOut(HttpServletRequest request){
		HttpSession session = request.getSession();
		//session.setAttribute("User", null);
		session.invalidate();
		return "redirect:/main/toIndex.do";
		
	}
	
	@ExceptionHandler
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Exception ex) {
		if(ex instanceof PasswordException){
			request.setAttribute("message", ex.getMessage());
		}else if(ex instanceof UsernameException){
			request.setAttribute("message", ex.getMessage());
		}
		return new ModelAndView("login");
	}
	
}
