package testScript;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import constant.ConstantClass;
import utilities.ScreenshotUtility;
import utilities.Wait_Utility;

public class Base {
	
	public WebDriver driver;//declaring globally(Instance)
	public Properties properties;
	public FileInputStream fileinput;

	@BeforeMethod(alwaysRun=true)//executes regardless of grouping in XML
	@Parameters("browser")

	public void browserInitialize(String browser) throws Exception
	{
		//driver = new EdgeDriver(); // browser initialize -WebDriver driver = new ChromeDriver
		if (browser.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
		} else if (browser.equalsIgnoreCase("Chrome")) {
			driver = new EdgeDriver();
		} else {
			throw new Exception("invalid");
		}
		
		try {
			properties = new Properties();
			fileinput = new FileInputStream(ConstantClass.CONFIGFILE);
			properties.load(fileinput);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		//driver.get("https://groceryapp.uniqassosiates.com/admin/login");//get()-method in WebDriver interface.
		driver.get(properties.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Wait_Utility.IMPLICIT_WAIT));//implicit wit can given only in base class
		driver.manage().window().maximize();// Manage()-method used to access browser settings.window()-method used to access browser window operations	.maximize()-method used to maximize the current browser window
		
	
	}
	
	@AfterMethod(alwaysRun=true)
	public void browserQuit(ITestResult iTestResult) throws IOException {  //ITestResult is an interface
		if (iTestResult.getStatus() == ITestResult.FAILURE) {
			ScreenshotUtility scrShot = new ScreenshotUtility(); // creating obj
			scrShot.getScreenShot(driver, iTestResult.getName());
		}
		if (driver!=null) {
			driver.quit();
		}
	}
	
}


