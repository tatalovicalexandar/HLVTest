package local.HLVTestApp.loginandsignuptests;

import org.testng.Assert;
import org.testng.annotations.Test;
import local.HLVTestApp.base.BaseTest;
import local.HLVTestApp.pages.LoginFormPageObject;
import local.HLVTestApp.pages.ResponsiveSocialLoginFormPageObject;

public class PositiveLoginTest extends BaseTest{

	@Test
	public void verifySuccessfullLoginActionOnMainPage() {
		// Open main page
		ResponsiveSocialLoginFormPageObject mainPage = new ResponsiveSocialLoginFormPageObject(driver);
		mainPage.openPage();
		//Execute login
		mainPage.logIn("test1", "test1");
	
		// Verification: New URL
		Assert.assertEquals(mainPage.getCurrentUrl(), mainPage.getPageUrl() + "login");
	}
	
	@Test
	public void verifySuccessfullLoginActionOnLoginPage() {
		// Open main page
		ResponsiveSocialLoginFormPageObject mainPage = new ResponsiveSocialLoginFormPageObject(driver);
		mainPage.openPage();
		
		// Open Login Form page	
		LoginFormPageObject loginForm = mainPage.clickOnLogInButton();
		
		// Execute login
		loginForm.logIn("test1", "test1");
		
		// Verification: New URL
		Assert.assertEquals(loginForm.getPageUrl(), loginForm.getCurrentUrl());

		// Verification: HOME Link is visible
		Assert.assertTrue(loginForm.isHomeLinkVisible(), "HOME link is visible.");
	}
}
