package com.kiramario.factory;

import org.apache.log4j.Logger;

import com.kiramario.factory.Util.WxAccessToken;
import com.kiramario.factory.Util.WxAuthAccessToken;
import com.kiramario.factory.Util.WxJsApiTicket;
import com.kiramario.factory.Util.WxUserInfo;

public class GetWxApiRes {
	private static Logger logger = Logger.getLogger(GetWxApiRes.class);
	
	public static WxAccessToken getWxAccessToken(){	//��ȡ΢�ŵ�accessToken
		Class clazz = null;
		WxAccessToken instance =null;
		try{
			clazz = Class.forName("com.kiramario.factory.Util.WxAccessToken");
			instance = (WxAccessToken)clazz.newInstance();
		}
		catch(Exception e){
			logger.error(e.toString());
		}
		return instance;
	}
	
	public static WxAuthAccessToken getWxAuthenAccessToken(){	//��ȡ΢�ŵ�oAuth accessToken
		Class clazz = null;
		WxAuthAccessToken instance =null;
		try{
			clazz = Class.forName("com.kiramario.factory.Util.WxAuthAccessToken");
			instance = (WxAuthAccessToken)clazz.newInstance();
		}
		catch(Exception e){
			logger.error(e.toString());
		}
		return instance;
	}
	
	public static WxJsApiTicket getWxJsApiTicket(){	//��ȡjsapi token
		Class clazz = null;
		WxJsApiTicket instance =null;
		try{
			clazz = Class.forName("com.kiramario.factory.Util.WxJsApiTicket");
			instance = (WxJsApiTicket)clazz.newInstance();
		}
		catch(Exception e){
			logger.error(e.toString());
		}
		return instance;
	}
	public static WxUserInfo getWxUserInfo(){	//��ȡ�û���Ϣ
		Class clazz = null;
		WxUserInfo instance =null;
		try{
			clazz = Class.forName("com.kiramario.factory.Util.WxUserInfo");
			instance = (WxUserInfo)clazz.newInstance();
		}
		catch(Exception e){
			logger.error(e.toString());
		}
		return instance;
	}

}
