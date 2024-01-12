package org.mavendemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Emp {

	
	public double avg(int a, int b) {
		double average = (a + b) / 2;
		return average;
	}

	public static void main(String[] args) {

		
		Emp emp = new Emp();
		double res = emp.avg(10, 20);
		
	}
}
