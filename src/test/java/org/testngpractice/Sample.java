package org.testngpractice;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Sample extends BaseClass {

	@Test(groups = "Sanity")
	public void tc1() {
		System.out.println("@Test");
	}
	
	@BeforeClass
	public void befClass() {
		System.out.println("@BeforeClass");
	}
	
	@AfterClass
	public void aftClass() {
		System.out.println("@AfterClass");
	}
	
	
	
}
