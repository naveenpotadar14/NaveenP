package com.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.utils.TestUtils;

public class TestBase {

	public static WebDriver driver;
	public static Properties ppt;
	
	public TestBase() {
		try {
			ppt = new Properties();
			FileInputStream input = new FileInputStream(new File("D:\\QSPIDERS\\QCSE3\\workspace\\Zesrmoney_assignment2\\src\\test\\java\\com\\qa\\config\\config.properties"));
			ppt.load(input);
		}
		catch(Throwable e) {
			e.printStackTrace();
		}
	}
	
	//Initialization
	public void initialize() {
		launchBrowser(ppt.getProperty("browser"));
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(ppt.getProperty("url"));
	}
	
	public void launchBrowser(String browser) {
		if(browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
			TestUtils.disableNotifications(ppt.getProperty("browser"));
			driver = new ChromeDriver(TestUtils.option);
		}else if(browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
			driver = new FirefoxDriver();
		}
	}
}
