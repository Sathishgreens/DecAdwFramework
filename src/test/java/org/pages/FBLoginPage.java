package org.pages;

import java.sql.DriverManager;

import org.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;

public class FBLoginPage extends BaseClass{
	public FBLoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id="email")
	private WebElement userName;

	
	@FindBy(id="pass")
	private WebElement password;

	@FindBy(name="login")
	private WebElement loginButton;

	public WebElement getUserName() {
		return userName;
		
	}

	public WebElement getPassword() {
		return password;
		
	}

	public WebElement getLoginButton() {
		return loginButton;
	}
	
	@DataProvider(name="loginData")
	public Object[][] dataProvid() {		
		Object[][] data = new Object[][] {
			{"Sathish","Sat@123"}};
		return data;
	}
}
