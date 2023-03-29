package practise;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vTiger.ObjectRepository.CreateOrganization;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.OrganizationInfoPage;
import vTiger.ObjectRepository.OrganizationPage;
import vTigerGenericUtility.BaseClass;

@Listeners(vTigerGenericUtility.ListenersImplementation.class)
public class CreateOrgWithIndustryTest extends BaseClass {
	
    @Test(groups = "RegressionSuite")
	public void createOrgwithIndustry() throws Exception {
	
		String ORGNAME = eutil.readDataFromExcel("Organisation", 4, 2);
		String Industry = eutil.readDataFromExcel("Organisation", 4, 3);
		//step 3: navigate to organization link
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationLink();
		//Step 4:Click on create organization look up image
		OrganizationPage opg = new OrganizationPage(driver);
		opg.clickCreateOrgPage();
		//step 5: Create Organization name and select Chemicals in the industry dropdown
		CreateOrganization corg = new CreateOrganization(driver);
		corg.createOrgPage(ORGNAME+jutil.getRandomNumber(), Industry);
		//step 6: verification of organization and industry type
		OrganizationInfoPage oinf = new OrganizationInfoPage(driver);
		String header = oinf.orgHeader();
		String industrytype = oinf.industryHeader();
		Assert.assertTrue(header.contains(ORGNAME));
		Assert.assertTrue(industrytype.contains(Industry));
		System.out.println(ORGNAME+" "+ Industry + "---organisation with industry created");
	}
    
    @Test
    public void demoScript()
    {
    	System.out.println("demo");
    	Assert.fail();
    }
    
    @Test
    public void regional()
    {
    	System.out.println("regression test case");
    }
    
}
