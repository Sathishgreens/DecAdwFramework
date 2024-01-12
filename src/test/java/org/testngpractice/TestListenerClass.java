package org.testngpractice;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListenerClass implements ITestListener{
	
	@Override
	public void onStart(ITestContext context) {
		System.out.println("Test Started");
	}
	
	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		//Screenshot
	}

}
