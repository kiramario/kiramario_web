package com.kiramario.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import com.kiramario.factory.ControllerInvocation;
import com.kiramario.factory.Util.SingleControllerRes;
import com.alibaba.fastjson.JSON;

public class TestControllerInvocation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			SingleControllerRes res = ControllerInvocation.createSingleController();
			res.setErrcode(-1);
			res.setMsg("³É¹¦");
			res.setTotalRows(0);
			HashMap<String,String> map = new HashMap<String,String>();
			map.put("name", "kiramaio");
			map.put("age", "22");
			HashMap[] mapList = new HashMap[]{map};
			
			ArrayList<HashMap<String,String>> list = new ArrayList(Arrays.asList(mapList));
			res.setResList(list);
			
			String jsonStr = JSON.toJSONString(res);
			System.out.println(jsonStr);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
