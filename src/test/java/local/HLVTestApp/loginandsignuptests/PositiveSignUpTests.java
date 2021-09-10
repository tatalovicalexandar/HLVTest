package local.HLVTestApp.loginandsignuptests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import local.HLVTestApp.base.BaseTest;
import local.HLVTestApp.pages.FinalSignUpPageObject;
import local.HLVTestApp.pages.ResponsiveSocialLoginFormPageObject;
import local.HLVTestApp.pages.SignUpPageObject;

public class PositiveSignUpTests extends BaseTest{

	@Parameters({ "firstName", "lastName", "username", "email", "password", "mobile", "expectedSuccessfullMessage", "expectedUnsuccessfullMessage"  })
	@Test
	public void verifySuccessfullSignUpAction(String firstName, String lastName, String username, String email, String password, String mobile, String expectedSuccessfullMessage, String expectedUnsuccessfullMessage) {
		// Open main page
		ResponsiveSocialLoginFormPageObject mainPage = new ResponsiveSocialLoginFormPageObject(driver);
		mainPage.openPage();
		
		// Open Sign Up Form page	
		SignUpPageObject signUpForm = mainPage.clickOnSignUpButton();
		
		// Execute sign up
		FinalSignUpPageObject finalSignUpPage = signUpForm.signUp(firstName, lastName, username, email, password, mobile);
		
		// Verification: New URL
		Assert.assertEquals(finalSignUpPage.getPageUrl(), signUpForm.getCurrentUrl());

		// Verification: HOME Link is visible
		Assert.assertTrue(finalSignUpPage.isHomeLinkVisible(), "HOME link is visible.");
		
		// Verification: Successful sign up message		
		String actualMessage = finalSignUpPage.getMessageText();
		Assert.assertEquals(expectedSuccessfullMessage, actualMessage);		
	}
}
