package com.kiramario.factory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.kiramario.factory.Util.SingleControllerRes;
import com.kiramario.factory.Util.dto.JdPriceInfoDto;
import com.kiramario.factory.Util.dto.UserDto;
import com.kiramario.factory.Util.dto.YsStatistic;
import com.kiramario.factory.Util.staticItems.StandardWxConfig;

public class GetBeansFactory {
	private static ApplicationContext wac = new ClassPathXmlApplicationContext("applicationContext.xml");
	
	public static StandardWxConfig getStandardWxConif(){
		StandardWxConfig instance = (StandardWxConfig)wac.getBean("standardWxConfig");
		return instance; 
	}
	
	public static YsStatistic getYsStatistic(){
		YsStatistic instance = (YsStatistic)wac.getBean("ysStatistic");
		return instance;
	}
	
	public static JdPriceInfoDto getJdPriceInfoDto(){
		JdPriceInfoDto instance = (JdPriceInfoDto)wac.getBean("jdPriceInfoDto");
		return instance;
	}
	
	public static SingleControllerRes getSingleConrollerRes() {
		SingleControllerRes instance = (SingleControllerRes)wac.getBean("singleControllerRes");
		return instance;
	}
	
	public static UserDto getUserDto(){
		UserDto instance = (UserDto)wac.getBean("userDto");
		return instance;
	}
}
