package practise;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vTiger.ObjectRepository.CreateOrganization;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.OrganizationInfoPage;
import vTiger.ObjectRepository.OrganizationPage;
import vTigerGenericUtility.BaseClass;
@Listeners(vTigerGenericUtility.ListenersImplementation.class)
public class CreateNewOrgTest extends BaseClass {
	
	@Test(groups = "SmokeSuite")
	public void createOrganisationTest() throws EncryptedDocumentException, IOException  {
	
		String ORGNAME = eutil.readDataFromExcel("Organisation", 4, 2);
		//Step 3:Navigate to Organizations Link
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationLink();
		//Step 4:Click on create organization look up image
		OrganizationPage op = new OrganizationPage(driver);
		op.clickCreateOrgPage();
		//step 5: create organization with mandatory fields and save
	   CreateOrganization cop = new CreateOrganization(driver);
	   cop.createOrgPage(ORGNAME+jutil.getRandomNumber());
		//step 6: verification for organization
	   OrganizationInfoPage oinf = new OrganizationInfoPage(driver);
		String headertag = oinf.orgHeader();
		Assert.assertTrue(headertag.contains(ORGNAME));
		System.out.println(ORGNAME+" ---Organisation created");
	}
}
