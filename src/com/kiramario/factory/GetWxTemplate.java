package com.kiramario.factory;

import org.apache.log4j.Logger;

import com.kiramario.factory.Util.SingleWxTemplate;

public class GetWxTemplate {
	private static Logger logger = Logger.getLogger("getWxTemplate");
	public static SingleWxTemplate getSingleWxTemplate(){
		Class clazz = null;
		SingleWxTemplate instance=null;
		try {
			clazz = Class.forName("com.kiramario.factory.Util.SingleWxTemplate");
			instance = (SingleWxTemplate)clazz.newInstance();
		} catch (ClassNotFoundException |InstantiationException |IllegalAccessException e) {
			// TODO Auto-generated catch block
			logger.error(e.toString());
		}
		return instance;
	}
}
