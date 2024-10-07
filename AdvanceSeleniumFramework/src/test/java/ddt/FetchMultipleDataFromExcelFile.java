package ddt;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FetchMultipleDataFromExcelFile {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
	     
		FileInputStream	fis=new	FileInputStream("./src/test/resources/ExcelMultipledata.xlsx");
		
		Workbook book = WorkbookFactory.create(fis);

		      Sheet sheet = book.getSheet("Sheet1");
		    
		      int rowNum=sheet.getLastRowNum();
		      System.out.println(rowNum);
		      
		      for(int i=0;i<rowNum;i++) {
		    	       Row row = sheet.getRow(i);
		     for(int j=0;j<row.getLastCellNum();j++) {
		    	    	 Cell cell = row.getCell(j);
		    	    	String links= cell.getStringCellValue();
		    	    	System.out.println(links);
		    	       }
		      }
	}

}
