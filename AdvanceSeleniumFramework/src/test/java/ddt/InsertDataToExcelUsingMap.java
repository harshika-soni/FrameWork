package ddt;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;



public class InsertDataToExcelUsingMap {

	

	public static void main(String[] args) throws Throwable, Throwable {
	
FileInputStream	fis=new	FileInputStream("./src/test/resources/ExcelDataAd.xlsx");
                Workbook book = WorkbookFactory.create(fis);
                
              Sheet sheet = book.getSheet("Sheet2");
              LinkedHashMap<String,String>  map= new  LinkedHashMap<String,String>();
              
	
              map.put("10", "shobha");
      		map.put("20", "rani");

      		int rowNum = 0;
      		for (Entry<String, String> m:map.entrySet()) {
      			Row row = sheet.createRow(rowNum++);
      			row.createCell(0).setCellValue((String) m.getKey());
      			row.createCell(1).setCellValue((String) m.getValue());
      		}
              FileOutputStream fos = new FileOutputStream("./src/test/resources/ExcelDataAd.xlsx");
      		book.write(fos);
      		book.close();
	
      	
	
	}
	}