package com.kiramario.factory.Util;

import com.alibaba.fastjson.JSONObject;
import com.kiramario.factory.Interf.WxApiReturnInterf;
import com.kiramario.util.HttpsConnect;

public class WxUserInfo implements WxApiReturnInterf {
	private String authAccessToken="";
	private String openid="";
	@Override
	public JSONObject getApiRes() {
		String baseUrl = "https://api.weixin.qq.com/sns/userinfo?access_token=%s&openid=%s&lang=zh_CN";
		String requestUrl = String.format(baseUrl,authAccessToken,openid);
		JSONObject userInfoJson = HttpsConnect.httpRequest(requestUrl,"GET",null);
		return userInfoJson;
	}
	
	public void setAuthAT(String authAccessToken){
		this.authAccessToken=authAccessToken;
	}
	public void setOpenId(String openid){
		this.openid=openid;
	}

}
