package step_definition;
import com.microsoft.playwright.*;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import step_setup.*;

public class Step_definition {
	
	private Page page = step_setup.Playwright_initiator.page;
	Playwright_initiator initiator = new Playwright_initiator();
	Home_page home = new Home_page();
	Login_page login = new Login_page();
	Shop_page shop = new Shop_page();
	Register_page register = new Register_page();
	Cart_page cart = new Cart_page();
	
	@Given("user access homepage and click register")
	public void user_access_homepage() {
		page.navigate("https://ecommerce2.khoavida.com/register");
		page.locator(home.register_top_xpath).click();
		String username = "124512";
		String password = "1241241";
		String email = "sdasda@gmail.com";
		String confirm_password = "sdsdasd";
		register.user_input(username, password, email, confirm_password);
		register.user_infor_retrieve();
		page.locator(register.register_button_xpath).click();
		
		
	}

	@Then("user navigate to homepage")
	public void user_navigate_to_homepage() {
	    
		
		
		
	}
}
