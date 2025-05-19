package com.khoavida.step_definition;

import com.khoavida.config.*;
import com.khoavida.page.*;
import com.microsoft.playwright.*;
import com.khoavida.util.Utensil_login;
import java.util.ArrayList;
import com.khoavida.util.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Step_definition {
	
	public Page page = PlaywrightConfig.getPage();
	TestContext context_1 = new TestContext();
	Home_page home = new Home_page();
	Login_page login = new Login_page();
	Shop_page shop = new Shop_page();
	Register_page register = new Register_page();
	Cart_page cart = new Cart_page();
	Personal_infor_prompt prompt = new Personal_infor_prompt();
	Utensil_login utensil = new Utensil_login();
	
	@Given("user navigate to page")
	public void user_navigate_to_page() {
	    page.navigate("https://ecommerce2.khoavida.com/");
	    utensil.Logout();
	}
	@Given("user at login page")
	public void user_at_login_page() {
	    String page_title = "h4";
	    utensil.check_Navigation("Login",page_title);
	}
}

