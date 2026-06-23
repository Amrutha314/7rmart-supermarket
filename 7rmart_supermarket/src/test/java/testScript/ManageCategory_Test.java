package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.ConstantClass;
import pages.Login_page;
import pages.ManageCategory_Page;
import utilities.Excel_Utility;

public class ManageCategory_Test extends Base {
	@Test(retryAnalyzer=retry.Retry.class)
	
	
	public void verifyUserAbleToAddCategories() throws IOException
	{
		String userName = Excel_Utility.getStringData(1, 0, "loginpage");
		String password = Excel_Utility.getStringData(1, 1,"loginpage");
		Login_page login_page = new Login_page(driver);
		login_page.enterUserName(userName);
		login_page.enterPassword(password);
		login_page.clickSigninButton();
		ManageCategory_Page manage_category = new ManageCategory_Page(driver);
		manage_category.clickCategoryMoreInfo();
		manage_category.clickAddNewButton();
		manage_category.selectcategory("freshfruitsss");
		manage_category.selectDiscount();
		manage_category.chooseFile(ConstantClass.TESTIMAGEFILE);
		manage_category.clickSaveButton();
		boolean alertmessageDisplayed = manage_category.isSuccessAlertDisplayed();
		Assert.assertTrue(alertmessageDisplayed);
		
	}

}
