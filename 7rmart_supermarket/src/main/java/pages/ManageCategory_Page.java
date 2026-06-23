package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.FileUpload_Utility;
import utilities.Page_Utility;

public class ManageCategory_Page {
	public WebDriver driver;
	FileUpload_Utility fileUpload_Utility = new FileUpload_Utility();
	Page_Utility page_Utility = new Page_Utility();
	
	@FindBy(xpath="(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category'])[2]")WebElement CategoryMoreInfo;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/Category/add']")WebElement addnewBtn;
	@FindBy(xpath="//input[@id='category']")WebElement categoryField;
	@FindBy(xpath="(//span[text()='discount'])[1]")WebElement discount;
	@FindBy(xpath="//input[@id='main_img']")WebElement chooseFile;
	@FindBy(xpath="//button[@type='submit']")WebElement saveBtn;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement alert;
	
	public ManageCategory_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	public void clickCategoryMoreInfo()
	{
		CategoryMoreInfo.click();
	}
	public void clickAddNewButton()
	{
		addnewBtn.click();
	}
	public void selectcategory(String category)
	{
		categoryField.sendKeys(category);
	}
	public void selectDiscount()
	{
		discount.click();
	}
	public void chooseFile(String Filepath) {
		
		fileUpload_Utility.fileUploadUsingSendkeys(chooseFile, Filepath);
	}
	public void clickSaveButton()
	{
		
		//page_Utility.javaScriptClick(driver, saveBtn);
		page_Utility.javaScriptScrollIntoView(driver, saveBtn);
		saveBtn.click();
	}
	public boolean isSuccessAlertDisplayed()
	{
		return alert.isDisplayed();
		
	}
	

}
