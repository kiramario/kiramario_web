package com.kiramario.factory;

import java.lang.reflect.Constructor;
import org.apache.log4j.Logger;

import com.kiramario.factory.Util.SingleWxTemplateValue;

public class GetWxTemplateValue {
	private static Logger logger = Logger.getLogger(GetWxTemplateValue.class);
	public static SingleWxTemplateValue getSingleWxTemplateValue(String color,String value){
		Class clazz = null;
		Constructor c = null;
		SingleWxTemplateValue newInstance=null;
		try {
			clazz = Class.forName("com.kiramario.factory.Util.SingleWxTemplateValue");
			c = clazz.getConstructor(String.class,String.class);
			newInstance=(SingleWxTemplateValue)c.newInstance(color,value);
		} catch (Exception e) {
			logger.error(e.toString());
		}
		return newInstance;
	}
}
