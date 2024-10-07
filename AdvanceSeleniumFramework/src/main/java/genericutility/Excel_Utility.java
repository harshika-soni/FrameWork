package genericutility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Utility{
	/*
	 * It is used to read  data from excel
	 * @param sheetName
	 * @param cellNum
	 * @return
	 * @throws Throwable
	 * @author Harshika
	 */
	
	public  String getExcelData(String sheetName,int rowNum,int cellNum) throws Throwable {
	
	FileInputStream	fis=new	FileInputStream(IPathConstant.Excelpath);
	
	Workbook book = WorkbookFactory.create(fis);

    Sheet sheet = book.getSheet(sheetName);
    Row row = sheet.getRow(rowNum);
    Cell cell = row.getCell(cellNum);
   String ranNum;
	String ExcelData = cell.getStringCellValue() ;
	return ExcelData;
		}
	
	public String getExcelDataUsingDataformatter(String sheetName,int rowNum,int cellNum) throws EncryptedDocumentException, IOException {

		FileInputStream	fis=new	FileInputStream(IPathConstant.Excelpath);
		
		Workbook book = WorkbookFactory.create(fis);

		      Sheet sheet = book.getSheet(sheetName);
		      Row row = sheet.getRow(rowNum);
		      Cell cell = row.getCell(cellNum);
		     DataFormatter format= new DataFormatter();
			String ExcelData = format.formatCellValue(cell);
			return ExcelData;
	}
	public Object[][] getDataProviderData(String sheetName) throws Throwable
	{
		Java_Utility jlib= new Java_Utility();
		 int ranNum=jlib.getRandomNum();
		FileInputStream fis = new FileInputStream("./src/test/resources/ExcelMultipledata.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet(sheetName);
		int lastRow = sheet.getLastRowNum()+1;
		int lastCell = sheet.getRow(0).getLastCellNum();
		
		Object[][] objArr = new Object[lastRow][lastCell];
		
		for (int i = 0; i <lastRow ; i++)
		{
		for (int j = 0; j <lastCell ; j++)
		{
			objArr[i][j]=sheet.getRow(i).getCell(j).toString()+ranNum;
			
		}	
		}
		
		return objArr;
		
	
}
}
