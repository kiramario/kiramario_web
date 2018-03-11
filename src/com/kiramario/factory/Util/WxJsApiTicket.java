package com.kiramario.factory.Util;

import com.alibaba.fastjson.JSONObject;
import com.kiramario.factory.StaticApplications;
import com.kiramario.factory.Interf.WxApiReturnInterf;
import com.kiramario.util.HttpsConnect;

public class WxJsApiTicket implements WxApiReturnInterf{

	@Override
	public JSONObject getApiRes() {
		// TODO Auto-generated method stub
		String accessToken = StaticApplications.getStandardWxConif().getAccessToken();
		String baseUrl = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token="+accessToken+"&type=jsapi";
		JSONObject jsApiJson = HttpsConnect.httpRequest(baseUrl,"GET",null);
		
//		JSONObject jsApiJson = JSON.parseObject("{\"errcode\":0,\"errmsg\":\"ok\",\"ticket\":\"HoagFKDcsGMVCIY2vOjf9lPyUt2eYRxvuDyAZjrCn30oU4twzhXKVvTY_bHKKlgcT2LiGZeBLBfN9DzkJLas5Q\",\"expires_in\":7200}");
		return jsApiJson;
	}
}
