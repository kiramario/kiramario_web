package com.kiramario.factory;

import com.kiramario.factory.Util.StandardWxConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.kiramario.factory.Interf.MysqlConfig;
import com.kiramario.factory.Util.MysqlConnector;

public class StaticApplications {
	private static Logger log = Logger.getLogger(StaticApplications.class);
	private static StandardWxConfig standardWxConfig = null;
	private static MysqlConnector mysqlConnector = null;
	
	public static StandardWxConfig getStandardWxConif(){
		if(standardWxConfig==null){
			standardWxConfig = new StandardWxConfig();
		}
		return standardWxConfig;
	}
	
	public static MysqlConnector getMysqlConnector(){
		Properties properties = new Properties();
		InputStream in = StaticApplications.class.getClassLoader().getResourceAsStream("project.properties");
		try {
			properties.load(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			log.error(e.toString());
		}
		String s = properties.getProperty("envornment");
		
		MysqlConfig config = null;
		if(s.equals("develop")){
			config = GetConfigFactory.getMysqlConfigLocal();
		}else if(s.equals("production")){
			config = GetConfigFactory.getMysqlConfigProduction();
		}
		
		if(mysqlConnector==null){
			mysqlConnector = new MysqlConnector(config);
		}
		return mysqlConnector;
	}
	
	/*public static void main(String[] args) throws IOException{
		
	}*/

}
