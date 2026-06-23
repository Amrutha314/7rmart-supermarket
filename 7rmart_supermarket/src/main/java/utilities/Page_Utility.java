package utilities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Page_Utility {
	
	public void dropdownVisibleText(WebElement element,String Text)
	{
		Select select = new Select(element);
		select.selectByVisibleText(Text);
	}

	public void dropdownValue(WebElement element,String value)
	{
		Select select = new Select(element);
		select.selectByValue(value);
	}
	
	public void dropdownIndex(WebElement element,int index)
	{
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	
	public void actionRightClick(WebDriver driver,WebElement element)
	{
		Actions objAction = new Actions(driver);
		objAction.contextClick(element).perform();
	}
	
	public void actionDragAndDrop(WebDriver driver,WebElement source,WebElement target)
	{
		Actions objAction = new Actions(driver);
		objAction.dragAndDrop(source, target).perform();
	}
	public void actionMouseHover(WebDriver driver,WebElement element)
	{
		Actions objAction = new Actions(driver);
		objAction.moveToElement(element).perform();
	}
	
	public void actionClick(WebDriver driver,WebElement element)
	{
		Actions objAction = new Actions(driver);
		 objAction.click(element).perform();
	}
	public void actionDoubleClick(WebDriver driver,WebElement element)
	{
		Actions objAction = new Actions(driver);
	}
	public void javaScriptExecutorScrolldown(WebDriver driver)
	{
		JavascriptExecutor js =(JavascriptExecutor) driver;
		js.executeScript("Window.scrollBy(0,150)","");
	}
	public void javaScriptClick(WebDriver driver,WebElement element)
	{
		JavascriptExecutor js =(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click:", element);
	}
	
	public void javScriptSendkeys(WebDriver driver,WebElement element,String Value)
	{
		JavascriptExecutor js =(JavascriptExecutor) driver;
		js.executeScript("argument[0].value='Selenium':", element);
	}
	
	
	
	//hw javascript scroll balance,alert
	public void javaScriptScrollUp(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-350)","");
	}
	public void javaScriptScrollToBottom(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)","");
	}
	public void javaScriptScrollIntoView(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
	}
	// alert
	public void simpleAlert(WebDriver driver, WebElement element, String text) {
		element.click();
		Alert alert = driver.switchTo().alert();
		text = alert.getText();
		System.out.println("Alert Message: " + text);
		alert.accept();
	}
	public void confirmationAlert(WebDriver driver,WebElement element) {
		element.click();
		Alert alert = driver.switchTo().alert();
		//alert.accept();
		alert.dismiss();
	}
	public void promptalert(WebDriver driver,WebElement element, String text) {
		element.click();
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(text);
		alert.accept();
	}

}

