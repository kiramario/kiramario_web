package com.kiramario.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.kiramario.factory.GetBeansFactory;
import com.kiramario.factory.GetServicesFactory;
import com.kiramario.factory.Util.service.UserService;
import com.kiramario.factory.Util.staticItems.StandardWxConfig;

@Controller
@RequestMapping("/s/user")
public class UserOperator {
	
	@RequestMapping(value="/initUser",method = RequestMethod.GET)
	@ResponseBody
	public int initUser(HttpServletRequest request, HttpServletResponse response,Model model) {
		String openid=request.getParameter("openid");
		UserService us = GetServicesFactory.getUserService();
		int res_id = us.initUser(openid);
		us=null;
		return res_id;
	}
}
