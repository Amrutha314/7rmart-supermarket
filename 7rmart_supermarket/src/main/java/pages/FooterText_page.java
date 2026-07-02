package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FooterText_page {
	WebDriver driver;
	
	//@FindBy(xpath="(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-footertext'])[3]")WebElement footerTextMoreInfo;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/Footertext/edit?edit=1']")WebElement footerTextEdit;
	@FindBy(xpath="//textarea[@placeholder='Enter the Address']")WebElement enterAddressField;
	@FindBy(xpath="//input[@id='email']")WebElement enterEmailId;
	@FindBy(xpath="//input[@id='phone']")WebElement enterPhoneNumber;
	@FindBy(xpath="//button[@name='Update']")WebElement updateButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement alert;
	
	public FooterText_page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	/*
	public FooterText_page clickFooterTextMoreInfo()
	{
		footerTextMoreInfo.click();
		return this;
	}
	*/
	public FooterText_page clickEditButton()
	{
		footerTextEdit.click();
		return this;
	}
	public FooterText_page enterAddress(String address)
	{
		enterAddressField.clear();
		enterAddressField.sendKeys(address);
		return this;
	}
	public FooterText_page enterEmailId(String emailid)
	{
		enterEmailId.clear();
		enterEmailId.sendKeys(emailid);
		return this;
	}
	public FooterText_page enterPhoneNumber(String phonenumber)
	{
		enterPhoneNumber.clear();
		enterPhoneNumber.sendKeys(phonenumber);
		return this;
	}
	public FooterText_page clickUpdateButton()
	{
		updateButton.click();
		return this;
	}
	public boolean isSuccessmessageDisplayed()
	{
		return alert.isDisplayed();
		
	}
	

}
