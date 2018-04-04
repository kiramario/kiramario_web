package com.kiramario.factory;

import org.apache.log4j.Logger;

import com.kiramario.factory.Util.dao.JdPriceInfoDao;
import com.kiramario.factory.Util.dao.YsStatistic;


public class GetDaoFactory {
	private static Logger logger = Logger.getLogger(GetDaoFactory.class);
	
	public static JdPriceInfoDao getJdPriceInfoDao(){	
		Class clazz = null;
		JdPriceInfoDao instance =null;
		try{
			clazz = Class.forName("com.kiramario.factory.Util.dao.JdPriceInfoDao");
			instance = (JdPriceInfoDao) clazz.newInstance();
		}
		catch(Exception e){
			logger.error(e.toString());
		}
		return instance;
	}
	
	public static YsStatistic getYsStatistic(){
		Class clazz = null;
		YsStatistic instance =null;
		try{
			clazz = Class.forName("com.kiramario.factory.Util.dao.YsStatistic");
			instance = (YsStatistic) clazz.newInstance();
		}
		catch(Exception e){
			logger.error(e.toString());
		}
		return instance;
	}
}
