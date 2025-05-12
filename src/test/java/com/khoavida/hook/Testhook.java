package com.khoavida.hook;

import com.khoavida.config.*;
import io.cucumber.java.Before;
import io.cucumber.java.After;

public class Testhook {
	public static final String base_url = "https://ecommerce2.khoavida.com/";
	
	//RUN BEFORE EACH SCENARIO
	@Before
	public void Setup() {
		PlaywrightConfig.getPlaywright();
		PlaywrightConfig.getBrowser();
		PlaywrightConfig.getPage();
		System.out.println("test begins!".toUpperCase());
	}
	
	//RUN AFTER EACH SCENARIO
	@After
	public void Close() {
		System.out.println("Test finished.".toUpperCase());
	}
}
