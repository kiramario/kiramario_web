package com.kiramario.factory;

import com.kiramario.factory.Util.StandardWxConfig;

public class SingleTon {
	private static StandardWxConfig standardWxConfig = null;
	public static StandardWxConfig getStandardWxConif(){
		if(standardWxConfig==null){
			standardWxConfig = new StandardWxConfig();
		}
		return standardWxConfig;
	}
}
