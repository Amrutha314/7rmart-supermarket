package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_Page {
	WebDriver driver;

	@FindBy(xpath="//a[@data-toggle='dropdown']")WebElement adminIcon;
	@FindBy(xpath="(//a[@class='dropdown-item'])[2]")WebElement logoutButton;
	@FindBy(xpath="//button[text()='Sign In']")WebElement signInButton;
	
	@FindBy(xpath="(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news'])[2]")WebElement newsMoreInfo;
	@FindBy(xpath="(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-contact'])[2]")WebElement manageContactMoreInfo;
	@FindBy(xpath="(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin'])[2]")WebElement adminUserMoreInfo;
	@FindBy(xpath="(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-footertext'])[3]")WebElement footerTextMoreInfo;
	@FindBy(xpath="(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category'])[2]")WebElement CategoryMoreInfo;
	
	public Home_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	
	public ManageNews_Page clickManageNewsMoreInfo()
    {
    	newsMoreInfo.click();
		return new ManageNews_Page(driver);
    }

	public ManageContact_Page clickManageContactMoreInfo()
	{
		manageContactMoreInfo.click();
		return new ManageContact_Page(driver) ;
	}
	public AdminUsers_Page clickAdminUsersMoreInfo()
	{
		adminUserMoreInfo.click();
		return new AdminUsers_Page(driver);
	}
	public FooterText_page clickFooterTextMoreInfo()
	{
		footerTextMoreInfo.click();
		return new FooterText_page(driver);
	}
	public ManageCategory_Page clickCategoryMoreInfo()
	{
		CategoryMoreInfo.click();
		return new ManageCategory_Page(driver);
	}
	
	public void clickAdminIcon()
	{
		adminIcon.click();
	}
	
	public void clickLogoutButton()
	{
		logoutButton.click();
	}
	public boolean isSignInButtonDisplayed()
	{
		return signInButton.isDisplayed();
		
	}
}
