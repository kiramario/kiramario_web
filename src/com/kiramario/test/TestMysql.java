package com.kiramario.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;

import com.kiramario.factory.StaticApplications;
import com.kiramario.factory.Interf.MysqlConfig;
import com.kiramario.factory.Util.dao.mapperInter.IJdPriceInfoDto;
import com.kiramario.factory.Util.dto.JdPriceInfoDto;

public class testMySql {
	private MysqlConfig config = null;
	private Connection con = null;
	
	public testMySql(MysqlConfig config){
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
		}catch(Exception e){
			
		}finally{
			return con;
		}
	}
	
	public void closeConnection(){
		try {
			this.con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		}
	}
	
	public static void main(String[] arg){
	
	}
}
