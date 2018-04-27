package com.kiramario.factory;

import com.kiramario.factory.Util.dao.mapperInter.IYsStatistic;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import com.kiramario.factory.Interf.MysqlConfig;


public class StaticApplications {
	private static Logger log = Logger.getLogger(StaticApplications.class);
	
	public static SqlSession getMybatisSession(){
		String mybatisConfig = "mybatis_kiramario.xml"; 
		
		SqlSessionFactory sqlSessionFactory = null;
		
		SqlSession session = null; 
		try{
			InputStream inputStream = Resources.getResourceAsStream(mybatisConfig);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			session = sqlSessionFactory.openSession();
		}catch(Exception e){
			e.printStackTrace();
		}
		return session;
	}
	/*public static void main(String[] args) throws IOException{
		
	}*/

}
