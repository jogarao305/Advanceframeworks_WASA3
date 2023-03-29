package practise;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PractiseDataProvider {
	
	@Test(dataProvider = "phones")
	public void data(String phone, int price)
	{
		System.out.println(phone+" " + price);
	}
	
	@DataProvider(name = "phones")
	public Object[][] getData()
	{
		Object[][] data = new Object[3][2];
		
		data[0][0] = "redmi";
		data[0][1] = 15000;
		
		data[1][0] = "samsung";
		data[1][1] = 18000;
		
		data[2][0] = "vivo";
		data[2][1] = 12500;
		
		return data;
	}
	
}
