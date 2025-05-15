package com.khoavida.hook;

import com.khoavida.config.*;
import com.microsoft.playwright.Page;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.AfterAll;


public class Testhook {
	public static final String base_url = "https://ecommerce2.khoavida.com/";
	//RUN BEFORE ALL SCENARIO
	@BeforeAll
	public static void Global_Setup() {
		System.out.println("test begins!".toUpperCase());
		PlaywrightConfig.getPlaywright();
		PlaywrightConfig.getBrowser();
		PlaywrightConfig.getPage();	
	}

	//RUN AFTER ALL SCENARIO
	@AfterAll
	public static void Global_Close() {
		PlaywrightConfig.closePlaywright();
		System.out.println("Test finished.".toUpperCase());
	}
}
