package com.khoavida.step_definition;

import java.util.ArrayList;

import com.khoavida.config.PlaywrightConfig;
import com.khoavida.page.Cart_page;
import com.khoavida.page.Home_page;
import com.khoavida.page.Login_page;
import com.khoavida.page.Personal_infor_prompt;
import com.khoavida.page.Register_page;
import com.khoavida.page.Shop_page;
import com.khoavida.util.TestContext;
import com.khoavida.util.Utensil_login;
import com.khoavida.util.Utensil_register;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Step_definition_login{
	Utensil_register utensil_register = new Utensil_register();
	public Page page = PlaywrightConfig.getPage();
	TestContext context_1 = new TestContext();
	Home_page home = new Home_page();
	Login_page login = new Login_page();
	Shop_page shop = new Shop_page();
	Register_page register = new Register_page();
	Cart_page cart = new Cart_page();
	Personal_infor_prompt prompt = new Personal_infor_prompt();
	Utensil_login utensil = new Utensil_login();
	

	@When("user enter valid account and password")
	public void user_enter_valid_account_and_password() {
		try {
		ArrayList<String> user_infor = new ArrayList<String>();
		Thread.sleep(3000);
	    Thread.sleep(2000);
	    page.locator(login.email_xpath).fill("123321123@gmail.com");
	    Thread.sleep(2000);
	    page.locator(login.password_xpath).fill("123321123");
	    String username = page.locator(login.email_xpath).inputValue();
	    String password = page.locator(login.password_xpath).inputValue();
	    user_infor.add(username);
	    user_infor.add(password);
	    System.out.println(user_infor);
	    Thread.sleep(2000);
		} catch (InterruptedException e) {}
	}
	
	
	@When ("user enter invalid account and password")
	public void user_enter_invalid_account_and_password() throws InterruptedException {
		 Thread.sleep(1000);
		 page.locator(login.email_xpath).fill("232323@gmail.com");
		 page.locator(login.password_xpath).fill("1223232323");	
	}
	
	@When("user leave username field empty and enter password")
	public void user_leave_username_field_empty_and_enter_password() {
		try {
			Thread.sleep(2000);
			page.locator(login.email_xpath).fill("");
			Thread.sleep(2000);
			page.locator(login.password_xpath).fill("safwasd");
			Thread.sleep(2000);
			page.locator(login.login_button_xpath).click();
	    } catch (InterruptedException e) {}
	}
	@When("user fail to login with empty password field")
	public void user_fail_to_login_with_empty_password_field() {
		try {
			Thread.sleep(2000);
			page.locator(login.email_xpath).fill("1241231@gmail.com");
			Thread.sleep(2000);
			page.locator(login.password_xpath).fill("");
			Thread.sleep(2000);
			page.locator(login.login_button_xpath).click();
	    } catch (InterruptedException e) {}
	}
	@Then("user should see a notification for invalid account")
	public void user_should_see_a_notification_for_invalid_account() {
		try {
			Thread.sleep(2000);
			utensil.check_Visibility(login.invalid_noti_xpath);
	    } catch(InterruptedException e) {}
	}
	@Then("user should see a notification to remind entering username")
	public void user_should_see_a_notification_to_remind_entering_username() {
		try {
			Thread.sleep(2000);
			utensil.check_fieldValidity(login.email_xpath);		
		} catch(InterruptedException e) {}
	}
	
	@When("user enter username and leave password field empty")
	public void user_enter_username_and_leave_password_field_empty() {
		try {
			Thread.sleep(2000);
			page.locator(login.email_xpath).fill("123124@gmail.com");
			Thread.sleep(2000);
			page.locator(login.password_xpath).fill("");
			Thread.sleep(2000);
			page.locator(login.login_button_xpath).click();
	    } catch (InterruptedException e) {}
	}
	@Then("user should see a notification to remind entering password")
	public void user_should_see_a_notification_to_remind_entering_password() {
		try {
			Thread.sleep(2000);
			utensil.check_fieldValidity(login.password_xpath);
		} catch(InterruptedException e) {}
	}
	
	
}
