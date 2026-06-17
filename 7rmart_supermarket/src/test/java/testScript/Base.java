package testScript;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utilities.Wait_Utility;

public class Base {
	
	public WebDriver driver;//declaring globally(Instance)

	@BeforeMethod
	public void browserInitialize()
	{
		driver = new EdgeDriver(); // browser initialize -WebDriver driver = new ChromeDriver
		//To launch the browser.Here WebDriver is an Interface provided by selenium and ChromeDriver is a class provided by Selenium.
		//driver is the reference variable
		driver.get("https://groceryapp.uniqassosiates.com/admin/login");//get()-method in WebDriver interface.
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Wait_Utility.IMPLICIT_WAIT));//implicit wit can given only in base class
		driver.manage().window().maximize();// Manage()-method used to access browser settings.window()-method used to access browser window operations	.maximize()-method used to maximize the current browser window
		
	
	}
	
	//@AfterMethod
	public void browserQuitAndClose()
	{
		driver.quit();// Closes all browser windows or tabs.
		//driver.close();// close()-close only the current browser window or tab
	}
}


