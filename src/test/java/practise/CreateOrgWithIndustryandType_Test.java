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
public class CreateOrgWithIndustryandType_Test extends BaseClass {
	
	@Test(groups = "RegressionSuite")
	public  void createOrgWithIndustryandtype() throws EncryptedDocumentException, IOException {
		String ORGNAME = eutil.readDataFromExcel("Organisation", 4, 2);
		String Industry = eutil.readDataFromExcel("Organisation", 4, 3);
		String TYPE = eutil.readDataFromExcel("Organisation", 7, 4);
		//step 3: navigate to organization link
		HomePage hp =new HomePage(driver);
		hp.clickOnOrganizationLink();
		//Step 4:Click on create organization look up image
		OrganizationPage op = new OrganizationPage(driver);
		op.clickCreateOrgPage();
		//step 5: create organization name and select industry dropdown and type dropdown
         CreateOrganization corg = new CreateOrganization(driver);
         corg.createOrpPage(ORGNAME+jutil.getRandomNumber(), Industry, TYPE);
		//step 6: verification of industry,type and organization
         OrganizationInfoPage oinf = new OrganizationInfoPage(driver);
		String orgheader = oinf.orgHeader();
		String ind = oinf.industryHeader();
		String type= oinf.typeheader();
		Assert.assertTrue(orgheader.contains(ORGNAME));
		Assert.assertTrue(ind.contains(Industry));
		Assert.assertTrue(type.contains(TYPE));
		System.out.println(ORGNAME+"\n"+Industry+"\n"+TYPE+ "-----created");
	}
}
