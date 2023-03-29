package practiseTestNG;


import org.testng.annotations.Test;

public class PractiseTestNG {
	@Test(enabled = false)
	public void createUser()
	{
		System.out.println("create");
		//Assert.fail();
	}
	
	@Test(dependsOnMethods = "createUser")
	public void updateUser()
	{
		System.out.println("update");
	}
	
	@Test(dependsOnGroups = {"createUser", "updateUser"})
	public void deleteUser()
	{
		System.out.println("delete");
	}
}
