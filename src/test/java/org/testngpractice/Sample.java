package org.testngpractice;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Sample extends BaseClass {

	@Test(groups = "Sanity")
	public void tc1() throws IOException {
		browserLaunch("chrome");
		maximizeWindow();
		loadUrl("https://www.facebook.com/");

		List<WebElement> allLinks = driver.findElements(By.tagName("a"));

		System.out.println("Total Link : " + allLinks.size());
		int brokenLinks = 0;
		for (WebElement linkElement : allLinks) {
			String link = linkElement.getAttribute("href");
			try {
				URL url = new URL(link);
				URLConnection openConnection = url.openConnection();
				HttpURLConnection connection = (HttpURLConnection) openConnection;
				int responseCode = connection.getResponseCode();
				if (responseCode != 200) {
					brokenLinks++;
				}
			} catch (Exception e) {

			}
		}

		System.out.println("Broken Links : " + brokenLinks);
	}
}
