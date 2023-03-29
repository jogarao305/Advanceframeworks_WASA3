package practise;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vTiger.ObjectRepository.CreateOrganization;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.OrganizationInfoPage;
import vTiger.ObjectRepository.OrganizationPage;
import vTigerGenericUtility.BaseClass;

@Listeners(vTigerGenericUtility.ListenersImplementation.class)
public class CreateMultipleOrgWithIndustryTest extends BaseClass {
	
	@Test(dataProvider = "getData")
	public void createMultipleOrgWithTest(String org, String INDUSTRY)
	{
		String ORGNAME = org+jutil.getRandomNumber();
		
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationLink();
		
		OrganizationPage op = new OrganizationPage(driver);
		op.clickCreateOrgPage();
		
		CreateOrganization corg = new CreateOrganization(driver);
		corg.createOrgPage(ORGNAME, INDUSTRY);
		
		OrganizationInfoPage oinf = new OrganizationInfoPage(driver);
		String OrgHeader = oinf.orgHeader();
		Assert.assertTrue(OrgHeader.contains(ORGNAME));
	}
	
	@DataProvider
	public Object[][] getData() throws EncryptedDocumentException, IOException
	{
		Object[][] data = eutil.readMultipleData("Multiple");
		return data;
		
	}

}
