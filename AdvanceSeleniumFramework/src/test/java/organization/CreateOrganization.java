package organization;

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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import genericutility.Excel_Utility;
import genericutility.File_Utility;
import genericutility.Java_Utility;
import genericutility.WebDriver_Utility;
import objectRepo.VTigerLoginPage;

public class CreateOrganization {

	public static void main(String[] args) throws Throwable {
		/*
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
	driver.get(URL);*/
		
		WebDriver driver= new ChromeDriver();	
		WebDriver_Utility wlib= new WebDriver_Utility();
		 File_Utility flib= new File_Utility();  
		 Java_Utility jlib= new Java_Utility();
		 Excel_Utility elib= new Excel_Utility();
		 int ranNum=jlib.getRandomNum();
	      wlib.windowMaximize(driver);
               
                  String URL = flib.getKeyAndValuePair("url")  ;  	
        		  String USERNAME = flib.getKeyAndValuePair("username");
        	  String PASSWORD = flib.getKeyAndValuePair("password");
        		  
        	  driver.get(URL);
        	   //Reading Data using getter methods
              VTigerLoginPage login= new VTigerLoginPage(driver);
              login.getUserTextField().sendKeys(USERNAME);
              login.getPasswordTextField().sendKeys(PASSWORD);
              login.getLoginButton().click();
              
              //Business logic
        //      VTigerLoginPage login = new VTigerLoginPage(driver);
          //    login.loginToVtiger(USERNAME, PASSWORD);
	//driver.findElement(By.cssSelector("[name='user_name']")).sendKeys(USERNAME);
//	driver.findElement(By.cssSelector("[name='user_password']")).sendKeys(PASSWORD);
//	driver.findElement(By.id("submitButton")).click();
	 driver.findElement(By.linkText("Organizations")).click();
	 driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
	 Random ran=new Random();
	 int ranNum1=ran.nextInt(1000);
	FileInputStream	fis1=new	FileInputStream("./src/test/resources/ExcelMultipledata.xlsx");
		
		Workbook book = WorkbookFactory.create(fis1);

		      Sheet sheet = book.getSheet("Organization");
		      Row row = sheet.getRow(0);
		      Cell cell = row.getCell(0);
		
	                          String OrgName = cell.getStringCellValue()+ranNum1;
	    System.out.println(OrgName);
		      driver.findElement(By.name("accountname")).sendKeys(OrgName);
		
		       Row row1 = sheet.getRow(1);
			      Cell cell1 = row1.getCell(1);
			  DataFormatter format=new  DataFormatter();
		           String phnNum =format.formatCellValue(cell1);
		           driver.findElement(By.id("phone")).sendKeys(phnNum);
		          Row row2 = sheet.getRow(2);
			      Cell cell2= row2.getCell(0);
			    String email=format.formatCellValue(cell2);
			    driver.findElement(By.id("email1")).sendKeys(email);
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click()  ;
	Thread.sleep(2000);
	String actData=driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();
	if(actData.contains(OrgName)) {
		System.out.println("organisation name is created");
	}
	else {
		System.out.println("organisation name is not created");
	}
	driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
	driver.findElement(By.linkText("Sign Out")).click();
	
	
	
	}

}
