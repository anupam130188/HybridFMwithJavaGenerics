package com.orangehrm.Tests;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.orangehrm.pages.ContactsPage;
import com.orangehrm.pages.HomePage;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.utils.ExcelReader;

/**
 * @author anchandan
 *
 */
public class HomePageTest extends BaseTest{
	static Logger logger = Logger.getLogger(HomePageTest.class);
	// @Test(priority=1,retryAnalyzer = com.orangehrm.utils.RetryAnalyzer.class)

	@DataProvider
	public Iterator<Object[]> getTestData() {
		ArrayList<Object[]> testData = excelReader.readExcelTestData();
		return testData.iterator();
	}

	@Test(dataProvider = "getTestData", priority = 4,alwaysRun = true)
	public void verifyUserNameTest(String userName, String passWord) {
		//HomePage homePage = page.getInstance(LoginPage.class).loginSuccess(userName, passWord);
	/*	System.out.println("ExcelReader.getExcelData(0, 1, 0) "+ExcelReader.getExcelData(0, 1, 0));
		System.out.println("ExcelReader.getExcelData(0, 1, 0) "+ExcelReader.getExcelData(0, 1, 1));*/
		HomePage homePage = page.getInstance(LoginPage.class).loginSuccess(ExcelReader.getExcelData(0, 1, 0),
				ExcelReader.getExcelData(0, 1, 1));
		String homePageHeader = homePage.homePageHeader();
		logger.info("HomePage header is: " + homePageHeader);
		Assert.assertEquals(homePageHeader, "Welcome Admin");
		ContactsPage contactsPage = page.getInstance(HomePage.class).userManagementSearch("hannah.flores");
		
	}


}
