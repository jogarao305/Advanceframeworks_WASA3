package vTiger.ContactsTest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import vTigerGenericUtility.ExcelFileUtility;
import vTigerGenericUtility.JavaUtility;
import vTigerGenericUtility.PropertyFileUtility;
import vTigerGenericUtility.WebDriverUtility;

public class CreateContactWithOrganisationTest {
	
	@Test
	public void createContactWithOrganizationTest() throws IOException, InterruptedException {
		//Step 1: Creating the objects for utilities
		WebDriverUtility wutil = new WebDriverUtility();
		ExcelFileUtility eutil = new ExcelFileUtility();
		PropertyFileUtility putil = new PropertyFileUtility();
		JavaUtility jutil = new JavaUtility();
		
		//Step 2: Read all the necessary data from excel and property files
		String URL = putil.readDataFromProperties("url");
		String USERNAME = putil.readDataFromProperties("username");
		String PASSWORD = putil.readDataFromProperties("password");
		String BROWSER = putil.readDataFromProperties("browser");
		
		String ORGNAME = eutil.readDataFromExcel("Organisation", 1, 2);
		String CONTACT = eutil.readDataFromExcel("Contacts", 1, 2);
		
		//Step 3: launch the browser 
		//WebDriver driver = new ChromeDriver();
		WebDriver driver = null;
		if(BROWSER.equalsIgnoreCase("Chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("Edge"))
		{
			driver = new EdgeDriver();
		}
		else
		{
			System.out.println("Invalid Browser");
		}
		driver.get(URL);
	   wutil.maximizeWindow(driver);
	   wutil.waitForPage(driver);
		//Step 4: Login to the application
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		//Step 5: Click on Organization Link
		driver.findElement(By.linkText("Organizations")).click();
		
		//Step 6: Click on create organization lookup icon
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		
		//Step 7: Create Organization with mandatory fields
		driver.findElement(By.name("accountname")).sendKeys(ORGNAME+jutil.getRandomNumber());
		
		//Step 8: Save the details
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//Step 9: Validate the Organization
		String orgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(orgHeader.contains(ORGNAME))
		{
			System.out.println(orgHeader+"Organization created");
		}
		else
		{
			System.out.println("Organisation not created");
		}
		
		Thread.sleep(3000);
		//Step 9: Click on Contacts link
		driver.findElement(By.linkText("Contacts")).click();
		//Step 10: Click on create Contacts lookup icon
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		
		//Step 11: create contact with mandatory fields
		driver.findElement(By.name("lastname")).sendKeys(CONTACT);
		
		//Step 12: Click on Organization look up image
		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img[@src='themes/softed/images/select.gif']")).click();
		
		//Step 13: Switch to child window
		wutil.switchWindow(driver, "Accounts");
		
		//Step 14: Search for the orgname
		driver.findElement(By.name("search_text")).sendKeys(ORGNAME);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.linkText(ORGNAME)).click();
		
		//Step 15: select the control back to the parent window and save
		wutil.switchWindow(driver, "Contacts");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//Step 16: Verification of contact
		String ContHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(ContHeader.contains(CONTACT))
		{
			System.out.println(ContHeader+"---Pass");
		}
		else
		{
			System.out.println("Fail");
		}
		
		//Step 17: Logout of the application
	WebElement element = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
//		Actions act = new Actions(driver);
//		act.moveToElement(element).perform();
		wutil.moveToTheElement(driver, element);
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();
	}
}
