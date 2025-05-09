package com.khoavida.page;
import com.khoavida.page.Playwright_initiator;
import com.microsoft.playwright.Page;

import java.util.Scanner;


public class Login_page {
	//TOP BASIC BUTTON
	public final String home_top_xpath = "//a[contains(@class,'MuiButtonBase-root') and text()='Home']";
	public final String shop_top_xpath = "//a[contains(@class,'MuiButtonBase-root') and text()='Shop']";
	public final String register_top_xpath = "//a[contains(@class,'MuiButton-text') and text()='Register']";
	public final String login_top_xpath = "//a[contains(@class,'MuiButtonBase-root') and text()='Login']";
	public final String cart_top_xpath = "//span[contains(@class,'MuiBadge-standard')]";
	//INPUT FIELD
	public final String email_xpath = "//label[text()='Email']";
	public final String password_xpath = "//label[text()='Password']";
	//BUTTON & LINK TEXT
	public final String reveal_password_xpath = "//div[contains(@class,'MuiInputBase-root')][./div]//button";
	public final String login_button_xpath = "//button[text()='Login']";
	public final String forgot_password_xpath = "//a[text()='Forgot password?']";
	public final String register_here_xpath = "//a[text()='Register here']";
	
}
