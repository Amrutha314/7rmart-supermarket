package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.ConstantClass;
import pages.FooterText_page;
import pages.Home_Page;
import pages.Login_page;
import utilities.Excel_Utility;

public class FooterText_Test extends Base {
	Home_Page homePage;
	 FooterText_Test footertext_page;
	@Test(retryAnalyzer=retry.Retry.class,description= "validating manage footer")
	
	
	public void verifyuserisAbleToUpdateFooterTextInformation() throws IOException
	{
		String userName = Excel_Utility.getStringData(1, 0, "loginpage");
		String password = Excel_Utility.getStringData(1, 1,"loginpage");
		Login_page login_page = new Login_page(driver);
		login_page.enterUserName(userName).enterPassword(password);
		login_page.enterPassword(password);
		homePage=login_page.clickSigninButton();
		
		FooterText_page footertext_page=new FooterText_page(driver);
		footertext_page=homePage.clickFooterTextMoreInfo();
		footertext_page.clickEditButton().enterAddress("Mount Hill View").enterEmailId("abcd@gmail.com").enterPhoneNumber("9087897766").clickUpdateButton();
		
		/*
		String address ="Mount Hill View";
		footertext_page.enterAddress(address);
		String emailid = "abcd@gmail.com";
		footertext_page.enterEmailId(emailid);
		String phonenumber ="9087897766";
		footertext_page.enterPhoneNumber(phonenumber);
		footertext_page.clickUpdateButton();*/
		
		boolean footerText = login_page.isDashboardDisplayed();
		Assert.assertTrue(footerText,ConstantClass.UPDATEFOOTERTEXT);
	}

}
