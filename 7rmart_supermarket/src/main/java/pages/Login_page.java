package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Wait_Utility;

public class Login_page {
	
	public WebDriver driver;
	//Wait_Utility wait = new Wait_Utility();//globally declared the wait utility
	
	@FindBy(xpath="//input[@placeholder='Username']")WebElement userNameField;
	@FindBy(xpath="//input[@placeholder='Password']")WebElement passwordField ;
	@FindBy(xpath="//button[text()='Sign In']")WebElement signInButton;
	@FindBy(xpath="//p[text()='Dashboard']")WebElement dashboard;
	@FindBy(xpath="//div[contains(@class,'dismissible')]")WebElement alertSignInPage;
	
	
	

	public Login_page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}

	public void enterUserName(String userName) 
	{
		userNameField.sendKeys(userName); 
	}
	
	public void enterPassword(String password)
	{
		passwordField.sendKeys(password);
	}
		
	public void clickSigninButton()
	{
		
		//wait.waitForElementToBeClickable(driver, signInButton);//to apply wait
		signInButton.click();
	}

	public boolean isDashboardDisplayed()
	{
		return dashboard.isDisplayed();//return trie or flase thats why return type boolean .
	}
	public boolean isAlertDisplayed()
	{
		return alertSignInPage.isDisplayed();
		
	}
}
