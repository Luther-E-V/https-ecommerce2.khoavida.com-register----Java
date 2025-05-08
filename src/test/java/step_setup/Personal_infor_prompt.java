package step_setup;
import com.microsoft.playwright.Page;

import step_setup.Playwright_initiator;

public class Personal_infor_prompt {
	
	private Page page = step_setup.Playwright_initiator.page;
	//FIELDS
	public final String fullname_field_xpath = "//label[text()='Full Name']";
	public final String email_address_xpath = "//label[text()='Email Address']";
	public final String shipping_address_xpath = "//label[text()='Shipping Address']";
	public final String card_number_xpath = "//label[text()='Card Number']";
	public final String name_on_card_xpath = "//label[text()='Name on Card']";
	public final String expiry_date_xpath = "//label[text()='Expiry Date']";
	public final String cvc_xpath = "//label[text()='CVC']";
	//BUTTON
	public final String place_order_button_xpath = "//button[text()='Place Order']";
	
	
	public void user_infor_retrieve() {
		String user_fullname = page.locator(fullname_field_xpath).inputValue();
		String user_email_address = page.locator(email_address_xpath).inputValue();
		String user_shipping_address = page.locator(shipping_address_xpath).inputValue();
		String user_card_number = page.locator(card_number_xpath).inputValue();
		String user_name_on_card = page.locator(name_on_card_xpath).inputValue();
		String user_expiry_date= page.locator(expiry_date_xpath).inputValue();
		String user_cvc = page.locator(cvc_xpath).inputValue();
		System.out.println("Fullname: " + user_fullname);
		System.out.println("Email address: " + user_email_address);
		System.out.println("Shipping address: " + user_shipping_address);
		System.out.println("Card number: " + user_card_number);
		System.out.println("Name on card: " + user_name_on_card);
		System.out.println("Expiry date: " + user_expiry_date);
		System.out.println("CVC: " + user_cvc);
		
	}
}
