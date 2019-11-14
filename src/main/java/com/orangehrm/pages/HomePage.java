package com.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

	private By homePageHeader = By.id("welcome");

	private By adminOption = By.id("menu_admin_viewAdminModule");

	private By userName = By.id("searchSystemUser_userName");
	private By searchBtn = By.id("searchBtn");
	private By userValue = By.xpath("//table[@id='resultTable']//td//a");

	public HomePage(WebDriver driver) {
		super(driver);
	}

	/**
	 * @return the adminOption
	 */
	public WebElement getAdminOption() {
		return getElement(adminOption);
	}

	/**
	 * @return the userName
	 */
	public WebElement getUserName() {
		return getElement(userName);
	}

	/**
	 * @return the searchBtn
	 */
	public WebElement getSearchBtn() {
		return getElement(searchBtn);
	}

	/**
	 * @return the userValue
	 */
	public WebElement getUserValue() {
		return getElement(userValue);
	}

	/**
	 * @return the homePageHeader
	 */
	public WebElement getHomePageHeader() {
		return getElement(homePageHeader);
	}

	// HomePage methods

	public String getHomePageTitle() {
		return getPageTitle();
	}

	public String homePageHeader() {
		return getPageHeader(homePageHeader);
	}

	public ContactsPage userManagementSearch(String user) {
		getAdminOption().click();
		getUserName().sendKeys("hannah.flores");
		getSearchBtn().click();
		String userName = getUserValue().getText();
		System.out.println("userName " + userName);
		return getInstance(ContactsPage.class);

	}

}
