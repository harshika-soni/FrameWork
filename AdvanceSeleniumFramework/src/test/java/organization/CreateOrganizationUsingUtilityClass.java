package organization;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import genericutility.Excel_Utility;
import genericutility.File_Utility;
import genericutility.Java_Utility;
import genericutility.WebDriver_Utility;

public class CreateOrganizationUsingUtilityClass {

	public static void main(String[] args) throws Throwable {
		
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
        	  driver.findElement(By.name("user_name")).sendKeys(USERNAME);
        	  driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
        	  driver.findElement(By.id("submitButton")).click();    
        	  driver.findElement(By.linkText("Organizations")).click();
        		 driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
        		 String OrgName = elib.getExcelData("Organization", 0,0)+ ranNum;
        		 System.out.println(OrgName);
        		 driver.findElement(By.name("accountname")).sendKeys(OrgName);
        		String phonNum = elib.getExcelDataUsingDataformatter("Organization", 1, 1);
        		  driver.findElement(By.id("phone")).sendKeys(phonNum);
        		  String email = elib.getExcelData("Organization", 2, 0);
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
