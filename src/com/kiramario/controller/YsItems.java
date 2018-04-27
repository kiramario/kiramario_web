package com.kiramario.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.alibaba.fastjson.JSON;
import com.kiramario.factory.GetBeansFactory;
import com.kiramario.factory.StaticApplications;
import com.kiramario.factory.Util.SingleControllerRes;
import com.kiramario.factory.Util.dao.mapperInter.IYsStatistic;
import com.kiramario.factory.Util.dto.YsStatistic;

@Controller
@RequestMapping("/s/ysitems")
public class YsItems {
	private static Logger logger = Logger.getLogger(YsItems.class);
	
	@RequestMapping("/submitItemsBelong")
	@ResponseBody
	public String submitItemsBelong(HttpServletRequest request, HttpServletResponse response,Model model) {
		
		YsStatistic ys = GetBeansFactory.getYsStatistic();
		ys.setItem_belong("fefef1123");
		ys.setItem_detail("sssffef");
		
		/* 封装返回结果 */
		SingleControllerRes res = GetBeansFactory.getSingleConrollerRes();
		HashMap<String,String> m = new HashMap<String,String>();
		m.put("test", "test_value");
		HashMap[] mapList = new HashMap[]{m};
		ArrayList<HashMap<String,String>> list = new ArrayList(Arrays.asList(mapList));
		res.setResList(list);
		
		
		SqlSession session = StaticApplications.getMybatisSession();
		IYsStatistic ysMapper = session.getMapper(IYsStatistic.class);
		ysMapper.insertRecord(ys);
		session.commit();
		session.close();
		return JSON.toJSONString(res); 
	}
}
