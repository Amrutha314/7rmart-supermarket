package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.ConstantClass;
import pages.Home_Page;
import pages.Login_page;
import pages.ManageNews_Page;
import utilities.Excel_Utility;

public class ManageNews_Test extends Base {
	Home_Page homePage;
	ManageNews_Page managenews_page;
	
	@Test
	
	
	public void verifyUserAbleToAddNewNews() throws IOException
	{
		String userName = Excel_Utility.getStringData(1, 0, "loginpage");
		String password = Excel_Utility.getStringData(1, 1,"loginpage");
		Login_page login_page = new Login_page(driver);
		login_page.enterUserName(userName).enterPassword(password);
		//login_page.enterPassword(password);
		homePage=login_page.clickSigninButton();
		//ManageNews_Page managenews_page = new ManageNews_Page(driver);
		managenews_page=homePage.clickManageNewsMoreInfo();
		managenews_page.clickManageNewsAddButton().enterNewsInTextField("Hi! New product is launched.").clickSaveNewsButton();
		//managenews_page.enterNewsInTextField("Hi! New product is launched.");
		//managenews_page.clickSaveNewsButton();
		boolean addNews = login_page.isDashboardDisplayed();
		Assert.assertTrue(addNews,ConstantClass.ADDNEWS);
		
	}

}
