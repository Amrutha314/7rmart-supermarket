package utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebElement;

public class FileUpload_Utility {

	public void fileUploadUsingSendkeys(WebElement element,String Filepath)
	{
		element.sendKeys(Filepath);
	}
	public void fileUploadUsingRobotClass(WebElement element,String Filepath) throws AWTException
	{
		StringSelection sObj = new StringSelection("C:\\Users\\ksjis\\OneDrive\\Documents\\JISHNU K.pdf");//used to store the file path using stringselector class
		//stringselection stores the file path as text
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sObj, null);//copy filepath into system  clipboard. it used instead of cntrl+C.the action is same as Control+c
		Robot rObj =new Robot();//Robot class is used to perform keyboard actions.
		rObj.delay(2500);//to handle the delay to upload file.
		rObj.keyPress(KeyEvent.VK_CONTROL);//to do the paste -here we click the control key.VK_control-virtual control.
		rObj.keyPress(KeyEvent.VK_V);//here we click the v key
		rObj.keyRelease(KeyEvent.VK_CONTROL);
		rObj.keyRelease(KeyEvent.VK_V);
		rObj.keyPress(KeyEvent.VK_ENTER);//press the enter key
		rObj.keyRelease(KeyEvent.VK_ENTER);
	}
}
