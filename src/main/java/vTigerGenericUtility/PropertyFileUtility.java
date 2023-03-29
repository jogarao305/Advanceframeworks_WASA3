package vTigerGenericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * This class consists of generic methods to read data from property file
 * @author Jogarao G
 *
 */

public class PropertyFileUtility {
	/**
	 * 
	 * @param data
	 * @return
	 * @throws IOException
	 */
	public String readDataFromProperties(String data) throws IOException
	{
		FileInputStream fis = new FileInputStream(IconstantUtility.PropertiesFilePath);
		Properties pobj = new Properties();
		pobj.load(fis);
		String value = pobj.getProperty(data);
		return value;
	}
}
