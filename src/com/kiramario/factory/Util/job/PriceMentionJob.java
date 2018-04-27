package com.kiramario.factory.Util.job;

import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import com.kiramario.factory.Interf.JobUtilInterf;
import com.kiramario.factory.StaticApplications;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.kiramario.factory.GetBeansFactory;
import com.kiramario.factory.GetWxTemplate;
import com.kiramario.factory.GetWxTemplateValue;
import com.kiramario.factory.Interf.WxTemplateValueInterf;
import com.kiramario.factory.Util.SingleWxTemplate;
import com.kiramario.factory.Util.dao.mapperInter.IJdPriceInfoDto;
import com.kiramario.factory.Util.dto.JdPriceInfoDto;
import com.kiramario.factory.Util.staticItems.StandardWxConfig;
import com.kiramario.util.HttpsConnect;
import com.kiramario.util.SerializeTool;

public class PriceMentionJob implements JobUtilInterf{
	private static Logger log = Logger.getLogger(PriceMentionJob.class);
	private String jobName = "PriceMentionJob";
	private String jobGroup = "group_sendTemplate";
	private String seralizeName = "sFile/PriceMentionJob_1";
	private SerializeTool serializeTool = null;
	private String wxconfig_seralizeName = "sFile/wxconfig";
	private JdPriceInfoDto dto = null;
	
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		String accesstoken = "";
		// TODO Auto-generated method stub
		String path = PriceMentionJob.class.getClassLoader().getResource("").getPath() + wxconfig_seralizeName;
		File file = new File(path);
		SerializeTool configSerailizeTool = new SerializeTool<StandardWxConfig>();
		if (file.exists()){
			StandardWxConfig config = (StandardWxConfig) configSerailizeTool.anseriali(file);
			accesstoken = config.getAccessToken();
		}else{
			log.error("no config seralize file");
		}

		Map<String,String> basicInfo = this.getBasicInfo();
		if(judgeData()){
			String baseUrl = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="+accesstoken;

			SingleWxTemplate template = GetWxTemplate.getSingleWxTemplate();
			template.setTouser(basicInfo.get("touser"));
			template.setTopcolor(basicInfo.get("topcolor"));
			template.setUrl(basicInfo.get("url"));
			template.setTemplate_id(basicInfo.get("templateId"));
			template.setData(this.getTemplateData(context));
			String jsonStr =JSON.toJSON(template).toString();
			
			JSONObject accessToken = HttpsConnect.httpRequest(baseUrl,"GET",jsonStr);
			log.info(basicInfo.get("templateId") + "; price: " + dto.getPrice() + "; name: " + dto.getItem_name() + "results: " + accessToken);
		}else{
			log.info(basicInfo.get("templateId") + " do not need to push");
		}
	}
	
	private Map<String,WxTemplateValueInterf> getTemplateData(JobExecutionContext context){
		String price=dto.getPrice();
		String item_name=dto.getItem_name();
		String create_time="";
		
		WxTemplateValueInterf tv1 = GetWxTemplateValue.getSingleWxTemplateValue("#173177",item_name);
		WxTemplateValueInterf tv2 = GetWxTemplateValue.getSingleWxTemplateValue("#173177","\n"+price);
		WxTemplateValueInterf tv3 = GetWxTemplateValue.getSingleWxTemplateValue("#173177","\n"+create_time);
		Map<String,WxTemplateValueInterf> maps = new HashMap<String,WxTemplateValueInterf>();
		maps.put("title", tv1);
		maps.put("price", tv2);
		maps.put("remark", tv3);
		return maps;
	}
	
	private Map<String,String> getBasicInfo(){
		Map<String,String> info = new HashMap<String,String>();
		info.put("touser", "oBKfS0Tk8toPtoMY_C_2QQ_d7SmI");
		info.put("topcolor", "#ff0000");
		info.put("url", "http://www.kiramario.com");
		info.put("templateId", "Y6HewvJqKme8yez5uaufRRhJiO2vyD-R3iKLe6zsQU4");
		return info;
	}
	
	private boolean judgeData(){
		boolean isSend = false;
		dto = GetBeansFactory.getJdPriceInfoDto();
		
		try{
			SqlSession session = StaticApplications.getMybatisSession();
			IJdPriceInfoDto jd = session.getMapper(IJdPriceInfoDto.class);
			dto = jd.selectLatestOne("3541223");
			session.commit();
			session.close();
		}catch(Exception e){
			log.error(e.toString());
		}
		
		this.serializeTool = new SerializeTool<JdPriceInfoDto>();
		
		String path = PriceMentionJob.class.getClassLoader().getResource("").getPath() + seralizeName;
		File file = new File(path);
		
		if (file.exists()){
			JdPriceInfoDto dto_before = (JdPriceInfoDto) this.serializeTool.anseriali(file);
			if(!dto_before.getPrice().equals(dto.getPrice())){
				this.serializeTool.seriali(dto,file);
				isSend=true;
			}
		}else{
			this.serializeTool.seriali(dto,file);
			isSend=true;
		}
		return isSend;
	}
	
	public static void main(String[] args){
		System.out.println(PriceMentionJob.class.getClassLoader().getResource("").getPath());
		PriceMentionJob p =new PriceMentionJob();
		System.out.print(p.judgeData());
	}
}
