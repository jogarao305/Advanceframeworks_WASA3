package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vTigerGenericUtility.WebDriverUtility;

public class HomePage extends WebDriverUtility {
	
	@FindBy(xpath = "//img[@src='themes/softed/images/Home.PNG']")
	private WebElement HomePg;
	
	@FindBy(linkText = "Organizations")
	private WebElement orgLink;
	
	@FindBy(linkText = "Contacts")
	private WebElement contactLink;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement AdminstratorImg;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signoutBtn;
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getHomePg() {
		return HomePg;
	}

	public WebElement getOrgaLink() {
		return orgLink;
	}

	public WebElement getContactLink() {
		return contactLink;
	}
	
	public WebElement getAdminstratorImg() {
		return AdminstratorImg;
	}

	public WebElement getSignoutBtn() {
		return signoutBtn;
	}

	public void clickOnOrganizationLink()
	{
		orgLink.click();
	}
	
	public void clickonContactsLink()
	{
		contactLink.click();
	}
	
	public void signOut(WebDriver driver)
	{
		moveToTheElement(driver, AdminstratorImg);
		signoutBtn.click();
	}
	
	
}
