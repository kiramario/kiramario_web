package com.kiramario.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.kiramario.factory.GetWxApiRes;
import com.kiramario.factory.Util.WxAuthAccessToken;

public class WxPageAuth{
	private static Logger logger = Logger.getLogger(Test.class);
	
	public void execute(Map<String, Object> map) throws IOException {
		// TODO Auto-generated method stub
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		HttpServletResponse response = (HttpServletResponse)map.get("response");
		PrintWriter out = response.getWriter();
		
		String op = request.getParameter("op");
		if(op.trim().equalsIgnoreCase(("getAccessToken"))){
			String code = request.getParameter("code");
			WxAuthAccessToken authenAT = GetWxApiRes.getWxAuthenAccessToken();
			authenAT.setCode(code);
			String authTokenString = authenAT.getApiRes().toJSONString();
			out.append(authTokenString);
			out.println();
		}else if(op.trim().equalsIgnoreCase(("getUserInfo"))){
			String authenAccessToken = request.getParameter("authAccessToken");
			String openId = request.getParameter("authAccessToken");
			String userInfoString = GetWxApiRes.getWxUserInfo().getApiRes().toJSONString();
			out.append(userInfoString);
			out.println();
		}		
	}

}
