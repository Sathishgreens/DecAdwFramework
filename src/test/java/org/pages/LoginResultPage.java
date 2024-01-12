package org.pages;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginResultPage extends BaseClass{
	
	public LoginResultPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//h2[@class='uiHeaderTitle']")
	private WebElement resultText;
	
	public WebElement getResultText() {
		return resultText ;
	}

}
