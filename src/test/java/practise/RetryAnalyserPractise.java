package practise;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryAnalyserPractise {
	
	@Test(retryAnalyzer = vTigerGenericUtility.RetryAnalyserImplementation.class)
	public void practise()
	{
		Assert.fail();
		System.out.println("hello");
	}

}
