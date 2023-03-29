package vTiger.ContactsTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.Test;

public class Launchfirefox {

	@Test
	public void launch()
	{
//		FirefoxOptions options = new FirefoxOptions();
//		options.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.gecko.driver", "D:\\selenium folder\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.google.com/");
	}
}
