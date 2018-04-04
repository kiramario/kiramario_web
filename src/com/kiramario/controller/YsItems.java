package com.kiramario.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import com.kiramario.factory.GetWxApiRes;
import com.kiramario.factory.Util.WxAuthAccessToken;
import com.kiramario.factory.Util.dao.YsStatistic;
import com.kiramario.factory.Util.dao.mapperInter.IYsStatistic;

public class YsItems {
private static Logger logger = Logger.getLogger(YsItems.class);
	
	public void execute(Map<String, Object> map) throws IOException {
		// TODO Auto-generated method stub
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		HttpServletResponse response = (HttpServletResponse)map.get("response");
		PrintWriter out = response.getWriter();
		
		/*String mybatisConfig = "mybatis_kiramario.xml"; 
		
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
		}*/
		
		
		
		String op = request.getParameter("op");
		out.print("okok");
	}
}
