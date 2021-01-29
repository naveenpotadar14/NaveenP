package com.qa.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;


public class WritePostTest extends TestBase{
	
	LoginPage loginpage;
	HomePage homepage;
	
	@BeforeMethod
	public void setup() {
		initialize();
		loginpage = new LoginPage();
		homepage = new HomePage();
	}
	
	@Test
	public void writePost() {
		String acttitle = loginpage.verifyLoginPage();
		String exptitle = ppt.getProperty("Loginpage");
		if(exptitle.equals(acttitle)) {
			homepage = loginpage.Login(ppt.getProperty("username"), ppt.getProperty("password"));
			homepage.writePost(ppt.getProperty("posttext"));
		}
		
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
	

}
