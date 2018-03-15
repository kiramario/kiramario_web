package com.kiramario.factory;

import org.apache.log4j.Logger;

import com.kiramario.factory.Util.config.MysqlConfigLocal;
import com.kiramario.factory.Util.config.MysqlConfigProduction;

public class GetConfigFactory {
	private static Logger logger = Logger.getLogger(GetConfigFactory.class);
	
	public static MysqlConfigLocal getMysqlConfigLocal(){	//��ȡ΢�ŵ�accessToken
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
	
	public static MysqlConfigProduction getMysqlConfigProduction(){	//��ȡ΢�ŵ�accessToken
		Class clazz = null;
		MysqlConfigProduction instance =null;
		try{
			clazz = Class.forName("com.kiramario.factory.Util.config.MysqlConfigProduction");
			instance = (MysqlConfigProduction)clazz.newInstance();
		}
		catch(Exception e){
			logger.error(e.toString());
		}
		return instance;
	}
}
