package testScript;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.AdminUsers_Page;
import pages.Login_page;
import utilities.Excel_Utility;

public class AdminUsers_Test extends Base{
	@Test
	
	
	public void verifyUserAbleToAddNewUser() throws IOException
	{
		String userName = Excel_Utility.getStringData(1, 0, "loginpage");
		String password = Excel_Utility.getStringData(1, 1,"loginpage");
		Login_page login_page = new Login_page(driver);
		login_page.enterUserName(userName);
		login_page.enterPassword(password);
		login_page.clickSigninButton();
		AdminUsers_Page adminusers_page = new AdminUsers_Page(driver);
		adminusers_page.clickAdminUsersMoreInfo();
		adminusers_page.clickNewButton();
		String adminusername ="Amruthas";
		String adminpassword ="Abcdefgh";
		adminusers_page.enterUserNameField(adminusername);
		adminusers_page.enterPasswordField(adminpassword);
		adminusers_page.selectUserTypeFromDropdown();
		adminusers_page.clickSaveButton();
		adminusers_page.isUserCreatedSuccessAlertDisplayed();
		
	}

}
