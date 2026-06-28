package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.Login_page;
import pages.ManageContact_Page;
import utilities.Excel_Utility;

public class ManageContact_Test extends Base{
	@Test(retryAnalyzer=retry.Retry.class,description= "validating manage contact test")
	
	public void verifyUserAbleToAddNewContacts() throws IOException
	{
		String userName = Excel_Utility.getStringData(1, 0, "loginpage");
		String password = Excel_Utility.getStringData(1, 1,"loginpage");
		Login_page login_page = new Login_page(driver);
		login_page.enterUserName(userName);
		login_page.enterPassword(password);
		login_page.clickSigninButton();
		ManageContact_Page manageContact = new ManageContact_Page(driver);
		manageContact.clickManageContactMoreInfo();
		manageContact.clickEditButton();
		manageContact.enterPhoneNo("6789098766");
		manageContact.enterEmail("abcd@gmail.com");
		manageContact.enterAddress("ABC Hill View");
		manageContact.enterDeliveryTime("30");
		manageContact.enterDeliveryCharge("200");
		manageContact.clickUpdate();
		boolean alertmessageDisplayed = login_page.isAlertDisplayed();
		Assert.assertTrue(alertmessageDisplayed);
		
	}
	
	
}
