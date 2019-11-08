package com.orangehrm.Tests;


import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.orangehrm.pages.HomePage;
import com.orangehrm.pages.LoginPage;

/**
 * @author anchandan
 *
 */
public class LoginTest extends BaseTest{
	static Logger logger = Logger.getLogger(LoginTest.class);
	//@Test(priority=1,retryAnalyzer = com.orangehrm.utils.RetryAnalyzer.class)
	@Test(priority=1)
	public void verifyLoginPageTitleTest()
	{
		//Generics will create object of LoginPage class
	String title =	page.getInstance(LoginPage.class).loginPageTitle();
	logger.info("Title is: "+title);
	Assert.assertEquals(title, "OrangeHRM");
	}
	
	@Test(priority=2)
	public void verifyLoginPageHeaderTest()
	{
		//Generics will create object of LoginPage class
	String header =	page.getInstance(LoginPage.class).loginPageHeader();
	logger.info("Header is: "+header);
	Assert.assertEquals(header, "OrangeHRM, Inc");
	}
	
	@Test(priority=3)
	public void verifyLoginTest()
	{
		System.out.println("reached Here");
		System.out.println("Username is: "+excelReader.getExcelData(0, 1, 0));
		//Generics will create object of LoginPage class
	HomePage homePage = page.getInstance(LoginPage.class).loginSuccess(excelReader.getExcelData(0, 1, 0), excelReader.getExcelData(0, 1, 1));
	String homePageHeader = homePage.homePageHeader();
	logger.info("HomePage header is: "+homePageHeader);
	Assert.assertEquals(homePageHeader, "Welcome Admin");
	}

}
