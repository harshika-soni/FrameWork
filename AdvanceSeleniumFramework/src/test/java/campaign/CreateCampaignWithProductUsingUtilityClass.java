package campaign;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import genericutility.Excel_Utility;
import genericutility.File_Utility;
import genericutility.Java_Utility;
import genericutility.WebDriver_Utility;

public class CreateCampaignWithProductUsingUtilityClass {

	public static void main(String[] args) throws Throwable  {
	
		WebDriver driver= new ChromeDriver();
		File_Utility flib= new File_Utility();
		Excel_Utility elib= new Excel_Utility();
		Java_Utility jlib= new Java_Utility();
		WebDriver_Utility wlib= new WebDriver_Utility();
		
		  String URL = flib.getKeyAndValuePair("url")  ;  	
		  String USERNAME = flib.getKeyAndValuePair("username");
	  String PASSWORD = flib.getKeyAndValuePair("password");
		  
	  driver.get(URL);
	  driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	  driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	  driver.findElement(By.id("submitButton")).click();
	  
	  driver.findElement(By.linkText("Products")).click();
	  driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
	  int ranNum= jlib.getRandomNum();
	  
	          String ProductName = elib.getExcelData("Product", 2, 2)+ranNum;
	          System.out.println(ProductName);
	          driver.findElement(By.name("productname")).sendKeys(ProductName);
	              String PartNo = elib.getExcelDataUsingDataformatter("Product", 0, 0);
	              driver.findElement(By.name("productcode")).sendKeys(PartNo);
	              WebElement manufacturer = driver.findElement(By.xpath("//select[@name='manufacturer']"));
	              wlib.moveToElement(driver, manufacturer);
	              driver.findElement(By.xpath("//option[@value='LexPon Inc.']")).click();
	              driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click(); 
	           WebElement morelink = driver.findElement(By.linkText("More"));
	              wlib.moveToElement(driver,morelink );
	              driver.findElement(By.linkText("Campaigns")).click();
	    	      driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
	    	    String campData = elib.getExcelData("Campaign", 0, 0);
	    	    driver.findElement(By.name("campaignname")).sendKeys(campData);
	    	    System.out.println(campData);
	   	     //window switching
		 		driver.findElement(By.xpath("//img[@alt='Select']")).click();
		 		wlib.windowSwitching(driver, "Products&action");
		 		  driver.findElement(By.name("search_text")).sendKeys(ProductName) ;
		 		  driver.findElement(By.name("search")).click();
		 	//	  driver.findElement(By.xpath("//a[text()='iphone61']")).click();
		 		  Thread.sleep(2000);
		 		  //dynamic Xpath
		 		  driver.findElement(By.xpath("//a[text()='"+ProductName+"']")).click();
		 		  //driver switching back to main window
		 		  wlib.windowSwitching(driver,"Campaigns&action");
		 		   driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click()  ; 
		 			driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
				   	driver.findElement(By.linkText("Sign Out")).click();
				   	
	              
	}

}
