package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath="//div[@class='m9osqain a5q79mjw jm1wdb64 k4urcfbm']")
	WebElement writepost;
	@FindBy(xpath="(//div[@class='_1mf _1mj'])[2]")
	WebElement writepostTB;
	@FindBy(xpath="//span[text()='Post']")
	WebElement postBTN;
	@FindBy(xpath="(//span[@class='a8c37x1j ni8dbmo4 stjgntxs l9j0dhe7 ltmttdrg g0qnabr5'])[1]")
	WebElement user;
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	public String verifyUser() {
		return user.getText();
	}
	public void writePost(String posttext) {
		writepost.click();
		writepostTB.sendKeys(posttext);
		postBTN.click();
	}
	
}
