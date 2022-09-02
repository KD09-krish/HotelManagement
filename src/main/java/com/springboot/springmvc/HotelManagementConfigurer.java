package com.springboot.springmvc;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.springboot.springmvc.interceptor.SecurityInterceptor;

@Configuration
public class HotelManagementConfigurer implements WebMvcConfigurer{

	public HotelManagementConfigurer() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new SecurityInterceptor()).addPathPatterns("/secure/*");
	}

}
 