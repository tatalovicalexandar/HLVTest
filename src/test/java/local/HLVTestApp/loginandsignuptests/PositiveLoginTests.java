package local.HLVTestApp.loginandsignuptests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import local.HLVTestApp.base.BaseTest;
import local.HLVTestApp.pages.LoginFormPageObject;
import local.HLVTestApp.pages.ResponsiveSocialLoginFormPageObject;

public class PositiveLoginTests extends BaseTest{

	@Parameters({ "username", "password" })
	@Test
	public void verifySuccessfullLoginActionOnMainPage(String username, String password) {
		
		// Include test in test report
		test = report.createTest("verifySuccessfullLoginActionOnMainPage");
				
		// Open main page
		ResponsiveSocialLoginFormPageObject mainPage = new ResponsiveSocialLoginFormPageObject(driver);
		mainPage.openPage();
		
		//Execute login
		mainPage.logIn(username, password);
	
		// Verification: New URL
		Assert.assertEquals(mainPage.getCurrentUrl(), mainPage.getPageUrl() + "login");
	}
	
	@Parameters({ "username", "password" })
	@Test
	public void verifySuccessfullLoginActionOnLoginPage(String username, String password) {
		
		// Include test in test report
		test = report.createTest("verifySuccessfullLoginActionOnLoginPage");
				
		// Open main page
		ResponsiveSocialLoginFormPageObject mainPage = new ResponsiveSocialLoginFormPageObject(driver);
		mainPage.openPage();
		
		// Open Login Form page	
		LoginFormPageObject loginForm = mainPage.clickOnLogInButton();
		
		// Execute login
		loginForm.logIn(username, password);
		
		// Verification: New URL
		Assert.assertEquals(loginForm.getPageUrl(), loginForm.getCurrentUrl());

		// Verification: HOME Link is visible
		Assert.assertTrue(loginForm.isHomeLinkVisible(), "HOME link is visible.");
	}
}
