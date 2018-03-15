package com.kiramario.factory.Util.job;

import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import com.kiramario.factory.Interf.JobUtilInterf;
import com.kiramario.factory.StaticApplications;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.kiramario.factory.GetDaoFactory;
import com.kiramario.factory.GetWxTemplate;
import com.kiramario.factory.GetWxTemplateValue;
import com.kiramario.factory.Interf.WxTemplateValueInterf;
import com.kiramario.factory.Util.MysqlConnector;
import com.kiramario.factory.Util.SingleWxTemplate;
import com.kiramario.factory.Util.dao.JdPriceInfoDao;
import com.kiramario.util.HttpsConnect;
import com.kiramario.util.SerializeTool;

public class PriceMentionJob implements JobUtilInterf{
	private static Logger log = Logger.getLogger(PriceMentionJob.class);
	private String jobName = "PriceMentionJob";
	private String jobGroup = "group_sendTemplate";
	private String seralizeName = "/sFile/PriceMentionJob_1";
	private SerializeTool serializeTool = null;
	private JdPriceInfoDao dao = null;
	
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		// TODO Auto-generated method stub
		log.info("PriceMentionJob");
	/*	Map<String,String> basicInfo = this.getBasicInfo();
		if(judgeData()){
			String accesstoken = StaticApplications.getStandardWxConif().getAccessToken();
			String baseUrl = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="+accesstoken;

			SingleWxTemplate template = GetWxTemplate.getSingleWxTemplate();
			template.setTouser(basicInfo.get("touser"));
			template.setTopcolor(basicInfo.get("topcolor"));
			template.setUrl(basicInfo.get("url"));
			template.setTemplate_id(basicInfo.get("templateId"));
			template.setData(this.getTemplateData(context));
			String jsonStr =JSON.toJSON(template).toString();
			
			JSONObject accessToken = HttpsConnect.httpRequest(baseUrl,"GET",jsonStr);
			log.info(basicInfo.get("templateId") + "; price: " + dao.getPrice() + "; name: " + dao.getItem_name());
		}else{
			log.info(basicInfo.get("templateId") + " do not need to push");
		}*/
	}
	
	private Map<String,WxTemplateValueInterf> getTemplateData(JobExecutionContext context){
		String price="";
		String item_name="";
		String create_time="";
		try{
			MysqlConnector mysqlConnector = StaticApplications.getMysqlConnector();
			Connection con = mysqlConnector.getConnection();
			Statement statement = con.createStatement();
			String sql = "select * from t_jd_price_info where item_id='3541223' order by create_time desc limit 1";
			ResultSet rs = statement.executeQuery(sql);
			
			while(rs.next()){
				price = rs.getString("price");
				item_name = rs.getString("item_name");
				create_time = rs.getString("create_time").substring(0,19);
			}
			mysqlConnector.closeConnection();
		}catch(SQLException e){
			log.error(e.toString());
		}
		
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
		dao = GetDaoFactory.getJdPriceInfoDao();
		try{
			MysqlConnector mysqlConnector = StaticApplications.getMysqlConnector();
			Connection con = mysqlConnector.getConnection();
			Statement statement = con.createStatement();
			String sql = "select * from t_jd_price_info where item_id='3541223' order by create_time desc limit 1";
			ResultSet rs = statement.executeQuery(sql);
			
			while(rs.next()){
				dao.setPrice(rs.getString("price"));
				dao.setItem_name(rs.getString("item_name"));
				dao.setCreate_time(rs.getString("create_time").substring(0,19));
			}
			mysqlConnector.closeConnection();
		}catch(SQLException e){
			log.error(e.toString());
		}
		
		this.serializeTool = new SerializeTool<JdPriceInfoDao>();
		
		String path = PriceMentionJob.class.getClassLoader().getResource("").getPath() + seralizeName;
		File file = new File(path);
		
		if (file.exists()){
			JdPriceInfoDao dao_before = (JdPriceInfoDao) this.serializeTool.anseriali(file);
			if(!dao_before.getPrice().equals(dao.getPrice())){
				this.serializeTool.seriali(dao,file);
				isSend=true;
			}
		}else{
			this.serializeTool.seriali(dao,file);
			isSend=true;
		}
		return isSend;
	}
	
	public static void main(String[] args){
		System.out.println(PriceMentionJob.class.getClassLoader().getResource("").getPath());
	}
	
}
