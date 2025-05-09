package com.khoavida.hook;

import java.util.List;

import com.microsoft.playwright.*;
import io.cucumber.java.Before;
import io.cucumber.java.After;

public class Testhook {
	private Playwright playwright;
	private Browser browser;
	private Page page;
	
	@Before
	public void Setup() {
		playwright = Playwright.create();
		browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setArgs(List.of("--start-maximized")));
		page = browser.newPage();
		System.out.println("Playwright setup has done. Start to test!".toUpperCase());
	}
	@After
	public void Close() {
		page.close();
		browser.close();
		playwright.close();
		System.out.println("Test finished.".toUpperCase());
	}
}
