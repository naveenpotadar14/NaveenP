package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class LoginPage extends TestBase {

	@FindBy(id="email")
	WebElement username;
	@FindBy(name="pass")
	WebElement password;
	@FindBy(name="login")
	WebElement loginbutton;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	public String verifyLoginPage() {
		return driver.getTitle();
	}
	
	public HomePage Login(String un, String pw) {
		username.sendKeys(un);
		password.sendKeys(pw);
		loginbutton.click();
		return new HomePage();
	}
}
