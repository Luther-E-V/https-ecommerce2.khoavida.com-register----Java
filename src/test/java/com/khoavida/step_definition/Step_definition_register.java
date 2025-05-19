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
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Step_definition_register{
	Utensil_register utensil_register = new Utensil_register();
	public Page page = PlaywrightConfig.getPage();
	TestContext context_1 = new TestContext();
	Home_page home = new Home_page();
	Login_page login = new Login_page();
	Shop_page shop = new Shop_page();
	Register_page register = new Register_page();
	Cart_page cart = new Cart_page();
	Personal_infor_prompt prompt = new Personal_infor_prompt();
	Utensil_login utensil_login = new Utensil_login();
	
	
	@When("user click register link")
	public void user_click_register_link() {
	   page.locator(home.register_top_xpath).click();
	}
	@Then("user at register page")
	public void user_at_register_page() {
		utensil_login.check_Navigation("Register", register.title);
	}
	@When("user enter {string}, {string}, {string} and {string}")
	public void user_enter_and(String name, String email, String password, String confirm_password) throws InterruptedException{
		Thread.sleep(2000);
	    register.user_input(name, email, password, confirm_password);
	    Thread.sleep(2000);
		register.fill_user_infor();
	}
	@When("user click register button")
	public void user_click_register_button() throws InterruptedException {
	  
	    Thread.sleep(2000);
	    utensil_register.Register_name_check();
	    utensil_register.Register_password_check();
	    Thread.sleep(2000);
	    page.locator(register.register_button_xpath).click();
	}
}
