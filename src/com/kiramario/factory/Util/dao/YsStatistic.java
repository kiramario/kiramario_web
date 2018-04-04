package com.kiramario.factory.Util.dao;

import com.kiramario.factory.Interf.DaoInterf;

public class YsStatistic implements DaoInterf{
	private int id;
	private String item_detail;
	private String item_belong;
	
	public YsStatistic(){
		
	}
	
	public YsStatistic(String item_detail,String item_belong){
		this.item_detail = item_detail;
		this.item_belong = item_belong;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getItem_detail() {
		return item_detail;
	}
	public void setItem_detail(String item_detail) {
		this.item_detail = item_detail;
	}
	public String getItem_belong() {
		return item_belong;
	}
	public void setItem_belong(String item_belong) {
		this.item_belong = item_belong;
	}
}
