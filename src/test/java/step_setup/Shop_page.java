package step_setup;
import step_setup.Playwright_initiator;
import com.microsoft.playwright.Page;

public class Shop_page {
	private Page page = step_setup.Playwright_initiator.page;
	//TOP BASIC BUTTON
	public final String home_top_xpath = "//a[contains(@class,'MuiButtonBase-root') and text()='Home']";
	public final String shop_top_xpath = "//a[contains(@class,'MuiButtonBase-root') and text()='Shop']";
	public final String register_top_xpath = "//a[contains(@class,'MuiButton-text') and text()='Register']";
	public final String login_top_xpath = "//a[contains(@class,'MuiButtonBase-root') and text()='Login']";
	public final String cart_top_xpath = "//span[contains(@class,'MuiBadge-standard')]";
	
	//ITEMS' BUTTON
	public static final String camera_canon_eos_r15_add_to_cart_xpath = "//div[contains(@class,'MuiPaper-elevation')][.//div[contains(@class,'MuiTypography') and text()='Canon EOS R5']]//button[text()='Add to Cart']";
	public static final String camera_canon_eos_r15_view_detail_xpath = "//div[contains(@class,'MuiPaper-elevation')][.//div[contains(@class,'MuiTypography') and text()='Canon EOS R5']]//button[text()='View Details']";
	public static final String iphone_15_pro_max_add_to_cart_xpath = "//div[contains(@class,'MuiPaper-elevation')][.//div[contains(@class,'MuiTypography') and text()='iPhone 15 Pro Max']]//button[text()='Add to Cart']";
	public static final String iphone_15_pro_max_view_detail_xpath = "//div[contains(@class,'MuiPaper-elevation')][.//div[contains(@class,'MuiTypography') and text()='iPhone 15 Pro Max']]//button[text()='Add to Cart']";
	public static final String macbook_air_m2_add_to_cart_xpath = "//div[contains(@class,'MuiPaper-root MuiPaper-elevation')][.//div[text()='MacBook Air M2']]//button[text()='Add to Cart']";
	public static final String macbook_air_m2_view_detail_xpath = "//div[contains(@class,'MuiPaper-root MuiPaper-elevation')][.//div[text()='MacBook Air M2']]//button[text()='View Details']";
	public static final String sony_wh_1000xm5_headphones_add_to_cart_xpath = "//div[contains(@class,'MuiPaper-root MuiPaper-elevation')][.//div[text()='Sony WH-1000XM5 Headphones']]//button[text()='Add to Cart']";
	public static final String sony_wh_1000xm5_headphones_view_detail_xpath = "//div[contains(@class,'MuiPaper-root MuiPaper-elevation')][.//div[text()='Sony WH-1000XM5 Headphones']]//button[text()='View Details']";
	public static final String samsung_65_qled_tv_add_to_cart_xpath = "//div[contains(@class,'MuiPaper-root MuiPaper-elevation')][.//div[text()='Samsung 65\" QLED TV']]//button[text()='Add to Cart']";
	public static final String samsung_65_qled_tv_view_detail_xpath = "//div[contains(@class,'MuiPaper-root MuiPaper-elevation')][.//div[text()='Samsung 65\" QLED TV']]//button[text()='View Details']";
	public static final String apple_watch_series_7_add_to_cart_xpath = "//div[contains(@class,'MuiPaper-root MuiPaper-elevation')][.//div[text()='Apple Watch Series 7']]//button[text()='Add to Cart']";
	public static final String apple_watch_series_7_view_detail_xpath = "//div[contains(@class,'MuiPaper-root MuiPaper-elevation')][.//div[text()='Apple Watch Series 7']]//button[text()='View Details']";
	
	//ITEMS' BUTTON CHECK VISIBILITY & ENABLITY
	public void camera_canon_buttons_check() {
		boolean addtoCart_button_isVisible = page.locator(camera_canon_eos_r15_add_to_cart_xpath).isVisible();
		boolean addtoCart_button_isEnabled = page.locator(camera_canon_eos_r15_add_to_cart_xpath).isEnabled();
		boolean viewdetail_button_isVisible = page.locator(camera_canon_eos_r15_view_detail_xpath).isVisible();
		boolean viewdetail_button_isEnabled = page.locator(camera_canon_eos_r15_view_detail_xpath).isEnabled();
		//2 BUTTONS CHECK
		if (addtoCart_button_isVisible && addtoCart_button_isEnabled && viewdetail_button_isVisible && viewdetail_button_isEnabled) {
			System.out.println("- Camera_cannon's Add_to_cart button_isVisible: " + addtoCart_button_isVisible + "\n" + "- Add_to_cart button_isEnabled: " + addtoCart_button_isEnabled);
			System.out.println("- View_detail button_isVisible: " + viewdetail_button_isVisible + "\n" + "- View_detail button_isEnabled: " + viewdetail_button_isEnabled);
			System.out.println("Both buttons are working properly");
		} else if (addtoCart_button_isVisible && !addtoCart_button_isEnabled && viewdetail_button_isVisible && !viewdetail_button_isEnabled) {
			System.out.println("- Camera_cannon's Add_to_cart button_isVisible: " + addtoCart_button_isVisible + "\n" + "- Add_to_cart button_isEnabled: " + addtoCart_button_isEnabled);
			System.out.println("- Camera_cannon's View_detail button_isVisible: " + viewdetail_button_isVisible + "\n" + "- View_detail button_isEnabled: " + viewdetail_button_isEnabled);
			System.out.println("Camera_cannon's both buttons are visible but disabled");
		} else if (!addtoCart_button_isVisible && viewdetail_button_isVisible && viewdetail_button_isEnabled ) {
			System.out.println("- Camera_cannon's Add_to_cart button_isVisible: " + addtoCart_button_isVisible + "\n" + "- Add_to_cart button_isEnabled: " + addtoCart_button_isEnabled);
			System.out.println("- Camera_cannon's View_detail button_isVisible: " + viewdetail_button_isVisible + "\n" + "- View_detail button_isEnabled: " + viewdetail_button_isEnabled);
			System.out.println("- Camera_cannon's Add_to_cart button is not visible. But View_detail button is working properly");
		} else if (addtoCart_button_isVisible && addtoCart_button_isEnabled && !viewdetail_button_isVisible) {
			System.out.println("- Camera_cannon's Add_to_cart button_isVisible: " + addtoCart_button_isVisible + "\n" + "- Add_to_cart button_isEnabled: " + addtoCart_button_isEnabled);
			System.out.println("- Camera_cannon's View_detail button_isVisible: " + viewdetail_button_isVisible + "\n" + "- View_detail button_isEnabled: " + viewdetail_button_isEnabled);
			System.out.println("- Camera_cannon's Add_to_cart button is working properly. But View_detail button is not visible");
		} else {
			System.out.println("- Add_to_cart button_isVisible: " + addtoCart_button_isVisible + "\n" + "- Add_to_cart button_isEnabled: " + addtoCart_button_isEnabled);
			System.out.println("- View_detail button_isVisible: " + viewdetail_button_isVisible + "\n" + "- View_detail button_isEnabled: " + viewdetail_button_isEnabled);
			System.out.println("- Camera_cannon's both buttons are having issue");
		}
	}
	
	public void iphone_15_buttons_check() {
		boolean addtoCart_button_isVisible = page.locator(iphone_15_pro_max_add_to_cart_xpath).isVisible();
		boolean addtoCart_button_isEnabled = page.locator(iphone_15_pro_max_add_to_cart_xpath).isEnabled();
		boolean viewdetail_button_isVisible = page.locator(iphone_15_pro_max_view_detail_xpath).isVisible();
		boolean viewdetail_button_isEnabled = page.locator(iphone_15_pro_max_view_detail_xpath).isEnabled();
		//2 BUTTONS CHECK
		if (addtoCart_button_isVisible && addtoCart_button_isEnabled && viewdetail_button_isVisible && viewdetail_button_isEnabled) {
			System.out.println("- Iphone 15 promax's Add_to_cart button_isVisible: " + addtoCart_button_isVisible + "\n" + "- Add_to_cart button_isEnabled: " + addtoCart_button_isEnabled);
			System.out.println("- Iphone 15 promax's View_detail button_isVisible: " + viewdetail_button_isVisible + "\n" + "- View_detail button_isEnabled: " + viewdetail_button_isEnabled);
			System.out.println("Both buttons are working properly");
		} else if (addtoCart_button_isVisible && !addtoCart_button_isEnabled && viewdetail_button_isVisible && !viewdetail_button_isEnabled) {
			System.out.println("- Iphone 15 promax's Add_to_cart button_isVisible: " + addtoCart_button_isVisible + "\n" + "- Add_to_cart button_isEnabled: " + addtoCart_button_isEnabled);
			System.out.println("- Iphone 15 promax's View_detail button_isVisible: " + viewdetail_button_isVisible + "\n" + "- View_detail button_isEnabled: " + viewdetail_button_isEnabled);
			System.out.println("- Iphone 15 promax's both buttons are visible but disabled");
		} else if (!addtoCart_button_isVisible && viewdetail_button_isVisible && viewdetail_button_isEnabled ) {
			System.out.println("- Iphone 15 promax's Add_to_cart button_isVisible: " + addtoCart_button_isVisible + "\n" + "- Add_to_cart button_isEnabled: " + addtoCart_button_isEnabled);
			System.out.println("- Iphone 15 promax's View_detail button_isVisible: " + viewdetail_button_isVisible + "\n" + "- View_detail button_isEnabled: " + viewdetail_button_isEnabled);
			System.out.println("- Iphone 15 promax's Add_to_cart button is not visible. But View_detail button is working properly");
		} else if (addtoCart_button_isVisible && addtoCart_button_isEnabled && !viewdetail_button_isVisible) {
			System.out.println("- Iphone 15 promax's Add_to_cart button_isVisible: " + addtoCart_button_isVisible + "\n" + "- Add_to_cart button_isEnabled: " + addtoCart_button_isEnabled);
			System.out.println("- Iphone 15 promax's View_detail button_isVisible: " + viewdetail_button_isVisible + "\n" + "- View_detail button_isEnabled: " + viewdetail_button_isEnabled);
			System.out.println("- Iphone 15 promax's Add_to_cart button is working properly. But View_detail button is not visible");
		} else {
			System.out.println("- Iphone 15 promax's Add_to_cart button_isVisible: " + addtoCart_button_isVisible + "\n" + "- Add_to_cart button_isEnabled: " + addtoCart_button_isEnabled);
			System.out.println("- Iphone 15 promax's View_detail button_isVisible: " + viewdetail_button_isVisible + "\n" + "- View_detail button_isEnabled: " + viewdetail_button_isEnabled);
			System.out.println("- Iphone 15 promax's both buttons are having issue");
		}
	}
	public void macbook_air_buttons_check() {
		boolean addtoCart_button_isVisible = page.locator(macbook_air_m2_add_to_cart_xpath).isVisible();
		boolean addtoCart_button_isEnabled = page.locator(macbook_air_m2_add_to_cart_xpath).isEnabled();
		boolean viewdetail_button_isVisible = page.locator(macbook_air_m2_view_detail_xpath).isVisible();
		boolean viewdetail_button_isEnabled = page.locator(macbook_air_m2_view_detail_xpath).isEnabled();
		//2 BUTTONS CHECK
		if (addtoCart_button_isVisible && addtoCart_button_isEnabled && viewdetail_button_isVisible && viewdetail_button_isEnabled) {
			System.out.println("- Macbook air's Add_to_cart button_isVisible: " + addtoCart_button_isVisible + "\n" + "- Add_to_cart button_isEnabled: " + addtoCart_button_isEnabled);
			System.out.println("- Macbook air's View_detail button_isVisible: " + viewdetail_button_isVisible + "\n" + "- View_detail button_isEnabled: " + viewdetail_button_isEnabled);
			System.out.println("- Macbook air's both buttons are working properly");
		} else if (addtoCart_button_isVisible && !addtoCart_button_isEnabled && viewdetail_button_isVisible && !viewdetail_button_isEnabled) {
			System.out.println("- Macbook air's Add_to_cart button_isVisible: " + addtoCart_button_isVisible + "\n" + "- Add_to_cart button_isEnabled: " + addtoCart_button_isEnabled);
			System.out.println("- Macbook air's View_detail button_isVisible: " + viewdetail_button_isVisible + "\n" + "- View_detail button_isEnabled: " + viewdetail_button_isEnabled);
			System.out.println("- Macbook air's  both buttons are visible but disabled");
		} else if (!addtoCart_button_isVisible && viewdetail_button_isVisible && viewdetail_button_isEnabled ) {
			System.out.println("- Macbook air's Add_to_cart button_isVisible: " + addtoCart_button_isVisible + "\n" + "- Add_to_cart button_isEnabled: " + addtoCart_button_isEnabled);
			System.out.println("- Macbook air's View_detail button_isVisible: " + viewdetail_button_isVisible + "\n" + "- View_detail button_isEnabled: " + viewdetail_button_isEnabled);
			System.out.println("- Macbook air's Add_to_cart button is not visible. But View_detail button is working properly");
		} else if (addtoCart_button_isVisible && addtoCart_button_isEnabled && !viewdetail_button_isVisible) {
			System.out.println("- Macbook air's Add_to_cart button_isVisible: " + addtoCart_button_isVisible + "\n" + "- Add_to_cart button_isEnabled: " + addtoCart_button_isEnabled);
			System.out.println("- Macbook air's View_detail button_isVisible: " + viewdetail_button_isVisible + "\n" + "- View_detail button_isEnabled: " + viewdetail_button_isEnabled);
			System.out.println("- Macbook air's Add_to_cart button is working properly. But View_detail button is not visible");
		} else {
			System.out.println("- Macbook air's Add_to_cart button_isVisible: " + addtoCart_button_isVisible + "\n" + "- Add_to_cart button_isEnabled: " + addtoCart_button_isEnabled);
			System.out.println("- Macbook air's View_detail button_isVisible: " + viewdetail_button_isVisible + "\n" + "- View_detail button_isEnabled: " + viewdetail_button_isEnabled);
			System.out.println("- Macbook air's both buttons are having issue");
		}
	}
	public void sony_headphone_buttons_check() {
		boolean addtoCart_button_isVisible = page.locator(sony_wh_1000xm5_headphones_add_to_cart_xpath).isVisible();
		boolean addtoCart_button_isEnabled = page.locator(sony_wh_1000xm5_headphones_add_to_cart_xpath).isEnabled();
		boolean viewdetail_button_isVisible = page.locator(sony_wh_1000xm5_headphones_view_detail_xpath).isVisible();
		boolean viewdetail_button_isEnabled = page.locator(sony_wh_1000xm5_headphones_view_detail_xpath).isEnabled();
		if (addtoCart_button_isVisible && addtoCart_button_isEnabled && viewdetail_button_isVisible && viewdetail_button_isEnabled) {
			System.out.println("- Sony Headphone's Add_to_cart button_isVisible: " + addtoCart_button_isVisible + "\n" + "- Add_to_cart button_isEnabled: " + addtoCart_button_isEnabled);
			System.out.println("- View_detail button_isVisible: " + viewdetail_button_isVisible + "\n" + "- View_detail button_isEnabled: " + viewdetail_button_isEnabled);
			System.out.println("- Sony Headphone's both buttons are working properly");
		} else if (addtoCart_button_isVisible && !addtoCart_button_isEnabled && viewdetail_button_isVisible && !viewdetail_button_isEnabled) {
			System.out.println("- Sony Headphone's Add_to_cart button_isVisible: " + addtoCart_button_isVisible + "\n" + "- Add_to_cart button_isEnabled: " + addtoCart_button_isEnabled);
			System.out.println("- Sony Headphone's View_detail button_isVisible: " + viewdetail_button_isVisible + "\n" + "- View_detail button_isEnabled: " + viewdetail_button_isEnabled);
			System.out.println("Both buttons are visible but disabled");
		} else if (!addtoCart_button_isVisible && viewdetail_button_isVisible && viewdetail_button_isEnabled ) {
			System.out.println("- Sony Headphone's Add_to_cart button_isVisible: " + addtoCart_button_isVisible + "\n" + "- Add_to_cart button_isEnabled: " + addtoCart_button_isEnabled);
			System.out.println("- Sony Headphone's View_detail button_isVisible: " + viewdetail_button_isVisible + "\n" + "- View_detail button_isEnabled: " + viewdetail_button_isEnabled);
			System.out.println("- Sony Headphone's Add_to_cart button is not visible. But View_detail button is working properly");
		} else if (addtoCart_button_isVisible && addtoCart_button_isEnabled && !viewdetail_button_isVisible) {
			System.out.println("- Sony Headphone's Add_to_cart button_isVisible: " + addtoCart_button_isVisible + "\n" + "- Add_to_cart button_isEnabled: " + addtoCart_button_isEnabled);
			System.out.println("- Sony Headphone's View_detail button_isVisible: " + viewdetail_button_isVisible + "\n" + "- View_detail button_isEnabled: " + viewdetail_button_isEnabled);
			System.out.println("- Sony Headphone's Add_to_cart button is working properly. But View_detail button is not visible");
		} else {
			System.out.println("- Sony Headphone's Add_to_cart button_isVisible: " + addtoCart_button_isVisible + "\n" + "- Add_to_cart button_isEnabled: " + addtoCart_button_isEnabled);
			System.out.println("- Sony Headphone's View_detail button_isVisible: " + viewdetail_button_isVisible + "\n" + "- View_detail button_isEnabled: " + viewdetail_button_isEnabled);
			System.out.println("- Sony Headphone's both buttons are having issue");
		}
	}
	public void samsung_tv_buttons_check() {
		boolean addtoCart_button_isVisible = page.locator(samsung_65_qled_tv_add_to_cart_xpath).isVisible();
		boolean addtoCart_button_isEnabled = page.locator(samsung_65_qled_tv_add_to_cart_xpath).isEnabled();
		boolean viewdetail_button_isVisible = page.locator(samsung_65_qled_tv_view_detail_xpath).isVisible();
		boolean viewdetail_button_isEnabled = page.locator(samsung_65_qled_tv_view_detail_xpath).isEnabled();
		if (addtoCart_button_isVisible && addtoCart_button_isEnabled && viewdetail_button_isVisible && viewdetail_button_isEnabled) {
			System.out.println("- Sam Sung tv's Add_to_cart button_isVisible: " + addtoCart_button_isVisible + "\n" + "- Add_to_cart button_isEnabled: " + addtoCart_button_isEnabled);
			System.out.println("- Sam Sung tv's View_detail button_isVisible: " + viewdetail_button_isVisible + "\n" + "- View_detail button_isEnabled: " + viewdetail_button_isEnabled);
			System.out.println("Both buttons are working properly");
		} else if (addtoCart_button_isVisible && !addtoCart_button_isEnabled && viewdetail_button_isVisible && !viewdetail_button_isEnabled) {
			System.out.println("- Sam Sung tv's Add_to_cart button_isVisible: " + addtoCart_button_isVisible + "\n" + "- Add_to_cart button_isEnabled: " + addtoCart_button_isEnabled);
			System.out.println("- Sam Sung tv's View_detail button_isVisible: " + viewdetail_button_isVisible + "\n" + "- View_detail button_isEnabled: " + viewdetail_button_isEnabled);
			System.out.println("- Sam Sung tv's both buttons are visible but disabled");
		} else if (!addtoCart_button_isVisible && viewdetail_button_isVisible && viewdetail_button_isEnabled ) {
			System.out.println("- Sam Sung tv's Add_to_cart button_isVisible: " + addtoCart_button_isVisible + "\n" + "- Add_to_cart button_isEnabled: " + addtoCart_button_isEnabled);
			System.out.println("- Sam Sung tv's View_detail button_isVisible: " + viewdetail_button_isVisible + "\n" + "- View_detail button_isEnabled: " + viewdetail_button_isEnabled);
			System.out.println("- Sam Sung tv's Add_to_cart button is not visible. But View_detail button is working properly");
		} else if (addtoCart_button_isVisible && addtoCart_button_isEnabled && !viewdetail_button_isVisible) {
			System.out.println("- Sam Sung tv's Add_to_cart button_isVisible: " + addtoCart_button_isVisible + "\n" + "- Add_to_cart button_isEnabled: " + addtoCart_button_isEnabled);
			System.out.println("- Sam Sung tv's View_detail button_isVisible: " + viewdetail_button_isVisible + "\n" + "- View_detail button_isEnabled: " + viewdetail_button_isEnabled);
			System.out.println("- Sam Sung tv's Add_to_cart button is working properly. But View_detail button is not visible");
		} else {
			System.out.println("- Sam Sung tv's Add_to_cart button_isVisible: " + addtoCart_button_isVisible + "\n" + "- Add_to_cart button_isEnabled: " + addtoCart_button_isEnabled);
			System.out.println("- Sam Sung tv's View_detail button_isVisible: " + viewdetail_button_isVisible + "\n" + "- View_detail button_isEnabled: " + viewdetail_button_isEnabled);
			System.out.println("- Sam Sung tv's both buttons are having issue");
		}
	}
	public void apple_watch_buttons_check() {
		boolean addtoCart_button_isVisible = page.locator(apple_watch_series_7_add_to_cart_xpath).isVisible();
		boolean addtoCart_button_isEnabled = page.locator(apple_watch_series_7_add_to_cart_xpath).isEnabled();
		boolean viewdetail_button_isVisible = page.locator(apple_watch_series_7_view_detail_xpath).isVisible();
		boolean viewdetail_button_isEnabled = page.locator(apple_watch_series_7_view_detail_xpath).isEnabled();
		if (addtoCart_button_isVisible && addtoCart_button_isEnabled && viewdetail_button_isVisible && viewdetail_button_isEnabled) {
			System.out.println("- Apple watch's Add_to_cart button_isVisible: " + addtoCart_button_isVisible + "\n" + "- Add_to_cart button_isEnabled: " + addtoCart_button_isEnabled);
			System.out.println("- Apple watch's View_detail button_isVisible: " + viewdetail_button_isVisible + "\n" + "- View_detail button_isEnabled: " + viewdetail_button_isEnabled);
			System.out.println("- Apple watch's  both buttons are working properly");
		} else if (addtoCart_button_isVisible && !addtoCart_button_isEnabled && viewdetail_button_isVisible && !viewdetail_button_isEnabled) {
			System.out.println("- Apple watch's Add_to_cart button_isVisible: " + addtoCart_button_isVisible + "\n" + "- Add_to_cart button_isEnabled: " + addtoCart_button_isEnabled);
			System.out.println("- Apple watch's View_detail button_isVisible: " + viewdetail_button_isVisible + "\n" + "- View_detail button_isEnabled: " + viewdetail_button_isEnabled);
			System.out.println("- Apple watch's both buttons are visible but disabled");
		} else if (!addtoCart_button_isVisible && viewdetail_button_isVisible && viewdetail_button_isEnabled ) {
			System.out.println("- Apple watch's Add_to_cart button_isVisible: " + addtoCart_button_isVisible + "\n" + "- Add_to_cart button_isEnabled: " + addtoCart_button_isEnabled);
			System.out.println("- Apple watch's View_detail button_isVisible: " + viewdetail_button_isVisible + "\n" + "- View_detail button_isEnabled: " + viewdetail_button_isEnabled);
			System.out.println("- Apple watch's Add_to_cart button is not visible. But View_detail button is working properly");
		} else if (addtoCart_button_isVisible && addtoCart_button_isEnabled && !viewdetail_button_isVisible) {
			System.out.println("- Apple watch's Add_to_cart button_isVisible: " + addtoCart_button_isVisible + "\n" + "- Add_to_cart button_isEnabled: " + addtoCart_button_isEnabled);
			System.out.println("- Apple watch's View_detail button_isVisible: " + viewdetail_button_isVisible + "\n" + "- View_detail button_isEnabled: " + viewdetail_button_isEnabled);
			System.out.println("- Apple watch's Add_to_cart button is working properly. But View_detail button is not visible");
		} else {
			System.out.println("- Apple watch's Add_to_cart button_isVisible: " + addtoCart_button_isVisible + "\n" + "- Add_to_cart button_isEnabled: " + addtoCart_button_isEnabled);
			System.out.println("- Apple watch's View_detail button_isVisible: " + viewdetail_button_isVisible + "\n" + "- View_detail button_isEnabled: " + viewdetail_button_isEnabled);
			System.out.println("- Apple watch's both buttons are having issue");
		}
	}
}
