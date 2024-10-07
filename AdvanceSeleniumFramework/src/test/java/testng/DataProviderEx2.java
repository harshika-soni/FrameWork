package testng;

import java.io.FileInputStream;
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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import genericutility.Java_Utility;

public class DataProviderEx2 {
	
	@Test(dataProvider="readData")
   public void organizationModuleTest(String orgName,String phnNum,String mailId) throws Throwable { 
	
	WebDriver driver= new ChromeDriver();	
	 driver.get("http://localhost:8888");
	driver.findElement(By.cssSelector("[name='user_name']")).sendKeys("admin");
driver.findElement(By.cssSelector("[name='user_password']")).sendKeys("admin");
	driver.findElement(By.id("submitButton")).click();
	Thread.sleep(2000);
	 driver.findElement(By.linkText("Organizations")).click();
	 driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
//	 Random ran=new Random();
	// int ranNum1=ran.nextInt(1000);
	
		 driver.findElement(By.name("accountname")).sendKeys(orgName);
		 driver.findElement(By.id("phone")).sendKeys(phnNum);
		  driver.findElement(By.id("email1")).sendKeys(mailId);
	
		  driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click()  ;
		  
	Thread.sleep(2000);
	
	driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
	driver.findElement(By.linkText("Sign Out")).click();
	
	
}
	
	@DataProvider()
	public Object[][] readData()
	{
		 Java_Utility jlib= new Java_Utility();
		int ranNum= jlib.getRandomNum();
		
		Object[][] objArr= new Object[3][3];
		
		objArr[0][0]="AAA"+ranNum;
		objArr[0][1]="9876543210";
		objArr[0][2]="abc@gmail.com";
		
		objArr[1][0]="BBB"+ranNum;
		objArr[1][1]="8976789543";
		objArr[1][2]="bgf@gmail.com";
		
	objArr[2][0]="ccc"+ranNum;
		objArr[2][1]="9080765432";
		objArr [2][2]="hyt@gmail.com"  ;        
		
		
		return objArr;
	}
}
