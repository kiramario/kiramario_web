package com.kiramario.test;

import java.util.HashMap;
import java.util.Map;

public class StaticProxy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fibonacci f = new Fibonacci(5);
		FibonacciProxy fp = new FibonacciProxy(f);
		long startTime=System.currentTimeMillis(); 
		System.out.println(f.getResult());
		long endTime=System.currentTimeMillis();
		System.out.println("程序运行时间： "+(endTime-startTime)+"ms");
	}

}


class Fibonacci{
	private int n;
	private int res;
	private static Map<String, Integer> cached = new HashMap<String, Integer>();
	
	public Fibonacci(int n){
		this.n = n;
	}
	
	public String getN(){
		return String.valueOf(this.n);
	}
	
	public int getResult(){
		if(Fibonacci.cached.get(getN()) != null){
			return Fibonacci.cached.get(getN());
		}else{
			if(this.n<=2){
				this.res = this.n-1;
			}else{
				return new Fibonacci(this.n-1).getResult() + new Fibonacci(this.n-2).getResult();
			}
			Fibonacci.cached.put(getN(), this.res);
			return this.res;
		}
	}
}

class FibonacciProxy{
	private Fibonacci fibonacci;
	private Map<String, Integer> cached = new HashMap<String, Integer>();
	public FibonacciProxy(Fibonacci f){
		this.fibonacci = f;
	}
	public int getResult(){
		String n = fibonacci.getN();
		System.out.println(n);
		if(this.cached.get(n) != null){
			return this.cached.get(n);
		}
		int res = fibonacci.getResult();
		this.cached.put(n, res);
		return res;
	}
}
