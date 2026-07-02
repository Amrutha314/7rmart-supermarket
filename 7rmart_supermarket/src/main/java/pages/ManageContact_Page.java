package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageContact_Page  {
	public WebDriver driver;
	
	//@FindBy(xpath="(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-contact'])[2]")WebElement manageContactMoreInfo;
	@FindBy(xpath="//i[@class='fas fa-edit']")WebElement editButton;
	@FindBy(xpath="//input[@id='phone']")WebElement phone;
	@FindBy(xpath="//input[@id='email']")WebElement email;
	@FindBy(xpath="//textarea[@placeholder='Enter the Address']")WebElement address;
	@FindBy(xpath="//textarea[@placeholder='Enter Delivery Time']")WebElement deliveryTime;
	@FindBy(xpath="//input[@id='del_limit']")WebElement deliveryLimit;
	@FindBy(xpath="//button[@name='Update']")WebElement update;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement alert;
	
	public ManageContact_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	/*
	public ManageContact_Page clickManageContactMoreInfo()
	{
		manageContactMoreInfo.click();
		return this;
	}
	*/
	public ManageContact_Page clickEditButton()
	{
		editButton.click();
		return this;
	}
	public ManageContact_Page enterPhoneNo(String phoneno)
	{
		phone.clear();
		phone.sendKeys(phoneno);
		return this;
		
	}
	public ManageContact_Page enterEmail(String mail)
	{
		email.clear();
		email.sendKeys(mail);
		return this;
	}
	public ManageContact_Page enterAddress(String adrs) 
	{
		address.clear();
		address.sendKeys(adrs);
		return this;
	}
	public ManageContact_Page enterDeliveryTime(String time)
	{
		deliveryTime.clear();
		deliveryTime.sendKeys(time);
		return this;
		
		
	}
	public ManageContact_Page enterDeliveryCharge(String limit)
	{
		deliveryLimit.clear();
		deliveryLimit.sendKeys(limit);
		return this;
		
	}
	public ManageContact_Page clickUpdate()
	{
		update.click();
		return this;
	}
	public boolean isAlertDisplayed()
	{
		return alert.isDisplayed();
	}

}
