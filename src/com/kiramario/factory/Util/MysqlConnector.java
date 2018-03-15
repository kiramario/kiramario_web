package com.kiramario.factory.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.log4j.Logger;

import com.kiramario.factory.Interf.DataBaseInterf;
import com.kiramario.factory.Interf.MysqlConfig;

public class MysqlConnector implements DataBaseInterf{
	private static Logger log = Logger.getLogger(MysqlConnector.class);
	private MysqlConfig config = null;
	private Connection con = null;
	
	public MysqlConnector(MysqlConfig config){
		this.config=config;
	}
	
	public Connection getConnection(){
		try{
			Class.forName(config.getDriver());
			con = DriverManager.getConnection(config.getUrl(),config.getUser(),config.getPassword());
/*			if(!con.isClosed()){
				System.out.println("Succeeded connecting to the Database!");
			}*/
		}catch(ClassNotFoundException e){
			//数据库驱动类异常处理
			log.error("Sorry,can`t find the Driver! "+e.toString());
		}catch(Exception e){
			log.error(e.toString());
		}finally{
			return con;
		}
	}
	
	public void closeConnection(){
		try {
			this.con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			log.error(e.toString());
		}
	}
	
}
