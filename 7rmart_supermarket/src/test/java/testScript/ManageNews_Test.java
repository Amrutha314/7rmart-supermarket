package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.Login_page;
import pages.ManageNews_Page;
import utilities.Excel_Utility;

public class ManageNews_Test extends Base {
	
	@Test(retryAnalyzer=retry.Retry.class)
	
	
	public void verifyUserAbleToAddNewNews() throws IOException
	{
		String userName = Excel_Utility.getStringData(1, 0, "loginpage");
		String password = Excel_Utility.getStringData(1, 1,"loginpage");
		Login_page login_page = new Login_page(driver);
		login_page.enterUserName(userName);
		login_page.enterPassword(password);
		login_page.clickSigninButton();
		ManageNews_Page managenews_page = new ManageNews_Page(driver);
		managenews_page.clickManageNewsMoreInfo();
		managenews_page.clickManageNewsAddButton();
		managenews_page.enterNewsInTextField("Hi! New product is launched.");
		managenews_page.clickSaveNewsButton();
		boolean alertmessageDisplayed = managenews_page.isSuccessAlertDisplayed();
		Assert.assertTrue(alertmessageDisplayed);
		
	}

}
