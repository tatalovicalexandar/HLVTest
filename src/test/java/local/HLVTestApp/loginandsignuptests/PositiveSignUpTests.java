package local.HLVTestApp.loginandsignuptests;

import java.util.Map;
import org.testng.Assert;
import org.testng.annotations.Test;
import local.HLVTestApp.base.BaseTest;
import local.HLVTestApp.base.CsvDataProviders;
import local.HLVTestApp.pages.FinalSignUpPageObject;
import local.HLVTestApp.pages.ResponsiveSocialLoginFormPageObject;
import local.HLVTestApp.pages.SignUpPageObject;

public class PositiveSignUpTests extends BaseTest {

	public void verifySuccessfulSignUpAction(Map<String, String> testData) {

		// Data from data provider
		String no = testData.get("no");
		String firstName = testData.get("firstName");
		String lastName = testData.get("lastName");
		String username = testData.get("username");
		String email = testData.get("email");
		String password = testData.get("password");
		String mobile = testData.get("mobile");
		String expectedMessage = testData.get("expectedMessage");
		String description = testData.get("description");

		// Initial starting test log
		log.info("Starting verifySuccessfulSignUpActionTest #" + no + " for " + description);

		// Include test in test report
		test = report.createTest("verifySuccessfulSignUpAction");

		// Open main page
		ResponsiveSocialLoginFormPageObject mainPage = new ResponsiveSocialLoginFormPageObject(driver, log);
		mainPage.openPage();

		// Open Sign Up Form page
		SignUpPageObject signUpForm = mainPage.clickOnSignUpButton();

		// Execute sign up
		FinalSignUpPageObject finalSignUpPage = signUpForm.signUp(firstName, lastName, username, email, password,
				mobile);

		// Verification: New URL
		Assert.assertEquals(finalSignUpPage.getPageUrl(), signUpForm.getCurrentUrl());

		// Verification: HOME Link is visible
		Assert.assertTrue(finalSignUpPage.isHomeLinkVisible(), "HOME link is visible.");

		// Verification: Successful sign up message
		String actualMessage = finalSignUpPage.getMessageText();
		// Assert.assertEquals(expectedSuccessfulMessage, actualMessage);
		Assert.assertEquals(actualMessage, expectedMessage);
	}

	@Test(dataProvider = "csvReader", dataProviderClass = CsvDataProviders.class)
	public void verifySuccessfulSignUpActionChrome(Map<String, String> testData) {

		verifySuccessfulSignUpAction(testData);
	}

	@Test(dataProvider = "csvReader", dataProviderClass = CsvDataProviders.class)
	public void verifySuccessfulSignUpActionFirefox(Map<String, String> testData) {

		verifySuccessfulSignUpAction(testData);
	}
}
