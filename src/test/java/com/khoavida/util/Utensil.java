package com.khoavida.util;

import java.util.ArrayList;
import java.util.List;

import com.khoavida.config.PlaywrightConfig;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.khoavida.page.*;


public class Utensil {
	private Page page = PlaywrightConfig.getPage();
	
	public void check_accoutInvalidity() {
		
	}
	
	public void check_Navigation(String expected_String, String actual_String, String expected_page) {
		if (actual_String.equals(expected_String)) {
	    	System.out.println("User is navigated to expected page " + expected_page);
	    } else {
	    	System.out.println("User is not navigated to expected page");
	    }
	}
	
	public void check_fieldValidity(String field_xpath) {
		boolean expected_reminder_checkValidity = (boolean) page.locator(field_xpath).evaluate("el=> el.checkValidity()");
		String expected_reminder_message = (String) page.locator(field_xpath).evaluate("el => el.validationMessage");
		if (!expected_reminder_checkValidity) {
			System.out.println("The reminder is: " + expected_reminder_message.toUpperCase() + "\nTest passed");		
			} else {
			System.out.println("There is no validation message to remind user entering the field.\nTest failed");
			}
	}
	
	public void check_Visibility(String element_need_checking) {
		boolean element = page.locator(element_need_checking).isVisible();
		String element_inner_text = page.locator(element_need_checking).innerText();
		if (element) {
	    	System.out.println("Element is visible".toUpperCase());
	    	if (element_inner_text != null) {
	    		System.out.println(element_inner_text);
	    	} else {
	    	System.out.println("The element is not displayed".toUpperCase());
	    	}
		}
	} 
	
	public void Login_result() throws Exception{
		Home_page home = new Home_page();
		Login_page login = new Login_page();
		boolean invalid_account_noti_visible = page.locator(login.invalid_noti_xpath).isVisible();
		boolean improper_email_format_noti_visible = page.locator(login.email_xpath).isVisible();
		boolean homepage_title_visible = page.locator(home.title).isVisible();	
		
		if (invalid_account_noti_visible) {
			System.out.println("Invalid account.\nSystem notifies: " + page.locator(login.invalid_noti_xpath).innerText());
		} else if (improper_email_format_noti_visible) {
			System.out.println("Imporper email format.\nSytem notifies: " + page.locator(login.empty_email_noti_xpath).innerText());
		} else if (homepage_title_visible) {
			System.out.println("Valid account.\nUser gets redirected to Home page");
			Thread.sleep(2000);
			page.locator(home.logout_top_xpath);
		}
	}
	public void Logout() {
		Home_page home = new Home_page();
		if (page.locator(home.logout_top_xpath).count() == 1) {
			page.click(home.logout_top_xpath);
			
		}
		
		
		
	}
}
