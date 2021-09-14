package local.HLVTestApp.loginandsignuptests;

import java.util.Map;
import org.testng.Assert;
import org.testng.annotations.Test;
import local.HLVTestApp.base.BaseTest;
import local.HLVTestApp.base.CsvDataProviders;
import local.HLVTestApp.pages.LoginFormPageObject;
import local.HLVTestApp.pages.ResponsiveSocialLoginFormPageObject;

public class PositiveLoginTests extends BaseTest{

	@Test(dataProvider = "csvReader", dataProviderClass = CsvDataProviders.class)
	public void verifySuccessfulLoginActionOnMainPage(Map<String, String> testData) {
		
		// Data from data provider
		//String no = testData.get("no");
		String username = testData.get("username");
		String password = testData.get("password");
		//String description = testData.get("description");
		
		// Include test in test report
		test = report.createTest("verifySuccessfulLoginActionOnMainPage");
				
		// Open main page
		ResponsiveSocialLoginFormPageObject mainPage = new ResponsiveSocialLoginFormPageObject(driver);
		mainPage.openPage();
		
		//Execute login
		mainPage.logIn(username, password);
	
		// Verification: New URL
		Assert.assertEquals(mainPage.getCurrentUrl(), mainPage.getPageUrl() + "login");
	}
	
	@Test(dataProvider = "csvReader", dataProviderClass = CsvDataProviders.class)
	public void verifySuccessfulLoginActionOnLoginPage(Map<String, String> testData) {
		
		// Data from data provider
		//String no = testData.get("no");
		String username = testData.get("username");
		String password = testData.get("password");
		//String description = testData.get("description");
		
		// Include test in test report
		test = report.createTest("verifySuccessfulLoginActionOnLoginPage");
				
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
