package org.mavendemo;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.base.BaseClass;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.pages.FBLoginPage;
import org.pages.LoginResultPage;



public class Sample extends BaseClass{
	
	//Second Commit
	
	//Third Commit
	
	//Fourth Commit
	
	static FBLoginPage loginPage;
	static WebElement userName;
	static WebElement password;
	static WebElement loginButton;
	String path = "C:\\Users\\Lenovo\\eclipse-workspace\\DecAdvFramework"
			+ "\\src\\test\\resources\\Excel Files\\Data.xlsx";
	//Order Of Execution
	@BeforeClass
	public static void initSetUp() {
		browserLaunch("chrome");
		maximizeWindow();
		loadUrl("https://www.facebook.com/");
		loginPage = new FBLoginPage();
		userName = loginPage.getUserName();
		password = loginPage.getPassword();
		loginButton = loginPage.getLoginButton();
	}	
	@AfterClass
	public static void exitConfig() {
		quitBrowser();
	}	
	@Before
	public void bef() {
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		System.out.println(dateFormat.format(date));
	}	
	@After
	public void aft() throws InterruptedException {
		Thread.sleep(3000);
		navigateBack();
		refreshPage();
	}	
	@Test
	public void tc3() throws Exception {	
		// 1 time
		String expected = "Please identify this account ";
		passValues(userName, excelRead(path, "Login Data", 1, 0));
		passValues(password, excelRead(path, "Login Data", 1, 1));
		elementClick(loginButton);
		LoginResultPage loginResultPage = new LoginResultPage();
		String actual = gettingElementText(loginResultPage.getResultText());
		boolean displayed = loginResultPage.getResultText().isDisplayed();
		Assert.assertTrue(displayed);
		
	}		
	
	@Test
	public void tc1() throws IOException {
		passValues(userName, excelRead(path, "Login Data", 2, 0));
		passValues(password, excelRead(path, "Login Data", 2, 1));
		elementClick(loginButton);
		LoginResultPage loginResultPage = new LoginResultPage();
		boolean displayed = loginResultPage.getResultText().isDisplayed();
		Assert.assertTrue(displayed);
		
	}
	@Ignore
	@Test
	public void tc5() throws IOException {
		passValues(userName, excelRead(path, "Login Data", 3, 0));
		passValues(password, excelRead(path, "Login Data", 3, 1));
		elementClick(loginButton);
	}
	
	@Ignore
	@Test
	public void tc2() {
		System.out.println("TC2");
	}
	@Ignore
	@Test
	public void tc4() {
		System.out.println("TC4");
	}
	
}
