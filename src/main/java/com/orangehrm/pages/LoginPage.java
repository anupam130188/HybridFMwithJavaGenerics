/**
 * 
 */
package com.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author anchandan
 *
 */
/**
 * @author anchandan
 *
 */
public class LoginPage extends BasePage{

	//Page Locators
	private By emailId = By.id("txtUsername");
	private By password = By.id("txtPassword");
	private By loginBtn = By.id("btnLogin");
	private By header = By.xpath("//div//*[contains(@href,'orangehrm.com')]");
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	//Getters for encapsulation
	
	/**
	 * @return the emailId
	 */
	public WebElement getEmailId() {
		return getElement(emailId);
	}
	/**
	 * @return the password
	 */
	public WebElement getPassword() {
		return getElement(password);
	}
	/**
	 * @return the loginBtn
	 */
	public WebElement getLoginBtn() {
		return getElement(loginBtn);
	}
	/**
	 * @return the header
	 */
	public WebElement getHeader() {
		return getElement(header);
	}
	
	public String loginPageTitle() {
		return getPageTitle();
	}
	
	public String loginPageHeader() {
		return getPageHeader(header);
	}
	
	
	/**
	 * @param uname
	 * @param pwd
	 * @return
	 */
	public HomePage loginSuccess(String uname,String pwd) {
		getEmailId().sendKeys(uname);
		getPassword().sendKeys(pwd);
		getLoginBtn().click();
		
		return getInstance(HomePage.class);
	}

	public void loginWithoutUserInfo() {
		getEmailId().sendKeys("");
		getPassword().sendKeys("");
		getLoginBtn().click();
	}
}
