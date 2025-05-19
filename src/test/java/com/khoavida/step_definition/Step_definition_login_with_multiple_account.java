package com.khoavida.step_definition;

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
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Step_definition_login_with_multiple_account {
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
	
	@When("user click login link")
	public void user_click_login_link() {
	    page.locator(home.login_top_xpath).click();
	}
	@When("user enter {string} and {string}")
	public void user_enter_username_and_password(String accountname, String password) {
		try {
			Thread.sleep(2000);
			page.locator(login.email_xpath).fill(accountname);
			page.locator(login.password_xpath).fill(password);
	    } catch (InterruptedException e) {}
	}
	@And("user click login button")
	public void user_click_login_button() {
	    page.locator(login.login_button_xpath).click();
	}
	@Then("user should be navigate to homepage after click login button")
	public void user_should_be_navigate_to_homepage_after_click_login_button() throws Exception {
	    try {
	        Thread.sleep(2000);
	        utensil.Login_result();
	        
	    } catch (InterruptedException e) {}
	}
}
