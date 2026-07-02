package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.Login_page;
import pages.Home_Page;
import utilities.Excel_Utility;

public class Home_Test extends Base {
	
	@Test(description = "Verifying valid logout functionality", groups = {"regression"})
	
	public void verifyUserLogout() throws IOException
	{
		//String userName ="admin";
		//String password = "admin";
		String userName = Excel_Utility.getStringData(1, 0, "loginpage");
		String password = Excel_Utility.getStringData(1, 1,"loginpage");
		Login_page login_page = new Login_page(driver);
		login_page.enterUserName(userName);
		login_page.enterPassword(password);
		login_page.clickSigninButton();
		
		//logout
		Home_Page logout_page = new Home_Page(driver);
		logout_page.clickAdminIcon();
		logout_page.clickLogoutButton();
		boolean homepageDisplayed =logout_page.isSignInButtonDisplayed();
		Assert.assertTrue(homepageDisplayed);
	}

}
