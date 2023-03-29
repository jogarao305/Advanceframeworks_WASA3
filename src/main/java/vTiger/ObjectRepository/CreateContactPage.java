package vTiger.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vTigerGenericUtility.WebDriverUtility;

public class CreateContactPage extends WebDriverUtility {
	
	@FindBy(name = "lastname")
	private WebElement lastNameEdt;
	
	@FindBy(xpath = "//input[@name='account_name']/following-sibling::img[@src='themes/softed/images/select.gif']")
	private WebElement orglookup;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(name = "search_text")
	private WebElement searchEdt;
	
	@FindBy(name = "search")
	private WebElement searchBtn;
	
	
	public CreateContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getLastNameEdt() {
		return lastNameEdt;
	}
	
	public WebElement getOrglookup() {
		return orglookup;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public WebElement getSearchEdt() {
		return searchEdt;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	//libraries for contact page
	/**
	 * 
	 * @param driver
	 * @param contName
	 * @param Orgname
	 */
	public void createNewConatct(WebDriver driver,String contName, String Orgname) {
		lastNameEdt.sendKeys(contName);
		orglookup.click();
		switchWindow(driver, "Accounts");
		searchEdt.sendKeys(Orgname);
		searchBtn.click();
		driver.findElement(By.xpath("//a[text()='"+Orgname+"']")).click();
		switchWindow(driver, "Contacts");
		saveBtn.click();
	}
	
	public void createNewContact(String contName)
	{
		lastNameEdt.sendKeys(contName);
		saveBtn.click();
	}
}


