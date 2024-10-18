package product;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import genericutility.WebDriver_Utility;
import objectRepo.DeletePrdName;

public class CreateProduct {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis = new FileInputStream("./src/test/resources/Advacedata.properties");
		Properties pro  = new Properties();
		pro.load(fis);
		
		String BROWSER = pro.getProperty("browser");
	String URL=pro.getProperty("url");
	String USERNAME = pro.getProperty("username");
	String PASSWORD = pro.getProperty("password");
	
	WebDriver driver;
	if(BROWSER.equalsIgnoreCase("chrome")) {
		driver= new ChromeDriver();
	}
	else if(BROWSER.equalsIgnoreCase("edge")) {
		driver=new EdgeDriver();
	}
	else if(BROWSER.equalsIgnoreCase("firefox")) {
		driver=new FirefoxDriver();
	}
	else {
		driver=new ChromeDriver();
	}
	driver.get(URL);
	driver.findElement(By.cssSelector("[name='user_name']")).sendKeys(USERNAME);
	driver.findElement(By.cssSelector("[name='user_password']")).sendKeys(PASSWORD);
	driver.findElement(By.id("submitButton")).click();
	driver.findElement(By.linkText("Products")).click();
	driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
	 Random ran=new Random();
	 int ranNum=ran.nextInt(1000);
	FileInputStream	fis1=new	FileInputStream("./src/test/resources/ExcelMultipledata.xlsx");
	
	Workbook book = WorkbookFactory.create(fis1);

	      Sheet sheet = book.getSheet("Product");
	      Row row = sheet.getRow(2);
	      Cell cell = row.getCell(2);
	     String PrdName = cell.getStringCellValue()+ranNum ;
	       driver.findElement(By.name("productname")).sendKeys(PrdName);
	       Row row1 = sheet.getRow(0);
		      Cell cell1 = row1.getCell(0);
		      DataFormatter format=new  DataFormatter();
	           String PartNo =format.formatCellValue(cell1);
	       driver.findElement(By.id("productcode")).sendKeys(PartNo);
	       WebElement ele = driver.findElement(By.name("productcategory"));
	       Select sc= new Select(ele);
	       sc.selectByValue("Software");
	       driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click()  ;
	   	Thread.sleep(2000);
	   	   String actData = driver.findElement(By.xpath("//span[@id='dtlview_Product Name']")).getText();
	   	if(actData.contains(PrdName)) {
			System.out.println("Product  name is created");
		}
		else {
			System.out.println("Product  name is not created");
		}
	/*  	DeletePrdName dpn= new DeletePrdName(driver);
		
	//	WebDriver_Utility wlib= new WebDriver_Utility();
	//	wlib.alertAccept(driver);
		dpn.clickPrdName(driver, PrdName);
	  //	dpn.clickPrdName(driver, PrdName);
	  	dpn.clickOnDeleteButton();
	  	WebDriver_Utility wlib= new WebDriver_Utility();
			wlib.alertAccept(driver);
	  	
	   dpn.validatePrdDeleted(driver, PrdName);	*/
	//	driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
	//	driver.findElement(By.linkText("Sign Out")).click();
		
	   	
	   	
	   	
	}

}
