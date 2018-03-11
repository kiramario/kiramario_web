package com.kiramario.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import com.alibaba.fastjson.JSONObject;
import com.kiramario.factory.StaticApplications;
import com.kiramario.factory.Util.StandardWxConfig;
import com.kiramario.factory.GetWxApiRes;



public class Test2{
	private static Logger logger = Logger.getLogger(Test.class);
	private int n = 0;

	public void execute(Map<String, Object> map) throws IOException {
		HttpServletRequest reqest = (HttpServletRequest)map.get("request");
		HttpServletResponse response = (HttpServletResponse)map.get("response");
		PrintWriter out = response.getWriter();
		
		StandardWxConfig instance = StaticApplications.getStandardWxConif();
		String accessToken = instance.getAccessToken();
		JSONObject jsApiJson = GetWxApiRes.getWxJsApiTicket().getApiRes();
		String jsApiTicket = (String) jsApiJson.get("ticket");
		out.println(jsApiTicket);
	}
}
