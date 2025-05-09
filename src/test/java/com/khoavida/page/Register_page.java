package com.khoavida.page;

import java.util.Scanner;

import com.microsoft.playwright.Page;

public class Register_page {
	public final String username_field_xpath = "(//input[contains(@class,'MuiOutlinedInput-input')])[1]";
	public final String password_field_xpath = "(//input[contains(@class,'MuiOutlinedInput-input')])[3]";
	public final String email_field_xpath = "(//input[contains(@class,'MuiOutlinedInput-input')])[2]";
	public final String confirm_password_field_xpath = "(//input[contains(@class,'MuiOutlinedInput-input')])[4]";
	public final String register_button_xpath = "//button[text()='Register']";
	public  String username,password,email,confirm_password;
	
	private Page page = com.khoavida.page.Playwright_initiator.page;
	
	
	public void user_input(String username,String password,String email,String confirm_password) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.confirm_password = confirm_password;
	}
	public void fill_user_infor() {
		Scanner scanner = new Scanner(System.in);
		page.fill(username_field_xpath, this.username);
		page.fill(email_field_xpath, this.email);
		page.fill(password_field_xpath, this.password);
		page.fill(confirm_password_field_xpath, this.confirm_password);
		boolean Check_confirm_password = this.confirm_password.equals(this.password);
		for(int time = 0; time <= 5; time++) {
			if (!Check_confirm_password) {
				boolean warning_check = page.locator("//p[contains(@class,'MuiTypography-body2') and text()='Passwords do not match']").isVisible();
				System.out.println(warning_check);
				System.out.print("Please re-confirm your password!: ");
				this.confirm_password = scanner.nextLine();
				System.out.println(this.confirm_password);
			} else {
				page.fill(confirm_password_field_xpath, this.confirm_password);
				page.locator("//p[contains(@class,'MuiTypography-body2') and text()='Passwords do not match']").isVisible();
			}
			
		}
	}
	public void user_infor_retrieve() {
		String username = page.locator(username_field_xpath).inputValue();
		String password = page.locator(password_field_xpath).inputValue();
		String email = page.locator(email_field_xpath).inputValue();
		String confirm_password = page.locator(confirm_password_field_xpath).inputValue();
		System.out.println("- Username: " + username + "\n" + "- Email: " + email + "\n" + "- Password:" +password + "\n" + "- Confirm password: " + confirm_password);
	}
	
}
