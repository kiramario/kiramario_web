package com.kiramario.factory.Util;

import java.util.ArrayList;
import java.util.Map;

import com.kiramario.factory.Interf.ControllerResInterf;

public class SingleControllerRes<K,V> implements ControllerResInterf<K,V>{
	private int errcode=0;
	private String msg="sucess!";
	private ArrayList<Map<K,V>> resList = null;
	private int totalRows=0;
	@Override
	public void setErrcode(int code) {
		errcode=code;
	}

	@Override
	public int getErrcode() {
		return errcode;
	}

	@Override
	public void setMsg(String msg) {
		this.msg=msg;
	}

	@Override
	public String getMsg() {
		return msg;
	}

	@Override
	public void setResList(ArrayList<Map<K,V>> list) {
		this.resList=list;
	}

	@Override
	public ArrayList getResList() {
		return resList;
	}

	@Override
	public void setTotalRows(int totalRows) {
		this.totalRows=totalRows;
	}

	@Override
	public int getTotalRows() {
		return totalRows;
	}
}
