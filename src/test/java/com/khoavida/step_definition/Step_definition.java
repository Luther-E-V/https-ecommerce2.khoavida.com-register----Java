package com.khoavida.step_definition;

import com.khoavida.config.*;
import com.khoavida.page.*;
import com.microsoft.playwright.*;
import com.khoavida.util.Utensil;
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
	Utensil utensil = new Utensil();
	
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
	    utensil.check_Navigation("Login",page_title);
	    
	}
	
	@When("user enter valid account and password")
	public void user_enter_valid_account_and_password() {
		try {
		ArrayList<String> user_infor = new ArrayList<String>();
		Thread.sleep(3000);
	    String username_field_xpath = login.email_xpath;
	    String password_field_xpath = login.password_xpath;
	    Thread.sleep(2000);
	    page.locator(username_field_xpath).fill("123321123@gmail.com");
	    String username = page.locator(username_field_xpath).inputValue();
	    Thread.sleep(2000);
	    page.locator(password_field_xpath).fill("123321123");
	    String password = page.locator(password_field_xpath).inputValue();
	    user_infor.add(username);
	    user_infor.add(password);
	    System.out.println(user_infor);
	    Thread.sleep(2000);
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
			utensil.check_Navigation("Featured Products", homepage_title_isVisible);
			utensil.Logout();
			} catch (InterruptedException e) {}
	}
	
	@When ("user enter invalid account and password")
	public void user_enter_invalid_account_and_password() {
		 String username_field_xpath = login.email_xpath;
		 String password_field_xpath = login.password_xpath;
		 page.locator(username_field_xpath).fill("232323@gmail.com");
		 page.locator(password_field_xpath).fill("1223232323");	
	}
	
	@When("user leave username field empty and enter password")
	public void user_leave_username_field_empty_and_enter_password() {
		try {
			Thread.sleep(2000);
		String username_field_xpath = login.email_xpath;
	    String password_field_xpath = login.password_xpath;
	    page.locator(username_field_xpath).fill("");
	    Thread.sleep(2000);
	    page.locator(password_field_xpath).fill("safwasd");
	    Thread.sleep(2000);
	    page.locator(login.login_button_xpath).click();
	    } catch (InterruptedException e) {}
	}
	@When("user fail to login with empty password field")
	public void user_fail_to_login_with_empty_password_field() {
		try {
		Thread.sleep(2000);
		String username_field_xpath = login.email_xpath;
	    String password_field_xpath = login.password_xpath;
	    page.locator(username_field_xpath).fill("1241231@gmail.com");
	    Thread.sleep(2000);
	    page.locator(password_field_xpath).fill("");
	    Thread.sleep(2000);
	    page.locator(login.login_button_xpath).click();
	    } catch (InterruptedException e) {}
	}
	@Then("user should see a notification for invalid account")
	public void user_should_see_a_notification_for_invalid_account() {
		try {
		Thread.sleep(2000);
	    String expected_noti_xpath = "//p[text()='Invalid credentials']";
	    boolean noti_isVisible = page.locator(expected_noti_xpath).isVisible();
	    utensil.check_Visibility(noti_isVisible, "Invalid credentials");
	    } catch(InterruptedException e) {}
	}
	@Then("user should see a notification to remind entering username")
	public void user_should_see_a_notification_to_remind_entering_username() {
		try {
			Thread.sleep(2000);
			Locator username_field = page.locator(login.email_xpath);
			utensil.check_fieldValidity(username_field);		
		} catch(InterruptedException e) {}
	}
	
	@When("user enter username and leave password field empty")
	public void user_enter_username_and_leave_password_field_empty() {
		try {
			Thread.sleep(2000);
			String username_field_xpath = login.email_xpath;
			String password_field_xpath = login.password_xpath;
			page.locator(username_field_xpath).fill("123124@gmail.com");
			Thread.sleep(2000);
			page.locator(password_field_xpath).fill("");
			Thread.sleep(2000);
			page.locator(login.login_button_xpath).click();
	    } catch (InterruptedException e) {}
	}
	@Then("user should see a notification to remind entering password")
	public void user_should_see_a_notification_to_remind_entering_password() {
		try {
			Thread.sleep(2000);
			Locator password_field = page.locator(login.password_xpath);
			utensil.check_fieldValidity(password_field);
		} catch(InterruptedException e) {}
	}
}
