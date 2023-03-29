package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vTigerGenericUtility.WebDriverUtility;

public class CreateOrganization extends WebDriverUtility {
	@FindBy(name = "accountname")
	private WebElement orgnameEdt;
	
	@FindBy(name = "industry")
	private WebElement industryType;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(name = "accounttype")
	private WebElement typeDropdown;
	
	public CreateOrganization(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getIndustryType() {
		return industryType;
	}

	public WebElement getOrgnameTxt() {
		return orgnameEdt;
	}

	public WebElement getTypeDropdown() {
		return typeDropdown;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	//create Business libraries for the organization
	/**
	 * this method creates new organization
	 * @param orgname
	 */
	public void createOrgPage(String orgname)
	{
		orgnameEdt.sendKeys(orgname);
		saveBtn.click();
	}
	
	/**
	 * This method creates new organization with industry dropdown
	 * @param orgname
	 * @param industryName
	 */
	public void createOrgPage(String orgname, String industryName)
	{
		orgnameEdt.sendKeys(orgname);
		dropdownHandling(industryName, industryType);
		//dropdownHandling(typedropdown, typeDropdown);
		saveBtn.click();
	}
	
	public void createOrpPage(String orgname, String industryName, String typedropdown)
	{
		orgnameEdt.sendKeys(orgname);
		dropdownHandling(industryName, industryType);
		dropdownHandling(typedropdown, typeDropdown);
		saveBtn.click();
	}
}
