package com.khoavida.page;
import java.util.List;

import com.microsoft.playwright.*;


public class Playwright_initiator {
	private static Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setArgs(List.of("--start-maximized")));
	public static Page page = browser.newPage();
	
	public void browser_close() {
		page.close();
		browser.close();
	}
}
