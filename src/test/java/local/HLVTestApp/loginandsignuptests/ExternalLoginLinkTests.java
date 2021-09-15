package local.HLVTestApp.loginandsignuptests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;
import local.HLVTestApp.base.BaseTest;
import local.HLVTestApp.base.CsvDataProviders;
import local.HLVTestApp.pages.ResponsiveSocialLoginFormPageObject;

public class ExternalLoginLinkTests extends BaseTest {

	@Test(dataProvider = "csvReader", dataProviderClass = CsvDataProviders.class)
	public void verifyLinkToSocialNetwork(Map<String, String> testData) {

		// Data from data provider
		// String no = testData.get("no");
		String socialNetwork = testData.get("socialNetwork");
		String expectedURL = testData.get("expectedURL");

		// Include test in test report
		test = report.createTest("verifySuccessfulLoginActionOnMainPage");

		// Open main page
		ResponsiveSocialLoginFormPageObject mainPage = new ResponsiveSocialLoginFormPageObject(driver);
		mainPage.openPage();

		// Click on Login with social network button
		switch(socialNetwork) {
		case "Facebook":
			mainPage.clickOnLoginWithFacebookButton();
			break;
		case "Twitter":
			mainPage.clickOnLoginWithTwitterButton();
			break;
		case "GooglePlus":
			mainPage.clickOnLoginWithGooglePlusButton();
			break;
		}		

		// Verification: Social network URL
		Assert.assertEquals(mainPage.getCurrentUrl(), expectedURL);
	}

}
