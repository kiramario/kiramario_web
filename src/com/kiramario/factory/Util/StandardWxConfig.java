package com.kiramario.factory.Util;

import java.io.Serializable;

import com.kiramario.factory.Interf.StandardContainerInterf;

public class StandardWxConfig implements StandardContainerInterf,Serializable{
	private String accessToken;
	private String appid;
	private String secretKey;
	private String jsAPITicket;
	private static final long serialVersionUID = 20180316134500L;
	
	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getSecretKey() {
		return secretKey;
	}

	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}

	public String getJsAPITicket() {
		return jsAPITicket;
	}

	public void setJsAPITicket(String jsAPITicket) {
		this.jsAPITicket = jsAPITicket;
	}
	
	@Override
	public StandardContainerInterf getInstance() {
		// TODO Auto-generated method stub
		return new StandardWxConfig();
	}

}
