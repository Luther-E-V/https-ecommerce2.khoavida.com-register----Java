package com.khoavida.util;

import com.khoavida.config.PlaywrightConfig;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.khoavida.page.*;


public class Utensil {
	private Page page = PlaywrightConfig.getPage();
	
	public void check_accoutInvalidity() {
		
	}
	
	public void check_Navigation(String expected_String, String actual_String) {
		if (actual_String.equals(expected_String)) {
	    	System.out.println("User is at Login Page".toUpperCase());
	    } else {
	    	System.out.println("user is navigated to " + actual_String +" page".toUpperCase());
	    }
	}
	
	public void check_fieldValidity(Locator field_xpath) {
		boolean expected_reminder_checkValidity = (boolean) field_xpath.evaluate("el=> el.checkValidity()");
		String expected_reminder_message = (String) field_xpath.evaluate("el => el.validationMessage");
		if (!expected_reminder_checkValidity) {
			System.out.println("The reminder is: " + expected_reminder_message.toUpperCase() + "\nTest passed");		
			} else {
			System.out.println("There is no validation message to remind user entering the field.\nTest failed");
			}
	}
	
	public void check_Visibility(boolean expected, String expect) {
		if (expected) {
	    	System.out.println("Notification for " + expect + " is visible. test passes!".toUpperCase());
	    } else {
	    	System.out.println("There is no notification for " + expect + " displayed. Test failed!".toUpperCase());
	    }
	}
	public void Logout() {
		Home_page home = new Home_page();
		if (home.login_top_xpath != null) {
			page.locator(home.logout_top_xpath).click();
		}
	}
}
