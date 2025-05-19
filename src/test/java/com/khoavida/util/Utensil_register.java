package com.khoavida.util;

import com.khoavida.config.PlaywrightConfig;
import com.microsoft.playwright.Page;
import com.khoavida.page.*;

public class Utensil_register {
	private Page page = PlaywrightConfig.getPage();
	Register_page register = new Register_page();
	//REGISTER NAME FIELD CHECK
	public void Register_name_check() {
		char[] register_name_special_char = page.locator(register.username_field_xpath).inputValue().replaceAll("[a-zA-Z0-9]", "").toCharArray();
		String used_special_char = page.locator(register.username_field_xpath).inputValue().replaceAll("[a-zA-Z0-9]", " ");
		if (register_name_special_char.length >= 1) {
			if (page.locator("//p[text()='Special characters are not allowed in this field']").count() == 1) {
				System.out.println("* USER'S NAME:\n- Special character used in user name: " + used_special_char);
				System.out.println(" - The special character validation notification is VISIBLE");
			} else if (page.locator("//p[text()='Special characters are not allowed in this field']").count() >= 1) {
				System.out.println(" - There are MORE than 1 special character validation notification");
			}
			else {
				System.out.println("- USER'S NAME:\n - Special character used in user name: " + used_special_char);
				System.out.println(" - The special character validation notification is INVISIBLE");
			}
		} else {
			System.out.println("User's name: " + page.locator(register.username_field_xpath).inputValue() + "\nValid name");
		}
	}
	//REGISTER EMAIL FIELD CHECK
	public void Register_email_check() {
		String[] allowed_email_special_character_list = {"@","-","_","."};
		String register_email = page.locator(register.email_field_xpath).inputValue();
		int email_length = register_email.length();
		if (register_email != null ) {
			char[] email_special_char_list = register_email.toCharArray();
			for (int i = 0; i>=0;i++) {
				//FIRST CHAR OF EMAIL CHECK
					boolean first_email_char_check = Character.isLetterOrDigit(email_special_char_list[0]);
					if (!first_email_char_check) {
						System.out.println("The first character of email is: " + email_special_char_list[0]);
						if(page.locator("//p[text()='Improper email format']").count() == 1) {
							
							System.out.println("The special character validation notification is VISIBLE");
						} 
						else {
							System.out.println("The first character of email is: " + email_special_char_list[i-i]);
							System.out.println("The special character validation notification is INVISIBLE");
						}	
					}
				}
			}
		}
	//REGISTER PASSWORD CHECK
	public void Register_password_check() {
		String register_password = page.locator(register.password_field_xpath).inputValue();
		String register_confirm_password = page.locator(register.confirm_password_field_xpath).inputValue();
		int register_password_special_char = register_password.replaceAll("[a-zA-Z0-9]","").toCharArray().length;
		int register_password_capital_letter = register_password.replaceAll("[^A-Z]","").toCharArray().length;
		int register_password_number = register_password.replaceAll("[^0-9]","").toCharArray().length;
		int register_password_letter = register_password.replaceAll("[^a-z]","").toCharArray().length;
		
		//PASSWORD'S LENGTH SHORTER THAN 8
		if (register_password.length() <= 7) {
			if (page.locator("//p[text()='Your password must be at least 8 characters']").count() == 1) {
				if (page.locator("//p[text()='Your password must be at least 8 characters'").isVisible()) {
					System.out.println("* PASSWORD: \n - The password length validation notification is VISIBLE");
				} else {
					System.out.println("The password length validation notification is INVISIBLE");
				}
			} else {
					System.out.println("There is NO notification for the password lenghth validation");
				}
			
		//PASSWORD'S LENGTH LONGER THAN 40
		} else if (register_password.length() >= 41) {
			if (page.locator("//p[text()='Your password length must be in range from 8 to 40]").count() == 1) {
				if (page.locator("//p[text()='Your password length must be in range from 8 to 40").isVisible()) {
					System.out.println("* PASSWORD: \n - The notification for exceeding password length validation is VISIBLE");
				} else {
				System.out.println("The notification for exceeding password lenghth validation is INVISIBLE");
				}
			} else if (page.locator("//p[text()='Your password length must be in range from 8 to 40]").count() >= 1) {
			System.out.println("There are MORE than 1 notifitcation for exceeding password length validation");				
				} else {
				System.out.println("There is NO notification for exceeding password lenghth validation");
				}
			
		//PASSWORD'S LENGTH IN RANGE OF (8,40)
		} else {		
			if(register_password_special_char >= 1 && register_password_capital_letter >= 1 && register_password_number >= 1 && register_password_letter >= 1) {
				if (register_password.contains(" ")) {
					if (page.locator("//p[text()='Your password must not include space']").count() == 1) {
						if (page.locator("//p[text()='Your password must not include space']").isVisible()) {
							System.out.println("The password's space validation notification is VISIBLE");
						} else {
							System.out.println("The password's space validation notification is INVISIBLE");
						}
					} else {
						System.out.println("The password's space validation notification is MISSING");
					}
				} else {
					System.out.println("Registered password: " + register_password +"\nThe registered password is properly formatted");
				}
			} else if (register_password_special_char == 0) {
					if (page.locator("//p[text()='Your password must include at least ONE special character']").count() == 1) {
						if (page.locator("//p[text()='Your password must include at least ONE special character']").isVisible()) {
							System.out.println("The password's letter requirement notification is VISIBLE");
						} else {
							System.out.println("The password's letter requirement notification is INVISIBLE");
						}
					} else if (page.locator("//p[text()='Your password must include at least ONE special character']").count() > 1) {
						System.out.println("The password's letter requirement notification is MORE than 1");
					} else {
						System.out.println("The password's letter requirement notification is MISSING");
					}
			} else if (register_password_capital_letter == 0) {
				if (page.locator("//p[text()='Your password must include at least ONE capital letter']").count() == 1) {
					if (page.locator("//p[text()='Your password must include at least ONE capital letter']").isVisible()) {
						System.out.println("The password's capital letter requirement notification is VISIBLE");
					} else {
						System.out.println("The password's capital letter requirement notification is INVISIBLE");
					}
				} else if (page.locator("//p[text()='Your password must include at least ONE special character']").count() > 1) {
					System.out.println("The password's capital letter requirement notification is MORE than 1");
				} else {
					System.out.println("The password's capital letter requirement notification is MISSING");
				}
			} else if (register_password_number == 0) {
				if (page.locator("//p[text()='Your password must include at least ONE number']").count() == 1) {
					if (page.locator("//p[text()='Your password must include at least ONE number']").isVisible()) {
						System.out.println("The password's number requirement notification is VISIBLE");
					} else {
						System.out.println("The password's number requirement notification is INVISIBLE");
					}
				} else if (page.locator("//p[text()='Your password must include at least ONE number']").count() > 1) {
					System.out.println("The password's number requirement notification is MORE than 1");
				} else {
					System.out.println("The password's number requirement notification is MISSING");
				}
			} else if (register_password_letter == 0) {
				if (page.locator("//p[text()='Your password must include at least ONE letter']").count() == 1) {
					if (page.locator("//p[text()='Your password must include at least ONE letter']").isVisible()) {
						System.out.println("The password's letter requirement notification is VISIBLE");
					} else {
						System.out.println("The password's letter requirement notification is INVISIBLE");
					}
				} else if (page.locator("//p[text()='Your password must include at least ONE number']").count() > 1) {
					System.out.println("The password's letter requirement notification is MORE than 1");
				} else {
					System.out.println("The password's letter requirement notification is MISSING");
				}
			}

			}
		}
}
