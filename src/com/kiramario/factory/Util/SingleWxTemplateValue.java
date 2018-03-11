package com.kiramario.factory.Util;

import com.kiramario.factory.Interf.WxTemplateValueInterf;

public class SingleWxTemplateValue implements WxTemplateValueInterf {
	private String value;
	private String color;
	public SingleWxTemplateValue(String color,String value){
		this.value = value;
		this.color = color;
	}
	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return value;
	}

	@Override
	public void setValue(String value) {
		// TODO Auto-generated method stub
		this.value = value;
	}

	@Override
	public String getColor() {
		// TODO Auto-generated method stub
		return color;
	}

	@Override
	public void setColor(String color) {
		// TODO Auto-generated method stub
		this.color = color;
	}

}
