package com.kiramario.factory.Util;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.kiramario.factory.StaticApplications;
import com.kiramario.factory.Interf.WxApiReturnInterf;
import com.kiramario.util.HttpsConnect;

public class WxAccessToken implements WxApiReturnInterf{
	private static Logger logger = Logger.getLogger(WxAccessToken.class);
	@Override
	public JSONObject getApiRes() {
		StandardWxConfig wxConfig = StaticApplications.getStandardWxConif();
		String appid=wxConfig.getAppid();
		String secretKey = wxConfig.getSecretKey();
//		String baseUrl = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + appid + "&secret=" + secretKey;
//		JSONObject accessToken = HttpsConnect.httpRequest(baseUrl,"GET",null);
		JSONObject accessToken = JSON.parseObject("{\"access_token\":\"7_tBJskOktBJK5LW8hTCCZaouMMUw67As85gh_kpgXWk3zjmHyAID2x3xuJmT0JA8F8Xe7C4UhuKAVLiBZI-53tMw_ax8Yi5h_wARfTeF_MV-WN-OWUjcIXzWis8sCejerMoZtiH3_uoxmFhgvNQDgADARUH\",\"expires_in\":7200}");
//		logger.info("accessToken_test: " + accessToken);
		return accessToken;
	}
}
