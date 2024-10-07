package campaign;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import genericutility.Excel_Utility;
import genericutility.File_Utility;
import genericutility.Java_Utility;
import genericutility.WebDriver_Utility;
import objectRepo.VTigerHomePage;
import objectRepo.VTigerLoginPage;

public class CreateCampaignWithProduct {

	public static void main(String[] args) throws Throwable {
		
		WebDriver driver=new ChromeDriver();
		WebDriver_Utility wlib= new WebDriver_Utility();
		 File_Utility flib= new File_Utility();  
		 Java_Utility jlib= new Java_Utility();
		 int ranNum=jlib.getRandomNum();
	      wlib.windowMaximize(driver);
             
	/*	FileInputStream fis = new FileInputStream("./src/test/resources/Advacedata.properties");
		Properties pro=new Properties();
		pro.load(fis);
		           String URL = pro.getProperty("url");
		         String USERNAME = pro.getProperty("username");
		         String PASSWORD = pro.getProperty("password");
		         
		         driver.get(URL);*/
             String URL=    flib.getKeyAndValuePair("url");
          String USERNAME  = flib.getKeyAndValuePair("username");
           String  PASSWORD=  flib.getKeyAndValuePair("password");
	             driver.get(URL);
	             //Reading Data using getter methods
	                         VTigerLoginPage login= new VTigerLoginPage(driver);
	                         login.getUserTextField().sendKeys(USERNAME);
	                         login.getPasswordTextField().sendKeys(PASSWORD);
	                         login.getLoginButton().click();
	                         
	                         //Business logic
	                   //      VTigerLoginPage login = new VTigerLoginPage(driver);
	                     //    login.loginToVtiger(USERNAME, PASSWORD);
  //     driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		      //    driver.findElement(By.name("user_password")).sendKeys(PASSWORD) ;
		        //  driver.findElement(By.id("submitButton")).click();
	                         VTigerHomePage vhp= new VTigerHomePage(driver);
	                         vhp.getProductlink().click();
	//	  driver.findElement(By.linkText("Products")) .click();
		  driver.findElement(By.cssSelector("[title='Create Product...']")).click();
		Excel_Utility elib= new Excel_Utility();
		String ProductName = elib.getExcelData("Product", 2, 2)+ranNum;
//FileInputStream fis1= new FileInputStream("./src/test/resources/ExcelMultipledata.xlsx");
  //                   Workbook book = WorkbookFactory.create(fis1);
    //               Sheet sheet = book.getSheet("Product");
      //                         Row row = sheet.getRow(2);
        //                              Cell cell = row.getCell(2);
                 //                 String ProductName = cell.getStringCellValue()+ranNum;
                                     System.out.println(ProductName);
                                     driver.findElement(By.name("productname")).sendKeys(ProductName);
	      driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click(); 
	      WebElement morelink = driver.findElement(By.linkText("More"));
	  //    Actions act=new Actions(driver);
	    //  act.moveToElement(morelink).perform();
	      wlib.moveToElement(driver, morelink);
	      VTigerHomePage vhp1=new  VTigerHomePage(driver);
	      vhp1.getCampaignlink().click();
	  //    driver.findElement(By.linkText("Campaigns")).click();
	      driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
	      Random ran1=new Random();
	 	 int ranNum1=ran1.nextInt(1000);
	 	 String campName	= elib.getExcelData("Campaign",0 , 0)+ranNum1;
	 	//	FileInputStream	fis2=new	FileInputStream("./src/test/resources/ExcelMultipledata.xlsx");
	 		//		Workbook book1 = WorkbookFactory.create(fis2);

	 		  //    Sheet sheet1 = book1.getSheet("Campaign").
	 		    //  Row row1= sheet1.getRow(0);
	 		      //Cell cell1 = row1.getCell(0);
	 		   //  String campName = cell1.getStringCellValue() +ranNum1;
	 		     System.out.println(campName);
	 		       driver.findElement(By.name("campaignname")).sendKeys(campName);
	 		    
	 		     //window switching
	 		driver.findElement(By.xpath("//img[@alt='Select']")).click();
	 		     Set<String> allWind = driver.getWindowHandles();
	 		                           Iterator<String> it = allWind.iterator();    
	 		                           while(it.hasNext()) {
	 		                        	  String win = it.next();
	 		                        	  driver.switchTo().window(win);
	 		                        	 String title = driver.getTitle();
	 		               if(title.contains("Products&action")) {
	 		            	   break;
	 		               }
	 		            }
	 		  driver.findElement(By.name("search_text")).sendKeys(ProductName) ;
	 		  driver.findElement(By.name("search")).click();
	 		  //dynamic Xpath
	 		  driver.findElement(By.xpath("//a[text()='"+ProductName+"']")).click();
	 		//driver switching back to main window
	 		 Set<String> allWind1 = driver.getWindowHandles();
              Iterator<String> it1 = allWind1.iterator();    
              while(it1.hasNext()) {
           	  String win1 = it1.next();
           	  driver.switchTo().window(win1);
           	 String title = driver.getTitle();
  if(title.contains("Campaigns&action")) {
	   break;
  }
}
              driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click()  ;       

	}

}
