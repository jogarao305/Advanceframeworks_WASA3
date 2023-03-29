package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {
	
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement OrgHeaderText;
	
	@FindBy(xpath = "//span[@id='dtlview_Industry']")
	private WebElement IndHeaderText;
	
	@FindBy(xpath = "//span[@id='dtlview_Type']")
	private WebElement TypeHeaderText;
	
	public OrganizationInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrgHeaderText() {
		return OrgHeaderText;
	}

	public WebElement getIndHeaderText() {
		return IndHeaderText;
	}

	public WebElement getTypeHeaderText() {
		return TypeHeaderText;
	}

	//Business Library
	/**
	 * This method will capture the text from the orgheader  and return it caller
	 * @return
	 */
	public String orgHeader()
	{
		return OrgHeaderText.getText();
	}
	
	public String industryHeader()
	{
		return IndHeaderText.getText();
	}
	
	public String typeheader()
	{
		return TypeHeaderText.getText();
	}

}
