package org.mavendemo;

import java.io.IOException;

import org.adactinpages.LoginPage;
import org.adactinpages.PageManager;
import org.adactinpages.SearchHotelPage;
import org.adactinpages.SelectHotelPage;
import org.base.BaseClass;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;



public class TestCases extends BaseClass{
	static PageManager pageManager;
	static LoginPage loginPage;
	static SearchHotelPage searchHotelPage;
	static SelectHotelPage selectHotelPage;
	static String path = "C:\\Users\\Lenovo\\eclipse-workspace\\DecAdvFramework"
			+ "\\src\\test\\resources\\Excel Files\\Data.xlsx";
	@BeforeClass
	public static void befCass() {
		browserLaunch("chrome");
		maximizeWindow();
		setImplicitWaits(10);  
		loadUrl("https://adactinhotelapp.com/");
		pageManager = new PageManager();
		//loginPage = new LoginPage();
		loginPage = pageManager.getLoginPage();
	}
	
	@Test
	public void tc1() throws IOException {
		passValues(loginPage.getUserName(), excelRead(path, "Adactin Login Data", 1, 0));
		passValues(loginPage.getPassword(), excelRead(path, "Adactin Login Data", 1, 1));
		elementClick(loginPage.getLogin());	
		String expected = "Hello sathishgreens123!";
		//searchHotelPage = new SearchHotelPage();
		searchHotelPage = pageManager.getSearchHotelPage();
		String actual = getAttributeValue(searchHotelPage.getUser(), "value");
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void tc2() throws IOException {
		dropDown(searchHotelPage.getLocation(), "value", excelRead(path, "Search Hotel Data", 1, 0));
		dropDown(searchHotelPage.getHotel(), "text", excelRead(path, "Search Hotel Data", 1, 1));
		dropDown(searchHotelPage.getRoomType(), "value", excelRead(path, "Search Hotel Data", 1, 2));
		dropDown(searchHotelPage.getNoOfRooms(), "index", excelRead(path, "Search Hotel Data", 1, 3));
		elementClick(searchHotelPage.getSearch());
		//selectHotelPage = new SelectHotelPage();
		selectHotelPage = pageManager.getSelectHotelPage();
		Assert.assertTrue(selectHotelPage.getSelectHotelElement().isDisplayed());
	}
	
	@AfterClass
	public static void aftClass() {
		quitBrowser();
	}
	
	
}






