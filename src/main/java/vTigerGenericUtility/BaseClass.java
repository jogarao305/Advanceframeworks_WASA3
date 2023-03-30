package vTigerGenericUtility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.LoginPage;

/**
 * This class consists of Basic configurations of TestNG
 * @author Jogarao G
 * 
 *
 */

public class BaseClass {
	
	public WebDriverUtility wutil = new WebDriverUtility();
	public ExcelFileUtility eutil = new ExcelFileUtility();
	public PropertyFileUtility putil = new PropertyFileUtility();
	public JavaUtility jutil = new JavaUtility();
	public static WebDriver Sdriver; // for listeners
	
	public WebDriver driver;
	
	@BeforeSuite(groups = {"SmokeSuite","RegressionSuite"})
	public void bsConfig()
	{
		System.out.println("DataBase connection established");
	}
	
	//@Parameters("browser")
	//@BeforeTest
	@BeforeClass(groups = {"SmokeSuite","RegressionSuite"})
	public void bcConfig(/*String BROWSER*/) throws IOException
	{
		String BROWSER = putil.readDataFromProperties("browser");
		String URL = putil.readDataFromProperties("url");
		if(BROWSER.equalsIgnoreCase("edge"))
		{
			//WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			System.out.println("---"+BROWSER+ " Launched successfully");
		}
		else if(BROWSER.equalsIgnoreCase("chrome"))
		{
			ChromeOptions option = new ChromeOptions();
			   option.addArguments("--remote-allow-origins=*");
				driver = new ChromeDriver(option);
				System.out.println("----"+BROWSER+ "launched successfully");
		}
		else
		{
			System.out.println("Invalid Browser");
		}
		
		Sdriver=driver;  //for listeners (for screenshots)
		driver.get(URL);
	   wutil.maximizeWindow(driver);
	   wutil.waitForPage(driver);
	}
	
	@BeforeMethod(groups = {"SmokeSuite","RegressionSuite"})
	public void bmConfig() throws IOException
	{
		String USERNAME = putil.readDataFromProperties("username");
		String PASSWORD = putil.readDataFromProperties("password");
		LoginPage lp =new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		System.out.println("---Login Successfull----");
	}
	
	@AfterMethod(groups = {"SmokeSuite","RegressionSuite"})
	public void amConfig()
	{
		HomePage hmpg = new HomePage(driver);
		  hmpg.signOut(driver);
		  System.out.println("---Logout successful---");
	}
	
	@AfterClass(groups = {"SmokeSuite","RegressionSuite"})
	public void acConfig()
	{
		driver.quit();
		System.out.println("---Browser Closed Successfully---");
	}
	
	@AfterSuite(groups = {"SmokeSuite","RegressionSuite"})
	public void asConfig()
	{
		System.out.println("---Database connection Closed Successfully---");
	}

}
