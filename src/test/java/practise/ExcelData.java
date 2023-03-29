package practise;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelData {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/VtigerTC.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		
		String data = book.getSheet("Organisation").getRow(1).getCell(2).getStringCellValue();
		System.out.println(data);
	}
}
