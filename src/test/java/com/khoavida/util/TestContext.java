package com.khoavida.util;

import java.util.HashMap;
import java.util.Map;

public class TestContext {
	
	private Map<String,String> Testcontext;
	//CONSTRUCTOR
	public TestContext() {
		Testcontext = new HashMap<>();
	}
	
	//ADD DATA TO MAP
	public void Add_data(String key, String value) {
		Testcontext.put(key,value);
	}
	
	//REMOVE DATA FROM MAP
	public void Remove_data(String key) {
		Testcontext.remove(key);
	}
	
	//GET DATA FROM MAP
	public String Get_data(String key) {
		return Testcontext.get(key);
	}
	
	//CLEAR DATA
	public void Clear_data() {
		Testcontext.clear();
	}
	
}
