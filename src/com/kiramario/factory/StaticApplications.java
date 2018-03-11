package com.kiramario.factory;

import com.kiramario.factory.Util.StandardWxConfig;
import com.kiramario.factory.Util.config.MysqlConfigLocal;
import com.kiramario.factory.Util.MysqlConnector;

public class StaticApplications {
	private static StandardWxConfig standardWxConfig = null;
	private static MysqlConnector localMysqlConnector = null;
	
	public static StandardWxConfig getStandardWxConif(){
		if(standardWxConfig==null){
			standardWxConfig = new StandardWxConfig();
		}
		return standardWxConfig;
	}
	
	public static MysqlConnector getMysqlConnectorLocal(){
		MysqlConfigLocal config = GetConfigFactory.getMysqlConfigLocal();
		if(localMysqlConnector==null){
			localMysqlConnector = new MysqlConnector(config);
		}
		return localMysqlConnector;
	}
}
