package com.kiramario.factory.Util.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.kiramario.factory.Interf.DtoInterf;

/*
	@Service���ڱ�עҵ������
	@Controller���ڱ�ע���Ʋ��������struts�е�action��
	@Repository���ڱ�ע���ݷ����������DAO���
	@Component��ָ�������������ù����ʱ�����ǿ���ʹ�����ע����б�ע��
 */
@Scope("prototype")
@Repository
public class YsStatistic implements DtoInterf{
	private int id;
	private String item_detail;
	private String item_belong;
	
/*	@Autowired
	private Car car;*/
	
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
/*	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}*/
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
	
	@Override
	public String toString(){
		return "id="+this.id + "; item_detail="+this.item_detail + ";item_belong="+this.item_belong;
	}
}
