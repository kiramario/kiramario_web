package com.kiramario.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import com.alibaba.fastjson.JSON;
import com.kiramario.factory.ControllerInvocation;
import com.kiramario.factory.Util.SingleControllerRes;
import com.kiramario.factory.Util.StandardWxConfig;

import com.kiramario.factory.StaticApplications;

public class Test{
	private static Logger logger = Logger.getLogger(Test.class);

	public void execute(Map<String, Object> map) throws IOException {
		// TODO Auto-generated method stub
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		HttpServletResponse response = (HttpServletResponse)map.get("response");
		PrintWriter out = response.getWriter();
		if(request.getMethod().trim().equalsIgnoreCase("GET")){
			StandardWxConfig instance = StaticApplications.getStandardWxConif();
			out.append(instance.getAppid() + "\r\n");
			out.append(instance.getSecretKey() + "\r\n");
			out.append(instance.getAccessToken()+ "\r\n");
			out.append(instance.getJsAPITicket()+ "\r\n");
			logger.info("getSecretKey: " + instance.getAccessToken());
			out.append("GET=======TEST========中文"+ "\r\n");
			out.println();
		}else{
			out.append("POST=======TEST========中文"+ "\r\n");
			out.println();
		}

	}
	
	public void do1(Map<String, Object> map) throws Exception {
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		HttpServletResponse response = (HttpServletResponse)map.get("response");
		PrintWriter out = response.getWriter();
		SingleControllerRes res = ControllerInvocation.createSingleController();
		res.setErrcode(-1);
		res.setMsg("成功");
		res.setTotalRows(1);
		HashMap<String,String> m = new HashMap<String,String>();
		m.put("name", "kiramaio");
		m.put("age", "34");
		HashMap[] mapList = new HashMap[]{m};
		
		ArrayList<HashMap<String,String>> list = new ArrayList(Arrays.asList(mapList));
		res.setResList(list);
		
		String jsonStr = JSON.toJSONString(res);
		out.append(jsonStr);
		logger.info("do1: " + jsonStr);
		out.println();
	}
}
