package com.kiramario.factory;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.kiramario.factory.Interf.ServiceInterf;
import com.kiramario.factory.Util.service.WxApiService;
import com.kiramario.factory.Util.service.UserService;


public class GetServicesFactory {
	private static ApplicationContext wac = new ClassPathXmlApplicationContext("applicationContext.xml");
	private static Logger logger = Logger.getLogger(GetServicesFactory.class);
	
	public static WxApiService getWxApiService(){
		WxApiService instance = (WxApiService)wac.getBean("wxApiService");
		return instance; 
	}
	public static UserService getUserService(){
		UserService instance = (UserService)wac.getBean("userService");
		return instance; 
	}

}
