package com.kiramario.controller;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.kiramario.factory.StaticApplications;
import com.kiramario.factory.GetWxTemplate;
import com.kiramario.factory.GetWxTemplateValue;
import com.kiramario.factory.Interf.WxTemplateValueInterf;
import com.kiramario.factory.Util.SingleWxTemplate;
import com.kiramario.factory.Util.SingleWxTemplateValue;
import com.kiramario.util.HttpsConnect;

public class TestTemplate{
	private static Logger logger = Logger.getLogger(TestTemplate.class);

	public void execute(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		HttpServletResponse response = (HttpServletResponse)map.get("response");
		PrintWriter out = response.getWriter();
		String accesstoken =StaticApplications.getStandardWxConif().getAccessToken();
		String baseUrl = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="+accesstoken;
		
		WxTemplateValueInterf tv1 = GetWxTemplateValue.getSingleWxTemplateValue("#173177","大兄弟");
		WxTemplateValueInterf tv2 = GetWxTemplateValue.getSingleWxTemplateValue("#173177","\n大价格");
		WxTemplateValueInterf tv3 = GetWxTemplateValue.getSingleWxTemplateValue("#173177","\n大点");
		Map<String,WxTemplateValueInterf> maps = new HashMap<String,WxTemplateValueInterf>();
		maps.put("title", tv1);
		maps.put("price", tv2);
		maps.put("remark", tv3);

		SingleWxTemplate template = GetWxTemplate.getSingleWxTemplate();
//		template.setTouser(request.getParameter("openid"));
		template.setTouser("oBKfS0Tk8toPtoMY_C_2QQ_d7SmI");
//		template.setTopcolor(request.getParameter("color"));
		template.setTopcolor("#ff0000");
//		template.setUrl(request.getParameter("url"));
		template.setUrl("http://www.kiramario.com");
//		template.setTemplate_id(request.getParameter("tempalteid"));
		template.setTemplate_id("Y6HewvJqKme8yez5uaufRRhJiO2vyD-R3iKLe6zsQU4");
		template.setData(maps);
		String jsonStr =JSON.toJSON(template).toString();
		
		System.out.println(jsonStr);
		JSONObject accessToken = HttpsConnect.httpRequest(baseUrl,"GET",jsonStr);
		out.append("ok");
		out.println();
	}
	
	public static void main(String[] args){
		WxTemplateValueInterf tv1 = GetWxTemplateValue.getSingleWxTemplateValue("#173177","大兄弟");
		WxTemplateValueInterf tv2 = GetWxTemplateValue.getSingleWxTemplateValue("#173177","大价格");
		SingleWxTemplateValue tv3 = GetWxTemplateValue.getSingleWxTemplateValue("#173177","大点");
		Map<String,WxTemplateValueInterf> maps = new HashMap<String,WxTemplateValueInterf>();
		maps.put("title", tv1);
		maps.put("price", tv2);
		maps.put("remark", tv3);
		
		System.out.println(tv3.getColor());
	}
}

