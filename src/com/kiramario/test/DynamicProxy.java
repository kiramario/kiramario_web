package com.kiramario.test;

import java.lang.reflect.*;

public class DynamicProxy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Humen f = (Humen) Proxy.newProxyInstance(Humen.class.getClassLoader(),
                new Class<?>[] { Humen.class },
                new PorxyHandler(new HumenImpl()));
		f.eat("fish");
		Cook c = (Cook) Proxy.newProxyInstance(Cook.class.getClassLoader(),
                new Class<?>[] { Cook.class },
                new PorxyHandler(new CookImpl()));
		c.cook("fish");
	}

}

interface Humen{
	void eat(String food);
}


interface Cook{
	void cook(String food);
}

class HumenImpl implements Humen{
	@Override
	public void eat(String food) {
		System.out.println("eat: " + food);
	}
}
class CookImpl implements Cook{
	@Override
	public void cook(String food) {
		System.out.println("cook: " + food);
	}
}

class PorxyHandler implements InvocationHandler{
	private Object obj = null;
	
	public PorxyHandler(Object obj){
		this.obj = obj;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("*** proxy ****");
		before();
		method.invoke(obj, args[0]);
		after();
		return null;
	}
	
	public void before(){
		if(this.obj.getClass().getSimpleName().equals("CookImpl")){
			System.out.println("buy food");
		}else{
			System.out.println("cook");
		}
		
	}
	public void after(){
		if(this.obj.getClass().getSimpleName().equals("CookImpl")){
			System.out.println("swap kitchen");
		}else{
			System.out.println("swap");
		}
		
	}
}
