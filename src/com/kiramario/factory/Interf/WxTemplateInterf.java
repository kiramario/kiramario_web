package com.kiramario.factory.Interf;

import java.util.Map;

public interface WxTemplateInterf {
	public abstract String getTouser();
	public abstract void setTouser(String touser);
	public abstract String getTemplate_id();
	public abstract void setTemplate_id(String template_id);
	public abstract String getTopcolor();
	public abstract void setTopcolor(String topcolor);
	public abstract Map<String, WxTemplateValueInterf> getData();
	public abstract void setData(Map<String, WxTemplateValueInterf> data);
	public abstract String getUrl();
	public abstract void setUrl(String url);
}
