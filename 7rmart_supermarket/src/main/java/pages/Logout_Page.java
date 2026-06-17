package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Logout_Page {
	WebDriver driver;

	@FindBy(xpath="//a[@data-toggle='dropdown']")WebElement adminIcon;
	@FindBy(xpath="(//a[@class='dropdown-item'])[2]")WebElement logoutButton;
	@FindBy(xpath="//button[text()='Sign In']")WebElement signInButton;
	
	public Logout_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
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
