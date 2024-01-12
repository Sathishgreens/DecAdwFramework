package org.adactinpages;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectHotelPage extends BaseClass {
	
	public SelectHotelPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//td[text()='Select Hotel ']")
	private WebElement selectHotelElement;

	public WebElement getSelectHotelElement() {
		return selectHotelElement;
	}

	
	

}
