package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.Login_page;
import pages.ManageNews_Page;
import utilities.Excel_Utility;

public class ManageNews_Test extends Base {
	
	@Test
	
	
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
		String entertext ="Hi! New product is launched.";
		managenews_page.enterNewsInTextField(entertext);
		managenews_page.clickSaveNewsButton();
		boolean alertmessageDisplayed = login_page.isAlertDisplayed();
		Assert.assertTrue(alertmessageDisplayed);
		
	}

}
