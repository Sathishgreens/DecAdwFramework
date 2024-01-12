package org.testngpractice;

import org.base.BaseClass;
import org.testng.annotations.Test;

public class AmazonTest extends BaseClass{
	
	@Test
	public void fbLaunch() {
		
		browserLaunch("firefox");
		maximizeWindow();
		loadUrl("https://www.amazon.in/");
	}

}
