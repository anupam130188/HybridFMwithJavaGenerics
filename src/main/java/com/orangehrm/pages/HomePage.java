package com.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

	private By homePageHeader = By.id("welcome");

	private By adminOption = By.id("menu_admin_viewAdminModule");

	private By userName = By.xpath("//*[@id='searchSystemUser_userName']");
	private By searchBtn = By.id("searchBtn");
	private By userValue = By.xpath("//table[@id='resultTable']//td");

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
		WebElement e = null;
		try {
		e=	getElement(searchBtn);
		} catch (Exception e1) {
			e = getElement(searchBtn);
		}
		return e;
		
	}

	/**
	 * @return the userValue
	 */
	public WebElement getUserValue() {
		WebElement e = null;
		try {
			e = getElement(userValue);
		} catch (Exception e1) {

			System.out.println("No record found");
			e1.printStackTrace();
		} 
		return e;
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
		System.out.println("userName found is: " + userName);
		return getInstance(ContactsPage.class);

	}

}
