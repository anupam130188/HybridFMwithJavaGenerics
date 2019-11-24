package com.orangehrm.Tests;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.orangehrm.pages.BasePage;
import com.orangehrm.pages.Page;
import com.orangehrm.utils.ExcelReader;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 */

/**
 * @author anchandan
 *
 */
public class BaseTest {
	WebDriver driver;
	Page page;
	ExcelReader excelReader;
	// String filePath =
	// System.getProperty("user.dir")+"\\resources\\TestData.xlsx";
	static Logger logger = Logger.getLogger(BaseTest.class);

	public BaseTest() {
		String log4jConfigFile = System.getProperty("user.dir") + "\\resources\\log4j.properties";
		PropertyConfigurator.configure(log4jConfigFile);
		excelReader = new ExcelReader(excelReader.filePath);
	}

	@BeforeMethod
	@Parameters(value = { "browser" })
	public void setUpTest(String browser) {
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			logger.info("Chrome driver initialized");
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();

			logger.info("Firefox driver initialized");
			driver = new FirefoxDriver();
		} else {
			logger.info("No Browser initialized");
		}
		logger.info("Opening Orange HRM url");
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		//driver.get("https://www.microsoft.com/en-in/");
		logger.info("Maximizing window");
		//driver.manage().window().fullscreen();
		driver.manage().window().maximize();
		// this line of code is going to call constructor of Page class
		page = new BasePage(driver);
		
	}

	@AfterMethod
	public void tearDown() {
		logger.info("Driver close");
		driver.quit();
		logger.info("Test script complete");
	}
}
