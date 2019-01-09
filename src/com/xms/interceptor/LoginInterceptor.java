package com.xms.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter{

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object obj) throws Exception {
		if(request.getSession().getAttribute("User")!=null){
			
			return true;	
		}else{
			
			//判断是否是Ajax异步请求
			String XRequested = request.getHeader("X-Requested-With");
			if("XMLHttpRequest".equals(XRequested)){
				//表明是Ajax异步请求
				
				response.getWriter().print("IsAjax");
			}else{
				response.sendRedirect("/XMSCode_SSM_V1/login/login.do");				
			}
			
			return false;
		}
	}
}
