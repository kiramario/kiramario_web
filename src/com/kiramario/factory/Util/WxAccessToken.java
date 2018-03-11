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
		String baseUrl = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + appid + "&secret=" + secretKey;
		JSONObject accessToken = HttpsConnect.httpRequest(baseUrl,"GET",null);
//		JSONObject accessToken = JSON.parseObject("{\"access_token\":\"7_GHE4RZWHj0SYKXgUWIPG68_GEXNl4ijIWNZsbreZyD7hwkfI5SE09SnPmjIExm_hzfus7jpLkQLcZhO_ZOM6urf6Tl7z2aJ5C8enGVl3_31TbqNEm2QjRdxXrTo-3Ktlff7cZg8tB4eIh7tmYABiAJAGIJ\",\"expires_in\":7200}");
		logger.info("accessToken_test: " + accessToken);
		return accessToken;
	}
}
