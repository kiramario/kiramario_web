package com.kiramario.test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class HandlerInterceptor2 extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) throws Exception{
		System.out.println("===========HandlerInterceptor2 preHandle");
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest req, HttpServletResponse res, Object handler,ModelAndView modelAndView) throws Exception{
		System.out.println("===========HandlerInterceptor2 postHandle");  
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex){
		System.out.println("===========HandlerInterceptor2 afterCompletion");  
	}
}
