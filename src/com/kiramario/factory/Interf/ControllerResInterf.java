package com.kiramario.factory.Interf;

import java.util.ArrayList;
import java.util.Map;

public interface ControllerResInterf<K,V> {
	public abstract void setErrcode(int code);
	public abstract int getErrcode();
	
	public abstract void setMsg(String msg);
	public abstract String getMsg();
	
	public abstract void setResList(ArrayList<Map<K,V>> list);
	public abstract ArrayList<Map<K,V>> getResList();
	
	public abstract void setTotalRows(int totalRows);
	public abstract int getTotalRows();
}
