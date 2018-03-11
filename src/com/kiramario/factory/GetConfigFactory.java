package com.kiramario.factory;

import org.apache.log4j.Logger;

import com.kiramario.factory.Interf.MysqlConfig;
import com.kiramario.factory.Util.config.MysqlConfigLocal;

public class GetConfigFactory {
	private static Logger logger = Logger.getLogger(GetConfigFactory.class);
	
	public static MysqlConfigLocal getMysqlConfigLocal(){	//获取微信的accessToken
		Class clazz = null;
		MysqlConfigLocal instance =null;
		try{
			clazz = Class.forName("com.kiramario.factory.Util.config.MysqlConfigLocal");
			instance = (MysqlConfigLocal)clazz.newInstance();
		}
		catch(Exception e){
			logger.error(e.toString());
		}
		return instance;
	}
}
