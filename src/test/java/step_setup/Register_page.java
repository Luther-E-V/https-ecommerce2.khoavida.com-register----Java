package step_setup;

import java.util.Scanner;

import com.microsoft.playwright.Page;

public class Register_page {
	public final String username_field_xpath = "(//input[contains(@class,'MuiOutlinedInput-input')])[1]";
	public final String password_field_xpath = "(//input[contains(@class,'MuiOutlinedInput-input')])[3]";
	public final String email_field_xpath = "(//input[contains(@class,'MuiOutlinedInput-input')])[2]";
	public final String confirm_password_field_xpath = "(//input[contains(@class,'MuiOutlinedInput-input')])[4]";
	public final String register_button_xpath = "//button[text()='Register']";
	public  String username,password,email,confirm_password;
	
	private Page page = step_setup.Playwright_initiator.page;
	
	
	public void user_input(String username,String password,String email,String confirm_password) {
		Scanner scanner = new Scanner(System.in);
		this.username = username;
		this.password = password;
		this.email = email;
		this.confirm_password = confirm_password;
		page.fill(username_field_xpath, this.username);
		page.fill(email_field_xpath, this.email);
		page.fill(password_field_xpath, this.password);
		page.fill(confirm_password_field_xpath, this.confirm_password);
		for(int time = 0; time <= 5; time++) {
			if (this.confirm_password.equals(this.password)) {
				page.fill(confirm_password_field_xpath, this.confirm_password);
			} else {
				page.locator("//p[contains(@class,'MuiTypography-body2') and text()='Passwords do not match']").isVisible();
				System.out.println("Please re-confirm your password!: ");
				String re_confirm_password = scanner.nextLine();
				System.out.println(re_confirm_password);
			}
			
		}
	}
	public void user_infor_retrieve() {
		String username = page.locator(username_field_xpath).inputValue();
		String password = page.locator(password_field_xpath).inputValue();
		String email = page.locator(email_field_xpath).inputValue();
		String confirm_password = page.locator(confirm_password_field_xpath).inputValue();
		System.out.println(username + "\n" + email + "\n" + password + "\n" + confirm_password);
	}
	
}
