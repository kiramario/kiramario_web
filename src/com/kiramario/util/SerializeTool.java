package com.kiramario.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializeTool<T> {
	public void seriali(T target,File file){
        ObjectOutputStream oos = null;
	        
        try{
        	oos = new ObjectOutputStream(new FileOutputStream(file));
        	oos.writeObject(target);
        }catch(IOException e){
        	e.printStackTrace();
        }finally{
        	try{
        		oos.close();
        	}catch(IOException e){
        		e.printStackTrace();
        	}
        }
	}
	
	
	public T anseriali(File file){
        ObjectInputStream ois = null;
        T target = null;
        try{
        	ois = new ObjectInputStream(new FileInputStream(file));
        	target = (T)ois.readObject();
        }catch(IOException e){
        	e.printStackTrace();
        }catch(ClassNotFoundException e){
        	e.printStackTrace();
        }finally{
        	try{
        		ois.close();
        	}catch(IOException e){
        		e.printStackTrace();
        	}
        }
        return target;
	}
}
