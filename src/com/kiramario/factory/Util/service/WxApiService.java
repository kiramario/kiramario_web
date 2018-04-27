package com.kiramario.factory.Util.service;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kiramario.factory.GetBeansFactory;
import com.kiramario.factory.Interf.ServiceInterf;
import com.kiramario.factory.Util.staticItems.StandardWxConfig;
import com.kiramario.util.HttpsConnect;

@Scope("prototype")
@Service
public class WxApiService implements ServiceInterf{
	private static Logger logger = Logger.getLogger(WxApiService.class);

	public JSONObject getAccessToken() {
		StandardWxConfig wxConfig = GetBeansFactory.getStandardWxConif();
		String appid=wxConfig.getAppid();
		String secretKey = wxConfig.getSecretKey();
		String baseUrl = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + appid + "&secret=" + secretKey;
		/*logger.info("==getAccessToken start==");
		JSONObject accessToken = HttpsConnect.httpRequest(baseUrl,"GET",null);
		logger.info("==getAccessToken end==");*/
		
		JSONObject accessToken = JSON.parseObject("{\"access_token\":\"9_xirANm7gbLAxGAVbLyno6hk0UQOpWBcSWgqWMWvXtIHFT9n2TSHN9KzcMM9jkE9gSkMSgjyl9clyY3bnKGUWNN_yh5oPmvEBFSN3nbJNhDCfcGsAKRCFZGDsmsoSVBaAIAVYE\",\"expires_in\":7200}");
		return accessToken;
	}
	
	public JSONObject getUserInfo(String authAccessToken ,String openid) {
		String baseUrl = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=%s&openid=%s&lang=zh_CN";
		String requestUrl = String.format(baseUrl,authAccessToken,openid);
		System.out.println(requestUrl);
		JSONObject userInfoJson = HttpsConnect.httpRequest(requestUrl,"GET",null);
		return userInfoJson;
	}
	
	public String createMenu(){
		StandardWxConfig wxConfig = GetBeansFactory.getStandardWxConif();
		String accessToken = wxConfig.getAccessToken();
		logger.info("createMenu: "+accessToken);
		String baseUrl = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token="+accessToken;
		
		JSONArray btn_arr = new JSONArray();
		JSONObject btn1Json=new JSONObject();
		btn1Json.put("type","view");  
        btn1Json.put("name","Œ“");  
        btn1Json.put("url","http://www.kiramario.com/kw/s/wb/authen");   
        
        btn_arr.add(btn1Json);
        
        JSONObject json=new JSONObject();  
        json.put("button",btn_arr);
        
        JSONObject jsonObject = HttpsConnect.httpRequest(baseUrl,"POST",json.toString());;
        return jsonObject.toString();
	}

	public JSONObject authenByUser(String code) {
		StandardWxConfig wxConfig = GetBeansFactory.getStandardWxConif();
		String requestUrl = "https://api.weixin.qq.com/sns/oauth2/access_token?appid="+wxConfig.getAppid()+"&secret="+wxConfig.getSecretKey()+"&code="+code+"&grant_type=authorization_code";
		JSONObject authenJson = HttpsConnect.httpRequest(requestUrl,"GET",null);
		return authenJson;
	}
	
}
