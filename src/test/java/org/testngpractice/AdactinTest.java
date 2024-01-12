package org.testngpractice;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.adactinpages.LoginPage;
import org.adactinpages.PageManager;
import org.adactinpages.SearchHotelPage;
import org.adactinpages.SelectHotelPage;
import static org.base.BaseClass.*;
import org.junit.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AdactinTest {
	String path = "C:\\Users\\Lenovo\\eclipse-workspace\\DecAdvFramework"
			+ "\\src\\test\\resources\\Excel Files\\Data.xlsx";
	PageManager pageManager;
	LoginPage loginPage;
	SearchHotelPage searchHotelPage;
	SelectHotelPage selectHotelPage;
	SoftAssert softAssert;
	@BeforeClass
	private void bef() {
		browserLaunch("edge");
		setImplicitWaits(10);
		maximizeWindow();
		softAssert = new SoftAssert();
		pageManager = new PageManager();
		loadUrl("https://adactinhotelapp.com/");
		loginPage = pageManager.getLoginPage();
	}
	
	@BeforeMethod
	private void befMethod() {
		System.out.println("BeforeMethod");
	}
	
	@AfterMethod
	private void aftMethod() throws IOException {
		File file = new File("C:\\Users\\Lenovo\\eclipse-workspace"
				+ "\\DecAdvFramework\\target\\screenshot.png");
		screenshot(file);
	}
	
	@Test(priority = 1)
	private void loginPage() throws IOException {
		passValues(loginPage.getUserName(),excelRead(path, "Adactin Login Data", 1, 0));
		passValues(loginPage.getPassword(),excelRead(path, "Adactin Login Data", 1, 1));
		//Hard Assert
		//Assert.assertTrue(false);
		//Soft Assert
		
		softAssert.assertTrue(false);
		elementClick(loginPage.getLogin());
		searchHotelPage = pageManager.getSearchHotelPage();
		String actual = getAttributeValue(searchHotelPage.getUser(), "value");
		String expected = "Hello sathishgreens234!";
		//Assert.assertEquals(expected, actual);
		softAssert.assertEquals(expected, actual);
		System.out.println("Login Page Test Passed");
	}
	@Test(priority = 2)
	private void searchHotel() throws IOException {
		dropDown(searchHotelPage.getLocation(), "value", excelRead(path, "Search Hotel Data", 1, 0));
		dropDown(searchHotelPage.getHotel(), "text", excelRead(path, "Search Hotel Data", 1, 1));
		dropDown(searchHotelPage.getRoomType(), "value", excelRead(path, "Search Hotel Data", 1, 2));
		dropDown(searchHotelPage.getNoOfRooms(), "index", excelRead(path, "Search Hotel Data", 1, 3));
		elementClick(searchHotelPage.getSearch());
		
		selectHotelPage = pageManager.getSelectHotelPage();
		softAssert.assertTrue(false);
	}
	
	@AfterClass
	private void aftClass() {
		quitBrowser();
		softAssert.assertAll();		
	}
	

}
