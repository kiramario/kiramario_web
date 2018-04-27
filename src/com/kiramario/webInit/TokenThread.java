package com.kiramario.webInit;

import java.io.File;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONObject;
import com.kiramario.factory.Util.staticItems.StandardWxConfig;
import com.kiramario.factory.Util.dto.JdPriceInfoDto;
import com.kiramario.factory.Util.job.PriceMentionJob;
import com.kiramario.util.SerializeTool;
import com.kiramario.factory.GetServicesFactory;
import com.kiramario.factory.GetWxApiRes;

public class TokenThread extends Thread{
	private StandardWxConfig wxconfig = null;
	private static Logger logger = Logger.getLogger(TokenThread.class);
	private int flag = 0;
	private String seralizeName = "sFile/wxconfig";
	
	
	public TokenThread(StandardWxConfig wxconfig){
		this.wxconfig = wxconfig;
	}

	public StandardWxConfig getWxConfig(){
		return this.wxconfig;
	}
	
	private void searilizeConfig(StandardWxConfig config){
		SerializeTool serializeTool = new SerializeTool<JdPriceInfoDto>();
	
		String path = PriceMentionJob.class.getClassLoader().getResource("").getPath() + seralizeName;
		File file = new File(path);
		
		serializeTool.seriali(config,file);
	}

	@Override
	public void run(){
		while(true){
			try {
				JSONObject accesstoken = GetServicesFactory.getWxApiService().getAccessToken();
				if(accesstoken!=null){
					if(accesstoken.containsKey("errcode")){
						int errcode = Integer.parseInt((String) accesstoken.get("errcode"));
						if(errcode==-1){
							Thread.sleep(10 * 1000);
							continue;
						}else{
							logger.warn(accesstoken.get("errmsg"));
							break;
						}
					}
					int expire_in =(int)accesstoken.get("expires_in");
					String access_token = (String)accesstoken.get("access_token");
					
//					System.out.println(access_token);
					
					//暂时先在这里取到jsapiticket
//					JSONObject jsApiJson = GetWxApiRes.getWxJsApiTicket().getApiRes();
//					String jsApiTicket = (String) jsApiJson.get("ticket");
					
					wxconfig.setAccessToken(access_token);
//					wxconfig.setJsAPITicket(jsApiTicket);
					searilizeConfig(wxconfig);	//序列化
					Thread.sleep((expire_in-200) * 1000);
				}else{
					Thread.sleep(60 * 1000);
				}
			} catch (InterruptedException e) {
				logger.error(e.toString());
			}
		}
	}
}