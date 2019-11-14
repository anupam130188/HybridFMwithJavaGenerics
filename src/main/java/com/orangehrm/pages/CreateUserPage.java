package com.orangehrm.pages;

import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import com.twilio.Twilio;
import com.twilio.base.ResourceSet;
import com.twilio.rest.api.v2010.account.Message;

public class CreateUserPage extends BasePage {

	// Implement email reading and OTP using Twilio

	public static final String ACCOUNT_SID = "AC59b4b8ace104d3848b1921b873c2b444";
	public static final String AUTH_TOKEN = "81b3a14dd4bdd8d24f6f272bc9bdc6fe";
	public static final String PHONE_NUMBER = "2015848078";
	// https://www.microsoft.com/en-in/
	private By signInLink = By.id("mectrl_headerPicture");

	private By signUpLink = By.id("signup");
	private By PhonesignUpLink = By.id("phoneSwitch");

	private By phoneCountry = By.id("PhoneCountry");
	private By selectPhoneCountry = By.xpath("//option[@data-value='US']");

	private By phoneNumberTxtBox = By.id("MemberName");
	private By continueBtn = By.id("iSignupAction");
	private By enterPasswordTxtBox = By.id("PasswordInput");
	private By enterFirstNameTxtBox = By.id("FirstName");

	private By enterLastNameTxtBox = By.id("LastName");

	private By selectCountry = By.id("Country"); // United States

	private By selectBirthDate = By.id("BirthDay");
	private By selectMonth = By.id("BirthMonth");
	private By selectYear = By.id("BirthYear");

	public CreateUserPage(WebDriver driver) {
		super(driver);
	}

	/**
	 * @return the phonesignUpLink
	 */
	public WebElement getPhonesignUpLink() {
		return getElement(PhonesignUpLink);
	}

	/**
	 * @return the selectPhoneCountry
	 */
	public WebElement getSelectPhoneCountry() {
		return getElement(selectPhoneCountry);
	}

	/**
	 * @return the enterFirstNameTxtBox
	 */
	public WebElement getEnterFirstNameTxtBox() {
		return getElement(enterFirstNameTxtBox);
	}

	/**
	 * @return the enterLastNameTxtBox
	 */
	public WebElement getEnterLastNameTxtBox() {
		return getElement(enterLastNameTxtBox);
	}

	/**
	 * @return the selectCountry
	 */
	public WebElement getSelectCountry() {
		return getElement(selectCountry);
	}

	/**
	 * @return the selectBirthDate
	 */
	public WebElement getSelectBirthDate() {
		return getElement(selectBirthDate);
	}

	/**
	 * @return the selectMonth
	 */
	public WebElement getSelectMonth() {
		return getElement(selectMonth);
	}

	/**
	 * @return the selectYear
	 */
	public WebElement getSelectYear() {
		return getElement(selectYear);
	}

	/**
	 * @return the signInLink
	 */
	public WebElement getSignInLink() {
		return getElement(signInLink);
	}

	/**
	 * @return the signUpLink
	 */

	public WebElement getSignUpLink() {
		return getElement(signUpLink);
	}

	public WebElement getPhoneSwitch() {
		return getElement(PhonesignUpLink);
	}

	/**
	 * @return the phoneCountry
	 */
	public WebElement getPhoneCountry() {
		return getElement(phoneCountry);
	}

	/**
	 * @return the phoneNumberTxtBox
	 */
	public WebElement getPhoneNumberTxtBox() {
		return getElement(phoneNumberTxtBox);
	}

	/**
	 * @return the continueBtn
	 */
	public WebElement getContinueBtn() {
		return getElement(continueBtn);
	}

	/**
	 * @return the enterPasswordTxtBox
	 */
	public WebElement getEnterPasswordTxtBox() {
		return getElement(enterPasswordTxtBox);
	}

	public Select selectElement(WebElement element) {
		Select selectVal = null;
		selectVal = new Select(element);
		return selectVal;
	}
	// CreatePage methods

	public void loginWithoutUserInfo() throws Exception {
		getSignInLink().click();
		getSignUpLink().click();
		getPhoneSwitch().click();
		Select selectPhone = new Select(getPhoneCountry());
		selectPhone.selectByVisibleText("United States ‏(‎+1)");
		getPhoneNumberTxtBox().sendKeys(PHONE_NUMBER);
		getContinueBtn().click();
		getEnterPasswordTxtBox().sendKeys("Anupam@123");
		getContinueBtn().click();
		getEnterFirstNameTxtBox().sendKeys("Anupam");
		getEnterLastNameTxtBox().sendKeys("Chandan");
		getContinueBtn().click();

		selectElement(getSelectCountry()).selectByVisibleText("United States");
		selectElement(getSelectBirthDate()).selectByVisibleText("13");
		selectElement(getSelectMonth()).selectByVisibleText("January");
		selectElement(getSelectYear()).selectByVisibleText("1988");
		getContinueBtn().click();
		Thread.sleep(5000);
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
		System.out.println("getMessages() " + getMessages());
		String smsBody = getMessage();
		//System.out.println("smsBody " + smsBody);
		
		

	}

	public static String getMessage() {
		return getMessages().filter(m -> m.getDirection().compareTo(Message.Direction.INBOUND) == 0)
				.filter(m -> m.getTo().equals("+12015848078")).map(Message::getBody).findFirst()
				.orElseThrow(IllegalStateException::new);
	}

	private static Stream<Message> getMessages() {
		ResourceSet<Message> messages = Message.reader(ACCOUNT_SID).read();
		return StreamSupport.stream(messages.spliterator(), false);
	}

}
