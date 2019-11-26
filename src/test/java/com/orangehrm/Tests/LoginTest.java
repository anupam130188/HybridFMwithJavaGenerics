package com.orangehrm.Tests;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.orangehrm.pages.HomePage;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.utils.ExcelData;
import com.orangehrm.utils.ExcelReader;

/**
 * @author anchandan
 *
 */
public class LoginTest extends BaseTest {
	static Logger logger = Logger.getLogger(LoginTest.class);
	// @Test(priority=1,retryAnalyzer = com.orangehrm.utils.RetryAnalyzer.class)

	@DataProvider
	public Iterator<Object[]> getTestData() {
		ArrayList<Object[]> testData = excelReader.readExcelTestData();
		return testData.iterator();
	}

	@Test(priority = 1)
	public void verifyLoginPageTitleTest() {
		// Generics will create object of LoginPage class
		String title = page.getInstance(LoginPage.class).loginPageTitle();
		logger.info("Title is: " + title);
		Assert.assertEquals(title, "OrangeHRM");
	}

	@Test(priority = 2)
	public void verifyLoginPageHeaderTest() {
		// Generics will create object of LoginPage class
		String header = page.getInstance(LoginPage.class).loginPageHeader();
		logger.info("Header is: " + header);
		Assert.assertEquals(header, "OrangeHRM, Inc");
	}

	@Test(priority = 3)
	public void verifyLoginTest() {
		// Generics will create object of LoginPage class
		HomePage homePage = page.getInstance(LoginPage.class).loginSuccess(ExcelReader.getExcelData(0, 1, 0),
				ExcelReader.getExcelData(0, 1, 1));
		String homePageHeader = homePage.homePageHeader();
		logger.info("HomePage header is: " + homePageHeader);
		Assert.assertEquals(homePageHeader, "Welcome Admin");
	}

//	@Test(dataProvider = "getTestData", priority = 4)
	public void verifyLoginDataTest(String userName, String passWord) {
		System.out.println("userName " + userName);
		System.out.println("passWord " + passWord);
		HomePage homePage = page.getInstance(LoginPage.class).loginSuccess(userName, passWord);
		String homePageHeader = homePage.homePageHeader();
		logger.info("HomePage header is: " + homePageHeader);
		Assert.assertEquals(homePageHeader, "Welcome Admin");
	}

}
