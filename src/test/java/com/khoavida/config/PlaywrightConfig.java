package com.khoavida.config;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;


public class PlaywrightConfig {
	private static Playwright playwright;
	private static Browser browser;
	private static Page page;
	
	//
	public static final boolean headless = false;
	public static final int timeout = 3000;
	
	private PlaywrightConfig() {}
	
	public static Playwright getPlaywright() {
		if (playwright == null) {
			playwright = Playwright.create();
		}
		return playwright;
	}
	public static Browser getBrowser() {
		if(browser == null) {
			browser = PlaywrightConfig.getPlaywright().chromium().launch(new BrowserType.LaunchOptions().setHeadless(headless).setTimeout(timeout));
		} 
		return browser;
	}
	public static Page getPage() {
		if(page == null) {
			page = PlaywrightConfig.getBrowser().newPage();
		}
		return page;
	}
	public static void closePlaywright() {
		if (page != null) page.close();
		if (browser != null) browser.close();
		if (playwright != null) playwright.close();
	}
}
