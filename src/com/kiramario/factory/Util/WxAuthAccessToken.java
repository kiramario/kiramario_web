package com.kiramario.factory.Util;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONObject;
import com.kiramario.factory.StaticApplications;
import com.kiramario.factory.Interf.WxApiReturnInterf;
import com.kiramario.util.HttpsConnect;

public class WxAuthAccessToken implements WxApiReturnInterf {
	private static Logger logger = Logger.getLogger(WxAuthAccessToken.class);
	private String code="";
	@Override
	public JSONObject getApiRes() {
		StandardWxConfig wxconfig=StaticApplications.getStandardWxConif();
		String appid = wxconfig.getAppid();
		String secretKey = wxconfig.getSecretKey();
		String baseUrl = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=%s&secret=%s&code=%s&grant_type=authorization_code";
		String requestUrl = String.format(baseUrl, appid,secretKey,code);
		JSONObject tokenJson = HttpsConnect.httpRequest(requestUrl,"GET",null);
		return tokenJson;
	}
	
	public void setCode(String code){
		this.code=code;
	}

}
