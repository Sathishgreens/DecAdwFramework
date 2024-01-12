package org.mavendemo;

import java.io.IOException;

import org.base.BaseClass;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.pages.FBLoginPage;

public class FBLogin extends BaseClass {
	@Test
	public void fbLog() throws IOException, InterruptedException {
		String path = "C:\\Users\\Lenovo\\eclipse-workspace\\DecAdvFramework"
				+ "\\src\\test\\resources\\Excel Files\\Data.xlsx";
		browserLaunch("chrome");
		maximizeWindow();
		loadUrl("https://www.facebook.com/");
		FBLoginPage loginPage = new FBLoginPage();
		WebElement userName = loginPage.getUserName();
		WebElement password = loginPage.getPassword();
		WebElement loginButton = loginPage.getLoginButton();

		// 1 time
		passValues(userName, excelRead(path, "Login Data", 1, 0));
		passValues(password, excelRead(path, "Login Data", 1, 1));
		elementClick(loginButton);
		Thread.sleep(3000);
		navigateBack();
		refreshPage();

		// 2nd time
		passValues(userName, excelRead(path, "Login Data", 2, 0));
		passValues(password, excelRead(path, "Login Data", 2, 1));
		elementClick(loginButton);
		navigateBack();
		refreshPage();

		// 2nd time
		passValues(userName, excelRead(path, "Login Data", 3, 0));
		passValues(password, excelRead(path, "Login Data", 3, 1));
		elementClick(loginButton);
		navigateBack();
		refreshPage();

	}

}
