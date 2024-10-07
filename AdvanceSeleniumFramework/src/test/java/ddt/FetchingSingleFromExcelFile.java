package ddt;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchingSingleFromExcelFile {

	public static void main(String[] args) throws Throwable, Throwable {
		
		FileInputStream	fis=new	FileInputStream("./src/test/resources/ExcelDataAd.xlsx");
		
	Workbook book = WorkbookFactory.create(fis);

	      Sheet sheet = book.getSheet("Sheet1");
	       //Row row = sheet.getRow(3);
	      Row row = sheet.getRow(4);
	   //   Cell cell = row.getCell(3);
	
	               Cell cell1 = row.getCell(3);
	      //      String excelData = cell.getStringCellValue();
	       //     System.out.println(excelData);
	             double exceldata = cell1.getNumericCellValue();
	           System.out.println(exceldata);
	              
	           //DataFormatter
	             DataFormatter format=new  DataFormatter();
	           String excelData1 =format.formatCellValue(cell1);
	           System.out.println(excelData1);
	}

	
}
