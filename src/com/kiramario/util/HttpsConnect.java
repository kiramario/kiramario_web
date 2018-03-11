package com.kiramario.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.URL;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.HttpsURLConnection;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
 

public class HttpsConnect {
	private static Logger log = Logger.getLogger(HttpsConnect.class);
	
	public static JSONObject httpRequest(String requestUrl, String requestMethod, String outputStr) {  
		JSONObject jsonObject = null;  
        StringBuffer buffer = new StringBuffer();
        try {
	        TrustManager[] tm = { new MyX509TrustManager() };  
	        SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
	        sslContext.init(null,tm, new java.security.SecureRandom());
	        SSLSocketFactory ssf = sslContext.getSocketFactory();
	        URL url = new URL(requestUrl);  
	        HttpsURLConnection httpUrlConn =(HttpsURLConnection)url.openConnection();
	        httpUrlConn.setSSLSocketFactory(ssf);
	        httpUrlConn.setDoOutput(true);  
            httpUrlConn.setDoInput(true);  
            httpUrlConn.setUseCaches(false);
            httpUrlConn.setRequestMethod(requestMethod);
            if("GET".equalsIgnoreCase(requestMethod)){
            	httpUrlConn.connect();
            }
            if (null != outputStr) {
            	OutputStream outputStream = httpUrlConn.getOutputStream();
            	outputStream.write(outputStr.getBytes("UTF-8"));
            	outputStream.close();
            }
            
            InputStream inputStream = httpUrlConn.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            
            String str = null;
            while ((str = bufferedReader.readLine()) != null) {  
                buffer.append(str);
            }
            bufferedReader.close();  
            inputStreamReader.close();  
            // 释放资源  
            inputStream.close();  
            inputStream = null;  
            httpUrlConn.disconnect(); 
            log.info("https return： "+buffer.toString());
            jsonObject = JSON.parseObject(buffer.toString());
        }catch(ConnectException e){
        	e.printStackTrace();
        }catch (Exception e) {  
           e.printStackTrace();
        }
        return jsonObject;
	}
	
	public static void main(String[] args){
		String text = "{\"name\":\"老张头\", \"age\":66}";
		JSONObject json = JSON.parseObject(text);
		int age = (int)json.get("age");
		System.out.println(age);	
		
	}
}
