package practise;

import java.io.IOException;

import vTigerGenericUtility.ExcelFileUtility;
import vTigerGenericUtility.JavaUtility;
import vTigerGenericUtility.PropertyFileUtility;

public class Genericutilitytesting {
	public static void main(String[] args) throws IOException {
		
		/*ExcelFileUtility eutil = new ExcelFileUtility();
		String dat = eutil.readDataFromExcel("Organisation", 1, 2);
		System.out.println(dat);
		System.out.println(eutil.getRowCount("Organisation"));
		
		eutil.writeDataIntoExcel("Organisation", 3, 4, "pradeep");*/
		
		JavaUtility j = new JavaUtility();
		System.out.println(j.getSystemDate());
		System.out.println(j.getSystemDateInFormat());
		System.out.println(j.getRandomNumber());
		
		String str = "welcome";
		char[] ch=str.toCharArray();
		int count = 0;
		for(int i=0;i<ch.length;i++)
		{
			if(ch[i]=='a' || ch[i]=='e' || ch[i]=='i' || ch[i]=='o' || ch[i]=='u')
			{
				count++;
			}
		}
		if(count>=1)
			System.out.println("vowels are there in String" +"\n"+ "Count of vowels in given String---->" + count);
		
		for(int i=1;i<=10;i++)
		{
			if(i%2==0 && i%3==0)
			{
				continue;
			}	
			System.out.print(i + " ");
		}
		
		int ar[] = {1,2,3,4,5,6};
		int even_count =0, odd_count=0;
		for(int i=0;i<ar.length;i++)
		{
			if(ar[i]%2==0)
			{
				even_count++;
			}
			else
			{
				odd_count++;
			}
		}
		
		System.out.println("even count :-- " + even_count + "\n" +"odd count :--" + odd_count);
//		int count = 0;
//		for(int i=0;i<str.length();i++) {
//			char ch = str.charAt(i);
//			if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u')
//			{
//				count++;
//			}
//		}
//		if(count>=1)
//			System.out.println("vowels are there in given String" +"\n"+ "Count of vowels in given String---->" + count);
	}
}
