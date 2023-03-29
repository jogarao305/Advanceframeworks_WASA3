package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
/**
 * Author Jogarao
 */
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {  //Step 1: Create a pom class for each webpage
	
	//Step 2: Identify the WebElements with the help of @FindBy, @FIndAll, @FindBys
	@FindBy(name = "user_name")
	private WebElement UsernameEdt;
	
	@FindAll({@FindBy(name = "user_password"), @FindBy(xpath = "//input[@type='password']")})
	private WebElement PasswordEdt;
	
	@FindBy(id = "submitButton")
	private WebElement SubmitBtn;
   //Step 3: create a constructor to initialize the WebElements
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
   //Step 4: provide getters to access the webelements 
	public WebElement getUsernameEdt() {
		return UsernameEdt;
	}

	public WebElement getPasswordEdt() {
		return PasswordEdt;
	}

	public WebElement getSubmitBtn() {
		return SubmitBtn;
	}
	
	//Business libraries - generic methods specific to current project
	
	public void loginToApp(String username, String password)
	{
		UsernameEdt.sendKeys(username);
		PasswordEdt.sendKeys(password);
		SubmitBtn.click();
	}
	
}
