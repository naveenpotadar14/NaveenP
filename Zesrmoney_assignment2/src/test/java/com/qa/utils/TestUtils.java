package com.qa.utils;

import org.openqa.selenium.chrome.ChromeOptions;

public class TestUtils {

	public static ChromeOptions option;

	public static void disableNotifications(String browser) {
		
		if(browser.equalsIgnoreCase("chrome")) {
			option = new ChromeOptions();
			option.addArguments("--disable-notifications");
		}
	}
}
