package practise;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vTiger.ObjectRepository.ContactInfoPage;
import vTiger.ObjectRepository.ContactsPage;
import vTiger.ObjectRepository.CreateContactPage;
import vTiger.ObjectRepository.HomePage;
import vTigerGenericUtility.BaseClass;

@Listeners(vTigerGenericUtility.ListenersImplementation.class)
public class CreateContactTest extends BaseClass {
	
	@Test(groups = "SmokeSuite")
	public void createContactTest() throws Exception {
		
		String contact = eutil.readDataFromExcel("Contacts", 1, 2);
		
		//Step 4:Navigate to Contacts Link
         HomePage hp = new HomePage(driver);
         hp.clickonContactsLink();
		//Step 5:Click on create Contacts look up image
		ContactsPage cp = new ContactsPage(driver);
		cp.contactPage();
		CreateContactPage cpg = new CreateContactPage(driver);
		cpg.createNewContact(contact+jutil.getRandomNumber());
		//Step 7:verification for Contact
		ContactInfoPage cinf = new ContactInfoPage(driver);
		String actual = cinf.getOrgHeader();
		Assert.assertTrue(actual.contains(contact));
		System.out.println(actual+"---Contact created");
	}
}
