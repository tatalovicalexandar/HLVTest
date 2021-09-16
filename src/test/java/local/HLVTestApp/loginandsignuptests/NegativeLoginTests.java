package local.HLVTestApp.loginandsignuptests;

import java.util.Map;
import org.testng.Assert;
import org.testng.annotations.Test;
import local.HLVTestApp.base.BaseTest;
import local.HLVTestApp.base.CsvDataProviders;
import local.HLVTestApp.pages.LoginFormPageObject;
import local.HLVTestApp.pages.ResponsiveSocialLoginFormPageObject;

public class NegativeLoginTests extends BaseTest {

	@Test(dataProvider = "csvReader", dataProviderClass = CsvDataProviders.class)
	public void verifyUnsuccessfulLoginActionOnMainPage(Map<String, String> testData) {

		// Data from data provider
		String no = testData.get("no");
		String username = testData.get("username");
		String password = testData.get("password");
		String expectedErrorMessage = testData.get("expectedMessage");
		String description = testData.get("description");

		// Initial starting test log
		log.info("Starting verifyUnsuccessfulLoginActionOnMainPageTest #" + no + " for " + description);

		// Include test in test report
		test = report.createTest("verifyUnsuccessfulLoginActionOnMainPage");

		// Open main page
		ResponsiveSocialLoginFormPageObject mainPage = new ResponsiveSocialLoginFormPageObject(driver, log);
		mainPage.openPage();

		// Execute login
		mainPage.logIn(username, password);

		// Verification: New URL
		Assert.assertEquals(mainPage.getCurrentUrl(), mainPage.getPageUrl() + "login");

		// Verification: Return to Login Link is visible
		Assert.assertTrue(mainPage.isReturnToLoginLinkVisible(), "Return to Login link is visible.");

		// Unsuccessful login message
		String actualUnsuccessfulMessage = mainPage.getMessageText();
		Assert.assertEquals(expectedErrorMessage, actualUnsuccessfulMessage);
	}

	@Test(dataProvider = "csvReader", dataProviderClass = CsvDataProviders.class)
	public void verifyUnsuccessfulLoginActionOnLoginPage(Map<String, String> testData) {

		// Data from data provider
		String no = testData.get("no");
		String username = testData.get("username");
		String password = testData.get("password");
		String expectedErrorMessage = testData.get("expectedMessage");
		String description = testData.get("description");

		// Initial starting test log
		log.info("Starting verifyUnsuccessfulLoginActionOnLoginPageTest #" + no + " for " + description);

		// Include test in test report
		test = report.createTest("verifyUnsuccessfulLoginActionOnLoginPage");

		// Open main page
		ResponsiveSocialLoginFormPageObject mainPage = new ResponsiveSocialLoginFormPageObject(driver, log);
		mainPage.openPage();

		// Open Login Form page
		LoginFormPageObject loginForm = mainPage.clickOnLogInButton();

		// Execute login
		loginForm.logIn(username, password);

		// Verification: New URL
		Assert.assertEquals(loginForm.getCurrentUrl(), loginForm.getPageUrl());

		// Verification: Return to Login Link is visible
		Assert.assertTrue(loginForm.isReturnToLoginLinkVisible(), "Return to Login link is visible.");

		// Unsuccessful login message
		String actualUnsuccessfulMessage = loginForm.getMessageText();
		Assert.assertEquals(expectedErrorMessage, actualUnsuccessfulMessage);
	}
}
