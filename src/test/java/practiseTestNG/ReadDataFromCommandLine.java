package practiseTestNG;

import org.testng.annotations.Test;

public class ReadDataFromCommandLine {
	@Test
	public void commndline()
	{
		String Browser = System.getProperty("browser");
		System.out.println(Browser);
		
		String URL = System.getProperty("url");
		System.out.println(URL);
		
		String UserName = System.getProperty("username");
		System.out.println(UserName);
		
		String Password = System.getProperty("password");
		System.out.println(Password);
	}

}
