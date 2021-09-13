package local.HLVTestApp.loginandsignuptests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import local.HLVTestApp.base.BaseTest;
import local.HLVTestApp.pages.LoginFormPageObject;
import local.HLVTestApp.pages.ResponsiveSocialLoginFormPageObject;

public class NegativeLoginTests extends BaseTest{
	

	@Parameters({ "username", "password", "expectedMessage" })
	@Test
	public void verifyUnsuccessfullLoginActionOnMainPage(String username, String password, String expectedErrorMessage) {
		
		// Include test in test report
		test = report.createTest("verifyUnsuccessfullLoginActionOnMainPage");
		
		// Open main page
		ResponsiveSocialLoginFormPageObject mainPage = new ResponsiveSocialLoginFormPageObject(driver);
		mainPage.openPage();
		//Execute login
		mainPage.logIn(username, password);
	
		// Verification: New URL
		Assert.assertEquals(mainPage.getCurrentUrl(), mainPage.getPageUrl() + "login");
		
		// Verification: Return to Login Link is visible
		Assert.assertTrue(mainPage.isReturnToLoginLinkVisible(), "Return to Login link is visible.");
		
		// Successful sign up message
		String actualSuccessMessage = mainPage.getMessageText();
		Assert.assertEquals(expectedErrorMessage, actualSuccessMessage);
	}
	
	@Parameters({ "username", "password", "expectedMessage" })
	@Test
	public void verifyUnsuccessfullLoginActionOnLoginPage(String username, String password, String expectedErrorMessage) {
		
		// Include test in test report
		test = report.createTest("verifyUnsuccessfullLoginActionOnLoginPage");
				
		// Open main page
		ResponsiveSocialLoginFormPageObject mainPage = new ResponsiveSocialLoginFormPageObject(driver);
		mainPage.openPage();

		// Open Login Form page	
		LoginFormPageObject loginForm = mainPage.clickOnLogInButton();
		
		// Execute login
		loginForm.logIn(username, password);
		
		// Verification: New URL
		Assert.assertEquals(loginForm.getCurrentUrl(), loginForm.getPageUrl());
		
		// Verification: Return to Login Link is visible
		Assert.assertTrue(loginForm.isReturnToLoginLinkVisible(), "Return to Login link is visible.");
		
		// Successful sign up message
		String actualSuccessMessage = loginForm.getMessageText();
		Assert.assertEquals(expectedErrorMessage, actualSuccessMessage);
	}
}
