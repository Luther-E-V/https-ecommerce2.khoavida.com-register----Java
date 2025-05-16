package com.khoavida.page;
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
	public final String email_xpath = "//div[./label[text()='Email']]//input[contains(@type,'text')]";
	public final String password_xpath = "//div[./label[text()='Password']]//input[contains(@type,'password')]";
	//BUTTON & LINK TEXT
	public final String reveal_password_xpath = "//div[contains(@class,'MuiInputBase-root')][./div]//button";
	public final String login_button_xpath = "//button[text()='Login']";
	public final String forgot_password_xpath = "//a[text()='Forgot password?']";
	public final String register_here_xpath = "//a[text()='Register here']";
	//INVALID NOTI
	public final String invalid_noti_xpath = "//p[text()='Invalid credentials']";
	public final String empty_email_noti_xpath = "//p[text()='Please include a valid email']";
	public final String[] invalid_case = {"Invalid credentials","Please include a valid email"}; 
}
