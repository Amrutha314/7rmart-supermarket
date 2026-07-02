package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.ConstantClass;
import pages.Home_Page;
import pages.Login_page;
import pages.ManageCategory_Page;
import utilities.Excel_Utility;

public class ManageCategory_Test extends Base {
	Home_Page homePage;
	ManageCategory_Test manage_category;
	
	@Test(description= "validating manage category")
	
	
	public void verifyUserAbleToAddCategories() throws IOException
	{
		String userName = Excel_Utility.getStringData(1, 0, "loginpage");
		String password = Excel_Utility.getStringData(1, 1,"loginpage");
		Login_page login_page = new Login_page(driver);
		login_page.enterUserName(userName).enterPassword(password);
		//login_page.enterPassword(password);
		homePage=login_page.clickSigninButton();
		ManageCategory_Page manage_category = new ManageCategory_Page(driver);
		manage_category=homePage.clickCategoryMoreInfo();
		manage_category.clickAddNewButton().selectcategory("Fresh Apples premiumss").selectDiscount().chooseFile(ConstantClass.TESTIMAGEFILE).clickSaveButton();
		
		//manage_category.selectcategory("Fresh Apples categoriesss");
		//manage_category.selectDiscount();
		//manage_category.chooseFile(ConstantClass.TESTIMAGEFILE);
		//manage_category.clickSaveButton();
		
		boolean addCategory = login_page.isDashboardDisplayed();
		Assert.assertTrue(addCategory,ConstantClass.ADDCATEGORY);
		
	}

}
