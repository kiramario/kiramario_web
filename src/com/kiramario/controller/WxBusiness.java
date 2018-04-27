package com.kiramario.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.kiramario.factory.GetBeansFactory;
import com.kiramario.factory.GetServicesFactory;
import com.kiramario.factory.Util.service.WxApiService;
import com.kiramario.factory.Util.staticItems.StandardWxConfig;

//getWxUserInfoService
@Controller
@RequestMapping("/s/wb")
public class WxBusiness {
	
	@RequestMapping(value="/getUserInfo",produces="text/html;charset=utf-8",method = RequestMethod.GET)
	@ResponseBody
	public String getUserInfo(HttpServletRequest request, HttpServletResponse response,Model model) {
		String openid=request.getParameter("openid");
		WxApiService ws = GetServicesFactory.getWxApiService();
		
		StandardWxConfig wxc = GetBeansFactory.getStandardWxConif();
		String accessToken = wxc.getAccessToken();
		
		JSONObject userInfo = ws.getUserInfo(accessToken, openid);
		ws=null;
		return JSON.toJSONString(userInfo);
	}
	
	@RequestMapping(value="/createMenu",method = RequestMethod.GET)
	@ResponseBody
	public String createMenu(HttpServletRequest request, HttpServletResponse response,Model model) {
		WxApiService ws = GetServicesFactory.getWxApiService();
		String res = ws.createMenu();
		ws=null;
		return res;
	}
	
	@RequestMapping("/authen")
	public ModelAndView authenPage(HttpServletRequest request, HttpServletResponse response){
		ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("wxAuthen");
        /*modelAndView.addObject("message", "Hello World, Hello Kitty");*/
        return modelAndView;
	}
	
	@RequestMapping("/authenCode")
	@ResponseBody
	public String authenCode(HttpServletRequest request, HttpServletResponse response){
		WxApiService ws = GetServicesFactory.getWxApiService();
		String code = request.getParameter("code");
		JSONObject res = ws.authenByUser(code);
		ws=null;
		return JSON.toJSONString(res);
	}
	
}
