package vTigerGenericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class consists of generic methods to read data from excel files
 * @author Jogarao G
 *
 */

public class ExcelFileUtility {
	/**
	 * This method will read values from sheet based on row and cell value
	 * @param sheet
	 * @param row
	 * @param col
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String readDataFromExcel(String sheetname, int row, int col) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(IconstantUtility.ExcelFilePath);
		Workbook book = WorkbookFactory.create(fis);
		Sheet data = book.getSheet(sheetname);
		DataFormatter df = new DataFormatter();
		String values = df.formatCellValue(data.getRow(row).getCell(col));
		book.close();
		return values;
	}
	/**
	 * This method will give the total rows utilized
	 * @param sheet
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public int getRowCount(String sheet) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(IconstantUtility.ExcelFilePath);
		Workbook book = WorkbookFactory.create(fis);
		Sheet sh = book.getSheet(sheet);
		int count = sh.getLastRowNum();
		book.close();
		return count;
	}
	/**
	 * This method will write the data into the excel sheet
	 * @param sheet
	 * @param row
	 * @param col
	 * @param data
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void writeDataIntoExcel(String sheet, int row, int col, String data) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(IconstantUtility.ExcelFilePath);
		Workbook book = WorkbookFactory.create(fis);
		Row val = book.getSheet(sheet).getRow(row);
		val.createCell(col).setCellValue(data);
		FileOutputStream fos = new FileOutputStream(IconstantUtility.ExcelFilePath);
		book.write(fos);
		System.out.println(data+" ---->data added");
		book.close();
	}
	
	/**
	 * This method is going to create organization with multiple industry
	 * @param SheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	public Object[][] readMultipleData(String SheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(IconstantUtility.ExcelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		int lastRow = sh.getLastRowNum();
	    int lastCel = sh.getRow(0).getLastCellNum();
	    
	    Object[][] data= new Object[lastRow][lastCel];
	    
	    for(int i=0;i<lastRow;i++)
	    {
	    	for(int j=0;j<lastCel;j++)
	    	{
	    		data[i][j] = sh.getRow(i+1).getCell(j).getStringCellValue();
	    	}
	    }
	    
	    return data;
	}
	
	
	
	
	
	
	
	
}
