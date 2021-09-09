package local.HLVTestApp.loginandsignuptests;

import org.testng.Assert;
import org.testng.annotations.Test;
import local.HLVTestApp.base.BaseTest;
import local.HLVTestApp.pages.FinalSignUpPageObject;
import local.HLVTestApp.pages.LoginFormPageObject;
import local.HLVTestApp.pages.ResponsiveSocialLoginFormPageObject;
import local.HLVTestApp.pages.SignUpPageObject;

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
	
	@Test
	public void verifySuccessfullSignUpAction() {
		// Open main page
		ResponsiveSocialLoginFormPageObject mainPage = new ResponsiveSocialLoginFormPageObject(driver);
		mainPage.openPage();
		
		// Open Sign Up Form page	
		SignUpPageObject signUpForm = mainPage.clickOnSignUpButton();
		
		// Execute sign up
		FinalSignUpPageObject finalSignUpPage = signUpForm.signUp("test2222", "test2222", "test2222", "test2222", "test2222", "test2222");
		
		// Verification: New URL
		Assert.assertEquals(finalSignUpPage.getPageUrl(), signUpForm.getCurrentUrl());

		// Verification: HOME Link is visible
		Assert.assertTrue(finalSignUpPage.isHomeLinkVisible(), "HOME link is visible.");
		
		// Successful sign up message
		String expectedSuccessMessage = "User has been successfully registered.";
		String actualSuccessMessage = finalSignUpPage.getMessageText();
		Assert.assertEquals(expectedSuccessMessage, actualSuccessMessage);		
	}
	
	@Test(description="User already exist")
	public void verifyUnsuccessfullSignUpAction() {
		// Open main page
		ResponsiveSocialLoginFormPageObject mainPage = new ResponsiveSocialLoginFormPageObject(driver);
		mainPage.openPage();
		
		// Open Sign Up Form page	
		SignUpPageObject signUpForm = mainPage.clickOnSignUpButton();
		
		// Execute sign up
		FinalSignUpPageObject finalSignUpPage = signUpForm.signUp("test2222", "test2222", "test2222", "test2222", "test2222", "test2222");
		
		// Verification: New URL
		Assert.assertEquals(finalSignUpPage.getPageUrl(), signUpForm.getCurrentUrl());

		// Verification: HOME Link is visible
		Assert.assertTrue(finalSignUpPage.isHomeLinkVisible(), "HOME link is visible.");
		
		// Unsuccessful sign up message
		String expectedUnsuccessMessage = "Oops! There is already a user registered with the email provided.";
		String actualUnsuccessMessage = finalSignUpPage.getMessageText();
		Assert.assertEquals(expectedUnsuccessMessage, actualUnsuccessMessage);
	}
}
