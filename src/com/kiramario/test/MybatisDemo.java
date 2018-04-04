package com.kiramario.test;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.kiramario.factory.Util.dao.mapperInter.IYsStatistic;
import com.kiramario.factory.Util.dao.YsStatistic;

public class MybatisDemo {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String mybatisConfig = "mybatis_kiramario.xml"; 
		
		SqlSessionFactory sqlSessionFactory = null;
		
		SqlSession session = null;
		try{
			InputStream inputStream = Resources.getResourceAsStream(mybatisConfig);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			session = sqlSessionFactory.openSession();
			IYsStatistic ysMapper = session.getMapper(IYsStatistic.class);
			YsStatistic items = new YsStatistic("item_1","item_1_belong");
			ysMapper.insertRecord(items);
			session.commit();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
