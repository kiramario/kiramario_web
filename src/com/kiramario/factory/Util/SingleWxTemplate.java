package com.kiramario.factory.Util;

import java.util.Map;

import com.kiramario.factory.Interf.WxTemplateInterf;
import com.kiramario.factory.Interf.WxTemplateValueInterf;

public class SingleWxTemplate implements WxTemplateInterf{
	private String touser;
	private String template_id;
	private String topcolor;
	private String url;
	private Map<String, WxTemplateValueInterf> data;
	@Override
	public String getTouser() {
		// TODO Auto-generated method stub
		return touser;
	}

	@Override
	public void setTouser(String touser) {
		// TODO Auto-generated method stub
		this.touser=touser;
	}

	@Override
	public String getTemplate_id() {
		// TODO Auto-generated method stub
		return template_id;
	}

	@Override
	public void setTemplate_id(String template_id) {
		// TODO Auto-generated method stub
		this.template_id=template_id;
	}

	@Override
	public String getTopcolor() {
		// TODO Auto-generated method stub
		return topcolor;
	}

	@Override
	public void setTopcolor(String topcolor) {
		// TODO Auto-generated method stub
		this.topcolor=topcolor;
	}

	@Override
	public Map<String, WxTemplateValueInterf> getData() {
		// TODO Auto-generated method stub
		return data;
	}

	@Override
	public void setData(Map<String, WxTemplateValueInterf> data) {
		// TODO Auto-generated method stub
		this.data=data;
	}

	@Override
	public String getUrl() {
		// TODO Auto-generated method stub
		return url;
	}

	@Override
	public void setUrl(String url) {
		// TODO Auto-generated method stub
		this.url=url;
	}
}
