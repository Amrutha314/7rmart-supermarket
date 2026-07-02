package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.ConstantClass;
import pages.Home_Page;
import pages.Login_page;
import pages.ManageContact_Page;
import utilities.Excel_Utility;

public class ManageContact_Test extends Base{
	Home_Page homePage;
	ManageContact_Test manageContact;
	
	@Test(retryAnalyzer=retry.Retry.class,description= "validating manage contact test")
	
	public void verifyUserAbleToAddNewContacts() throws IOException
	{
		String userName = Excel_Utility.getStringData(1, 0, "loginpage");
		String password = Excel_Utility.getStringData(1, 1,"loginpage");
		Login_page login_page = new Login_page(driver);
		login_page.enterUserName(userName).enterPassword(password);
		//login_page.enterPassword(password);
		homePage=login_page.clickSigninButton();
		ManageContact_Page manageContact = new ManageContact_Page(driver);
		manageContact=homePage.clickManageContactMoreInfo();
		manageContact.clickEditButton().enterPhoneNo("6789098766").enterEmail("abcd@gmail.com").enterAddress("ABC Hill View").enterDeliveryTime("30").enterDeliveryCharge("200").clickUpdate();
		
		/*manageContact.enterPhoneNo("6789098766");
		manageContact.enterEmail("abcd@gmail.com");
		manageContact.enterAddress("ABC Hill View");
		manageContact.enterDeliveryTime("30");
		manageContact.enterDeliveryCharge("200");
		manageContact.clickUpdate();*/
		
		boolean addContacts = login_page.isDashboardDisplayed();
		Assert.assertTrue(addContacts,ConstantClass.ADDCONTACT);
		
	}
	
	
}
