package com.kiramario.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.Random;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.kiramario.factory.StaticApplications;
import com.kiramario.factory.Util.StandardWxConfig;

public class GetJsSignature{
	private static Logger logger = Logger.getLogger(Test.class);
	
	private String getRandomStr() {
		String base = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 16; i++) {
			int number = random.nextInt(base.length());
			sb.append(base.charAt(number));
		}
		return sb.toString();
	}
	
	private String SHA1(StringBuilder sb){
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA-1");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		try {
			md.update(sb.toString().getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		byte[] digest = md.digest();

		StringBuffer hexstr = new StringBuffer();
		String shaHex = "";
		for (int i = 0; i < digest.length; i++) {
			shaHex = Integer.toHexString(digest[i] & 0xFF);
			if (shaHex.length() < 2) {
				hexstr.append(0);
			}
			hexstr.append(shaHex);
		}
		
		System.out.println("string1: " + sb.toString());
		System.out.println("signature: " + hexstr.toString());
		return hexstr.toString();
	}
	public  String getSignature(String url,String jsapi_ticket,String noncestr,String timestamp){
		StringBuilder sb = new StringBuilder();
		sb.append("jsapi_ticket="+jsapi_ticket+"&noncestr="+noncestr+"&timestamp="+timestamp+"&url="+url);
		return SHA1(sb);

	}
	
	private class Jsconfig{
		private String url = "";
		private String jsapi_ticket = "";
		private String noncestr = "";
		private String timestamp = "";
		private String signature = "";
		private String appid = "";
		public String getAppid() {
			return appid;
		}
		public void setAppid(String appid) {
			this.appid = appid;
		}
		private int errcode = 0;
		public String getUrl() {
			return url;
		}
		public void setUrl(String url) {
			this.url = url;
		}
		public String getJsapi_ticket() {
			return jsapi_ticket;
		}
		public void setJsapi_ticket(String jsapi_ticket) {
			this.jsapi_ticket = jsapi_ticket;
		}
		public String getNoncestr() {
			return noncestr;
		}
		public void setNoncestr(String noncestr) {
			this.noncestr = noncestr;
		}
		public String getTimestamp() {
			return timestamp;
		}
		public void setTimestamp(String timestamp) {
			this.timestamp = timestamp;
		}
		public String getSignature() {
			return signature;
		}
		public void setSignature(String signature) {
			this.signature = signature;
		}
		public int getErrcode() {
			return errcode;
		}
		public void setErrcode(int errcode) {
			this.errcode = errcode;
		}
	}
	
	public void execute(Map<String, Object> map) throws IOException {
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		HttpServletResponse response = (HttpServletResponse)map.get("response");
		PrintWriter out = response.getWriter();
		Jsconfig j = new Jsconfig();
		StandardWxConfig instance = StaticApplications.getStandardWxConif();
		String url = request.getParameter("url");
		String jsapi_ticket = instance.getJsAPITicket();
		String noncestr = getRandomStr();
		String timestamp = Long.toString(System.currentTimeMillis()/1000);
		j.setUrl(url);
		j.setJsapi_ticket(jsapi_ticket);
		j.setNoncestr(noncestr);
		j.setTimestamp(timestamp);
		j.setAppid(instance.getAppid());
		String res = getSignature(url,jsapi_ticket,noncestr,timestamp);
		j.setSignature(res);
		out.append(JSON.toJSONString(j));
		out.println();
	}
	
	
	public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		
	}

}