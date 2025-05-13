package com.khoavida.step_definition;

import com.khoavida.config.*;
import com.khoavida.page.*;
import com.microsoft.playwright.*;
import java.util.ArrayList;
import java.util.Random;
import com.khoavida.util.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Step_definition {
	
	private Page page = PlaywrightConfig.getPage();
	TestContext context_1 = new TestContext();
	Home_page home = new Home_page();
	Login_page login = new Login_page();
	Shop_page shop = new Shop_page();
	Register_page register = new Register_page();
	Cart_page cart = new Cart_page();
	Personal_infor_prompt prompt = new Personal_infor_prompt();
	
	@Given("user navigate to page")
	public void user_navigate_to_page() {
	    page.navigate("https://ecommerce2.khoavida.com/");
	}
	@When("user click login link")
	public void user_click_login_link() {
	    page.locator(home.login_top_xpath).click();
	}
	@Given("user at login page")
	public void user_at_login_page() {
	    String page_title = page.locator("h4").innerText();
	    if (page_title.equals("Login")) {
	    	System.out.println("User is at Login Page".toUpperCase());
	    } else {
	    	System.out.println("user is navigated to " + page_title +" page".toUpperCase());
	    }
	}
	@When("user enter valid account and password")
	public void user_enter_valid_account_and_password() {
		try {
		ArrayList<String> user_infor = new ArrayList<String>();
		Thread.sleep(3000);
	    String username_field_xpath = login.email_xpath;
	    String password_field_xpath = login.password_xpath;
	    Thread.sleep(3000);
	    page.locator(username_field_xpath).fill("123321123@gmail.com");
	    String username = page.locator(username_field_xpath).inputValue();
	    Thread.sleep(3000);
	    page.locator(password_field_xpath).fill("123321123");
	    String password = page.locator(password_field_xpath).inputValue();
	    user_infor.add(username);
	    user_infor.add(password);
	    System.out.println(user_infor);
	    Thread.sleep(3000);
		} catch (InterruptedException e) {}
	}
	@And("user click login button")
	public void user_click_login_button() {
	    page.locator(login.login_button_xpath).click();
	}
	@Then("user should be navigate to homepage")
	public void user_should_be_navigate_to_homepage() {
		try {
			Thread.sleep(2000);
			Locator homepage_title_xpath = page.locator("//h4");
			String homepage_title_isVisible = homepage_title_xpath.innerText();
			if (homepage_title_isVisible.equals("Featured Products")) {
				System.out.println("User has been navigated to Homepage.");
				context_1.Add_data("Valid account", "Test passed!");
				System.out.println(context_1.Get_data("Valid account"));
				
			} else {
				System.out.println("User is not at Homepage.");
				context_1.Add_data("Valid account", "Test failed");
				System.out.println(context_1.Get_data("Valid account"));
			}
			} catch (InterruptedException e) {}
	}
	
	@When ("user enter invalid account and password")
	public void user_enter_invalid_account_and_password() {
		 String username_field_xpath = login.email_xpath;
		 String password_field_xpath = login.password_xpath;
		 page.locator(username_field_xpath).fill("232323@gmail.com");
		 page.locator(password_field_xpath).fill("1223232323");
		 ArrayList<String> user_infor = new ArrayList<String>();
		 user_infor.add(username_field_xpath);
		 user_infor.add(password_field_xpath);
		 System.out.println(user_infor);
		
	}
	
	@When("user leave username field empty and enter password")
	public void user_leave_username_field_empty_and_enter_password() {
		String username_field_xpath = login.email_xpath;
	    String password_field_xpath = login.password_xpath;
	    page.locator(username_field_xpath).fill("");
	    page.locator(password_field_xpath).fill("safwasd");
	    page.locator(login.login_button_xpath).click();
	}

	@Then("user should see a notification for invalid account")
	public void user_should_see_a_notification_for_invalid_account() {
	    String expected_noti_xpath = "//p[text()='Invalid credentials']";
	    boolean noti_isVisible = page.locator(expected_noti_xpath).isVisible();
	    if (noti_isVisible) {
	    	System.out.println("Notification for invalid account is visible. test passes!".toUpperCase());
	    } else {
	    	System.out.println("There is no notification displayed. Test failed!".toUpperCase());
	  
	    }
	}
	@Then("user should see a notification to remind entering field")
	public void user_should_see_a_notification_to_remind_entering_field() {
		Locator username_field = page.locator(login.login_button_xpath);
		String expected_reminder = (String) username_field.evaluate("el=> el.validationMessage");
		System.out.print(expected_reminder);
	}
}
