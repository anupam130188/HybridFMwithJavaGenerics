package com.orangehrm.Tests;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.orangehrm.pages.CreateUserPage;
import com.orangehrm.pages.HomePage;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.utils.ExcelData;
import com.orangehrm.utils.ExcelReader;

/**
 * @author anchandan
 *
 */
public class OTPTesting extends BaseTest {
	static Logger logger = Logger.getLogger(OTPTesting.class);
	// @Test(priority=1,retryAnalyzer = com.orangehrm.utils.RetryAnalyzer.class)

	@Test(priority = 1)
	public void verifyCreateUserTest() {
		// Generics will create object of LoginPage class
		try {
			page.getInstance(CreateUserPage.class).loginWithoutUserInfo();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info("Registration page reached ");
	}
}
