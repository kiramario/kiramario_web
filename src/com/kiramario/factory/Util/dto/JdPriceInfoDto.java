package com.kiramario.factory.Util.dto;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.kiramario.factory.Interf.DtoInterf;

@Scope("prototype")
@Repository
public class JdPriceInfoDto implements DtoInterf{
	private int id;
	private String item_id;
	private String item_name;
	private String price;
	private String create_time;
	private static final long serialVersionUID = 20180314141400L;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getItem_id() {
		return item_id;
	}
	public void setItem_id(String item_id) {
		this.item_id = item_id;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
}
