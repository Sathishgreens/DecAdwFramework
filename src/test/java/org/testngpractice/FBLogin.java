package org.testngpractice;

import org.base.BaseClass;
import org.pages.FBLoginPage;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class FBLogin extends BaseClass {
	
	@Test(dataProvider = "loginData", dataProviderClass = FBLoginPage.class)
	public void fbLaunch(Object userName , Object password) {	
		
		browserLaunch("chrome");
		maximizeWindow();
		Reporter.log("=======Facebook Launch=========");
		loadUrl("https://www.facebook.com/");
		FBLoginPage loginPage = new FBLoginPage();
		passValues(loginPage.getUserName(), (String)userName);
		passValues(loginPage.getPassword(), password.toString());
	}
	
	
	@Test
	public void amazonLaunch() {
		browserLaunch("edge");
		maximizeWindow();
		Reporter.log("=======Facebook Launch=========");
		loadUrl("https://www.facebook.com/");
		FBLoginPage loginPage = new FBLoginPage();
		passValues(loginPage.getUserName(), "dsdf");
		passValues(loginPage.getPassword(), "aaa");
	}
	
	
	@Test
	public void flipkartLaunch() {
		browserLaunch("firefox");
		maximizeWindow();
		Reporter.log("=======Facebook Launch=========");
		loadUrl("https://www.facebook.com/");
		FBLoginPage loginPage = new FBLoginPage();
		passValues(loginPage.getUserName(), "Saba");
		passValues(loginPage.getPassword(), "66666");
	}
}