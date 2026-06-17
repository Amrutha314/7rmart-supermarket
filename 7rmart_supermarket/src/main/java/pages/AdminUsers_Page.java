package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Page_Utility;

public class AdminUsers_Page {
	WebDriver driver;
	@FindBy(xpath="(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin'])[2]")WebElement adminUserMoreInfo;
	@FindBy(xpath="//a[text()=' New']")WebElement adminNewButton;
	@FindBy(xpath="//input[@id='username']")WebElement adminUserNameField;
	@FindBy(xpath="//input[@id='password']")WebElement adminPasswordField;
	@FindBy(xpath="//select[@id='user_type']")WebElement adminUserType;
	@FindBy(xpath="//button[@name='Create']")WebElement adminSaveButton;
	@FindBy(xpath="(//div[contains(.,'User Created Successfully')])[5]")WebElement userCreatedAlert;
	
	public AdminUsers_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	public void clickAdminUsersMoreInfo()
	{
		adminUserMoreInfo.click();
	}
	public void clickNewButton()
	{
		adminNewButton.click();
	}
	public void enterUserNameField(String adminusername)
	{
		adminUserNameField.sendKeys(adminusername);
	}

	public void enterPasswordField(String adminpassword)
	{
		adminPasswordField.sendKeys(adminpassword);
	}
	public void selectUserTypeFromDropdown()
	{
		Page_Utility dropdown = new  Page_Utility();//created the object
		dropdown.dropdownVisibleText(adminUserType,"Admin");;//(webElement name ,pass the Text)
	}
	public void clickSaveButton()
	{
		adminSaveButton.click();
	}
	public boolean isUserCreatedSuccessAlertDisplayed()
	{
		return userCreatedAlert.isDisplayed();
		
	}
}
