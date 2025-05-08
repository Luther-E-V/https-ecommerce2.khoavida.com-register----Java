package step_definition;
import com.microsoft.playwright.*;
import java.util.Random;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import step_setup.*;

public class Step_definition {
	
	private Page page = step_setup.Playwright_initiator.page;
	Playwright_initiator initiator = new Playwright_initiator();
	Home_page home = new Home_page();
	Login_page login = new Login_page();
	Shop_page shop = new Shop_page();
	Register_page register = new Register_page();
	Cart_page cart = new Cart_page();
	Personal_infor_prompt prompt = new Personal_infor_prompt();
	
	@Given("user access homepage, click register")
	public void user_access_homepage() {
		Random random = new Random();
		int random_int = random.nextInt(0,101);
		try {
	    		Thread.sleep(2000);
	    		page.navigate("https://ecommerce2.khoavida.com/register");
			page.locator(home.register_top_xpath).click();
		
	    	}
	    	catch(InterruptedException e) {}
		
	}

	@Then("user navigate to Register page")
	public void user_navigate_to_homepage() {
	    	try {
	    		Thread.sleep(2000);
	    		System.out.println("OBSERVE");
	    	}
	    	catch(InterruptedException e) {}		
	}
	@When("user fill out infor and click register")
	public void user_fill_out_infor_and_click_register() {
	    Random random = new Random();
	    int random_int = random.nextInt(0,101);
	    	try {
	    		Thread.sleep(2000);
	   		String username = "124" + random_int + "512";
			String password = "123321123";
			String email = "sdas" + random_int + "da@gmail.com";
			String confirm_password = "123321123";
			Thread.sleep(2000);
			register.user_input(username, password, email, confirm_password);
			Thread.sleep(2000);
			register.fill_user_infor();
			Thread.sleep(2000);
			register.user_infor_retrieve();
			page.locator(register.register_button_xpath).click();
	    	}
	   	 catch(InterruptedException e) {}		
	}
	@Then("user get directed to Homepage")
	public void user_get_directed_to_homepage(){
		try {
		Thread.sleep(2000);
		System.out.println("OBSERVE");
	   	} catch(InterruptedException e) {}
	}
	@When("user sroll down and add to cart phone and headphone")
	public void user_sroll_down_and_add_to_cart_phone_and_headphone() {
		try {
	    	Thread.sleep(2000);
	    	page.locator(home.iphone_15_pro_max_add_to_cart_xpath).scrollIntoViewIfNeeded();
	    	Thread.sleep(3000);
	    	boolean iphone_addtoCart_button_Enable_check = page.locator(home.iphone_15_pro_max_add_to_cart_xpath).isEnabled();
	    	boolean iphone_addtoCart_button_Visible_check = page.locator(home.iphone_15_pro_max_add_to_cart_xpath).isVisible();
	    	if (iphone_addtoCart_button_Enable_check && iphone_addtoCart_button_Visible_check) {
	    		page.locator(home.iphone_15_pro_max_add_to_cart_xpath).click();
	    	} 
	    	else {
	    		System.out.println("Iphone's Add_to_Cart button is not working properly!");
	    	}
	    	page.locator(home.iphone_15_pro_max_add_to_cart_xpath).click();
	    	Thread.sleep(2000);
	    	boolean headphone_addtoCart_button_Enable_check = page.locator(home.sony_wh_1000xm5_headphones_add_to_cart_xpath).isEnabled();
	    	boolean headphone_addtoCart_button_Visible_check = page.locator(home.sony_wh_1000xm5_headphones_add_to_cart_xpath).isVisible();
	    	if (headphone_addtoCart_button_Enable_check && headphone_addtoCart_button_Visible_check) {
	    		page.locator(home.sony_wh_1000xm5_headphones_add_to_cart_xpath).click();
	    	} 
	    	else {
	    		System.out.println("Headphone's Add_to_Cart button is not working properly!");
	    	}	
	    }
	    catch(InterruptedException e) {}		
	}

	@When("user click cart logo on the right top of the page")
	public void user_click_cart_logo_on_the_right_top_of_the_page() {
		try {
	    	Thread.sleep(2000);
	    	String cart_logo_xpath = home.cart_top_xpath;
	    	String cart_number = page.locator(cart_logo_xpath).innerText();
	    	System.out.println("- The number displayed on CART logo is: " + cart_number);
	    	page.locator(cart_logo_xpath).click();
	    }
	    catch(InterruptedException e) {}		
	}

	@Then("user click proceed to checkout")
	public void user_click_proceed_to_checkout() {
		try {
	    	Thread.sleep(2000);
	    	String checkout_button_xpath = cart.proceed_to_checkout_button_xpath;
	    	page.locator(checkout_button_xpath).click();
	    }
	    catch(InterruptedException e) {}		
	}

	@When("user fill out with personal infor")
	public void user_fill_out_with_personal_infor() {
		Random random = new Random();
		int random_number = random.nextInt(100000000,999999999);
		try {
	    	Thread.sleep(2000);
	    	page.locator(prompt.fullname_field_xpath).fill("Luther Tran");
	    	Thread.sleep(2000);
	    	page.locator(prompt.email_address_xpath).fill("abcdef@gmail.com");
	    	Thread.sleep(2000);
	    	page.locator(prompt.shipping_address_xpath).fill("123 ABC Street");
	    	Thread.sleep(2000);
	    	page.locator(prompt.card_number_xpath).fill(String.valueOf(random_number));
	    	Thread.sleep(2000);
	    	page.locator(prompt.name_on_card_xpath).fill("Tran Wasd Luther");
	    	Thread.sleep(2000);
	    	page.locator(prompt.expiry_date_xpath).fill("12/12/2030");
	    	Thread.sleep(2000);
	    	page.locator(prompt.cvc_xpath).fill("242");
	    }
	    catch(InterruptedException e) {}		
	}

	@Then("user click PLACE ORDER")
	public void user_click_place_order() {
		try {
			Thread.sleep(2000);
			prompt.user_infor_retrieve();
	    	Thread.sleep(2000);
	    	page.locator(prompt.place_order_button_xpath).click();
	    }
	    catch(InterruptedException e) {}		
	}
}
