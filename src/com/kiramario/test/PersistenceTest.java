package com.kiramario.test;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;


public class PersistenceTest {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		JavaSerializable serializable = new JavaSerializable();
		String storeName = "java object";
		File xmlFile = new File("xmlFile.dat");
		serializable.storeXML(storeName, new FileOutputStream(xmlFile));
	}

}

class Person{
	private int age = 10;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}



class JavaSerializable{
	public void storeXML(Object obj, OutputStream out){
		XMLEncoder encoder = new XMLEncoder(out);
		encoder.writeObject(obj);
		encoder.flush();
		encoder.close();
	}
	
	public Object loadXML(InputStream in){
		XMLDecoder decoder = new XMLDecoder (in);
		Object obj = decoder.readObject();
		decoder.close();
		return obj;
	}
	
	public void store(Object obj, OutputStream out) throws IOException{
		ObjectOutputStream outputStream = new ObjectOutputStream(out);
		outputStream.writeObject(obj);
		outputStream.flush();
		outputStream.close();
	}
	
	public Object load(InputStream in) throws IOException,ClassNotFoundException{
		ObjectInputStream inputStream = new ObjectInputStream(in);
		Object obj = inputStream.readObject();
		inputStream.close();
		return obj;
	}
}