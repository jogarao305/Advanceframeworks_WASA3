package practiseTestNG;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vTiger.ObjectRepository.ContactInfoPage;
import vTiger.ObjectRepository.ContactsPage;
import vTiger.ObjectRepository.CreateContactPage;
import vTiger.ObjectRepository.CreateOrganization;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.OrganizationInfoPage;
import vTiger.ObjectRepository.OrganizationPage;
import vTigerGenericUtility.BaseClass;

@Listeners(vTigerGenericUtility.ListenersImplementation.class)
public class CreateContactwithOrgwithPOMTest extends BaseClass {
	
	@Test(groups = "RegressionSuite")
	public void createContactWithOrgwithPOMTest() throws IOException, InterruptedException {
		
		String ORGNAME = eutil.readDataFromExcel("Organisation", 1, 2);
		String CONTACT = eutil.readDataFromExcel("Contacts", 1, 2);
		
		//Step 4: click on the organization page link and click on organization look up icon 
		HomePage hmpg = new HomePage(driver);
		hmpg.clickOnOrganizationLink();
		Reporter.log("navigate to organization page successful");
		OrganizationPage orgpg = new OrganizationPage(driver);
		orgpg.clickCreateOrgPage();
		Reporter.log("click on create organization img successful");
		//Step 5: Create organization name with mandatory fields
		CreateOrganization cOrg = new CreateOrganization(driver);
		cOrg.createOrgPage(ORGNAME+jutil.getRandomNumber());
		Reporter.log("create organization successful");
		//Step 6: Verify Organization page
		OrganizationInfoPage oinf = new OrganizationInfoPage(driver);
		String orgHeader = oinf.orgHeader();
		Assert.assertTrue(orgHeader.contains(ORGNAME));
		System.out.println(ORGNAME+ "----organisation created");
		Reporter.log("organization verification succesful");
		
		//Thread.sleep(3000);
		//Step 7: Click on contacts page and contacts lookup icon
		hmpg.clickonContactsLink();
		ContactsPage cPage = new ContactsPage(driver);
		cPage.contactPage();
		//Assert.fail();
		Reporter.log("navigate to contacts page successful");
		//Step 8: Create contact with mandatory fields
		CreateContactPage cCpage = new CreateContactPage(driver);
		cCpage.createNewConatct(driver, CONTACT, ORGNAME);
		Reporter.log("create contact successful");
		//Step 9: Verify Contacts page
		ContactInfoPage cinf = new ContactInfoPage(driver);
		String contHeader = cinf.getOrgHeader();
		Assert.assertTrue(contHeader.contains(CONTACT));
		System.out.println(CONTACT+ "contact creted successfully");
		Reporter.log("contact verification successful");
	}
}
