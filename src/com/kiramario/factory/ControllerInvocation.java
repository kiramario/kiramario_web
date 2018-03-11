package com.kiramario.factory;

import com.kiramario.factory.Util.SingleControllerRes;

public class ControllerInvocation{
	public static SingleControllerRes createSingleController() throws Exception{
		return (SingleControllerRes) Class.forName("com.kiramario.factory.Util.SingleControllerRes").newInstance();
	}
}
