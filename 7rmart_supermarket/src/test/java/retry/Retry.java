package retry;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {
	int counter = 0;
	int retryLimit = 2;//variable  indicates the no of execution
	
	//if a test case fail then the retry method will invoke.
	//ITestResult is used to capture the results
	public boolean retry(ITestResult result)	{
		if (counter<retryLimit)  //if this condition is true then counter++ then true-so re execute
		{
			counter++;
			return true;
		}
		return false;//stops the execution
	}

}
