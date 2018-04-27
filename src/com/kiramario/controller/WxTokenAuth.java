package com.kiramario.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Map;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/s")
public class WxTokenAuth{
	private static Logger logger = Logger.getLogger(WxTokenAuth.class);
	private String timestamp = "";
	private String signature = "";
	private String nonce = "";
	private String token = "kiramariotest";
	private String echostr = "";
			
	@RequestMapping("/wxTokenAuth")
	@ResponseBody
	public String wxTokenAuth(HttpServletRequest request, HttpServletResponse response,Model model) throws IOException {
		logger.info(request.getMethod().trim().equalsIgnoreCase("GET"));
		String res = "";
		if(request.getMethod().trim().equalsIgnoreCase("GET")){
			timestamp = request.getParameter("timestamp");
			signature = request.getParameter("signature");
			nonce = request.getParameter("nonce");
			echostr = request.getParameter("echostr");
			if(checkToken()){
				res = echostr;
			}else{
				logger.warn("Authen failed");
			}
		}else{
			 System.out.println("WxTokenAuth enter post");  
			 ServletInputStream in = request.getInputStream();
			 StringBuilder content = new StringBuilder();
			byte[] b = new byte[1024];
			int lens = -1;
			while ((lens = in.read(b)) > 0) {
				content.append(new String(b, 0, lens));
			}
			String strcont = content.toString();// ÄÚÈÝ	
			logger.info(strcont);
		}
		return res;
	}
	
	private boolean checkToken(){
		String[] authArr = new String[]{token,nonce,timestamp};
		Arrays.sort(authArr);
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 3; i++) {
			sb.append(authArr[i]);
		}
		String str = sb.toString();
		MessageDigest md = null;
		try{
			md = MessageDigest.getInstance("SHA-1");
		}catch(NoSuchAlgorithmException e){
			
			logger.error(e);
			return false;
		}
		md.update(str.getBytes());
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
		return signature.equals(hexstr.toString()) ? true : false;
	}
	
	public static void main(String[] args) throws NoSuchAlgorithmException{
		System.out.println("good");
	}
}
