package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.ConstantClass;
import pages.Login_page;
import utilities.Excel_Utility;

public class Login_Test extends Base {
	
	@Test(description = "Verifying valid login functionality", groups = {"regression"})
	
	public void Verify_ValidUsernameAndPassword() throws IOException
	{
		//String userName ="admin";
		//String password = "admin";
		String userName = Excel_Utility.getStringData(1, 0, "loginpage");
		String password = Excel_Utility.getStringData(1, 1,"loginpage");
		Login_page login_page = new Login_page(driver);
		login_page.enterUserName(userName);
		login_page.enterPassword(password);
		login_page.clickSigninButton();
		boolean homepage = login_page.isDashboardDisplayed();
		Assert.assertTrue(homepage,ConstantClass.VALIDCREDENTIALS);//it will pass/Fail the TC based on the condition
		
	}
	@Test
	
	public void Verify_InvalidUserName_And_ValidPassword() throws IOException
	{
		//String userName ="amrutha";
		//String password = "admin";
		String userName = Excel_Utility.getStringData(2, 0, "loginpage");
		String password = Excel_Utility.getStringData(2, 1,"loginpage");
		Login_page login_page = new Login_page(driver);
		login_page.enterUserName(userName);
		login_page.enterPassword(password);
		login_page.clickSigninButton();
		boolean alertmessage = login_page.isAlertDisplayed();
		Assert.assertTrue(alertmessage);
	}
	@Test
	
	public void verify_ValidUserName_And_InvalidPassword() throws IOException
	{
		//String userName ="admin";
		//String password = "aaadmin";
		String userName = Excel_Utility.getStringData(3, 0, "loginpage");
		String password = Excel_Utility.getStringData(3, 1,"loginpage");
		Login_page login_page = new Login_page(driver);
		login_page.enterUserName(userName);
		login_page.enterPassword(password);
		login_page.clickSigninButton();
		boolean alertmessage = login_page.isAlertDisplayed();
		Assert.assertTrue(alertmessage);
	}
	@Test
	
	public void InvalidUserName_And_InvalidPassword() throws IOException
	{
		//String userName ="adminss";
		//String password = "aaadmin";
		String userName = Excel_Utility.getStringData(4, 0, "loginpage");
		String password = Excel_Utility.getStringData(4, 1,"loginpage");
		Login_page login_page = new Login_page(driver);
		login_page.enterUserName(userName);
		login_page.enterPassword(password);
		login_page.clickSigninButton();	
		boolean alertmessage = login_page.isAlertDisplayed();
		Assert.assertTrue(alertmessage);
	}

}
