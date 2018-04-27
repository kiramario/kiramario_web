package com.kiramario.webInit;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FilterTest implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("destroy of filtertest");  
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		System.out.println("FilterTest第一次拦截");         
		
		/*response.setContentType("text/plain;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write("sss");*/
		chain.doFilter(request, response);
		
		System.out.println("FilterTest第二次拦截");    
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("init of filtertest");
		
	}

}
