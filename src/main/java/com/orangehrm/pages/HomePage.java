package com.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage{

	private By homePageHeader = By.id("welcome");
	public HomePage(WebDriver driver) {
		super(driver);
	}
	/**
	 * @return the homePageHeader
	 */
	public WebElement getHomePageHeader() {
		return getElement(homePageHeader);
	}

	//HomePage methods
	
	public String getHomePageTitle()
	{
		return getPageTitle();
	}
	
	public String homePageHeader()
	{
		return getPageHeader(homePageHeader);
	}
	
}
