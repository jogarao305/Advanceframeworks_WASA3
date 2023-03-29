package practise;

import java.io.FileInputStream;
import java.util.Properties;

public class Properties_file {
	public static void main(String[] args) throws Exception  {
		
		FileInputStream fis = new FileInputStream("./src/test/resources/CommonData.properties");
		Properties pobj = new Properties();
		pobj.load(fis);
		
		String URL = pobj.getProperty("url");
		String USERNAME = pobj.getProperty("username");
		String PASSWORD = pobj.getProperty("password");
		String BROWSER = pobj.getProperty("browser");
	}
}
