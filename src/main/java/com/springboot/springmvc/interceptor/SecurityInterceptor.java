package com.springboot.springmvc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

import com.springboot.springmvc.entity.User;

public class SecurityInterceptor implements HandlerInterceptor {

	public SecurityInterceptor() {
		// TODO Auto-generated constructor stub
	}
    
	@Override
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response,Object handler )throws Exception {
	    // object will have room controllers object reference. because the methods are in room controller.
		
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		
		if(user == null) {
			response.sendRedirect("/login");
			return false;
		}
		return true;
	}
}
