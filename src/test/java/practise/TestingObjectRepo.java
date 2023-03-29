package practise;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import vTiger.ObjectRepository.ContactInfoPage;
import vTiger.ObjectRepository.ContactsPage;
import vTiger.ObjectRepository.CreateContactPage;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.LoginPage;

public class TestingObjectRepo {
	public static void main(String[] args) {
	
//		WebDriver driver = new ChromeDriver();
//		driver.get("http://localhost:8888/");
//		LoginPage lp = new LoginPage(driver);
//		
//		lp.getUsernameEdt().sendKeys("admin");
//		lp.getPasswordEdt().sendKeys("admin");
//		lp.getSubmitBtn().click();
//		lp.loginToApp("admin", "admin");
		
//		HomePage hp = new HomePage(driver);
//		hp.getHomePg().click();
		
//		ContactsPage ct = new ContactsPage(driver);
//		ct.getContactPg().click();
		
//		CreateContactPage ctp = new CreateContactPage(driver);
//		ctp.getCreateContactpg().click();
		
//		ContactInfoPage ctf = new ContactInfoPage(driver);
//		ctf.getContactInfopg().click();
		
		String s1 = "java", s2 = " is", s3=" easy", s4=" to", s5=" learn";
		System.out.println(s1.concat(s2).concat(s3).concat(s4).concat(s5));
		
  } 
}
