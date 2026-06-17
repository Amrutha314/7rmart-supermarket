package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNews_Page {
	
	public WebDriver driver;
	
	@FindBy(xpath="(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news'])[2]")WebElement newsMoreInfo;
    @FindBy(xpath="//a[text()=' New']")WebElement newsAddButton;
    @FindBy(xpath="//textarea[@placeholder='Enter the news']")WebElement newsEnterText;
    @FindBy(xpath="//button[text()='Save']")WebElement saveButton;
    @FindBy(xpath="(//div[contains(.,'News Created Successfully')])[3]")WebElement newsSaveAlert;
    
    public ManageNews_Page(WebDriver driver) {
    	this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	public void clickManageNewsMoreInfo()
    {
    	newsMoreInfo.click();
    }
    public void clickManageNewsAddButton()
    {
    	newsAddButton.click();
    }
    public void enterNewsInTextField(String entertext)
    {
    	newsEnterText.sendKeys(entertext);
    }
    public void clickSaveNewsButton()
    {
    	saveButton.click();
    }
    public boolean isSuccessAlertDisplayed()
	{
		return newsSaveAlert.isDisplayed();
		
	}
}
