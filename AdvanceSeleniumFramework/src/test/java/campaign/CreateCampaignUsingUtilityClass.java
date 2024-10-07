package campaign;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import genericutility.Excel_Utility;
import genericutility.File_Utility;
import genericutility.Java_Utility;
import genericutility.WebDriver_Utility;
import objectRepo.VTigerLoginPage;

public class CreateCampaignUsingUtilityClass {

	public static void main(String[] args) throws Throwable {
	 
		WebDriver driver= new ChromeDriver();	
		WebDriver_Utility wlib= new WebDriver_Utility();
		 File_Utility flib= new File_Utility();  
		 Java_Utility jlib= new Java_Utility();
		 int ranNum=jlib.getRandomNum();
	      wlib.windowMaximize(driver);
                 
                  
                 String URL = flib.getKeyAndValuePair("url")  ;
               String USERNAME= flib.getKeyAndValuePair("username")  ;
              String PASSWORD = flib.getKeyAndValuePair("password")  ;
                driver.get(URL);
    //Reading Data using getter methods
                VTigerLoginPage login= new VTigerLoginPage(driver);
                login.getUserTextField().sendKeys(USERNAME);
                login.getPasswordTextField().sendKeys(PASSWORD);
                login.getLoginButton().click();
                
                //Business logic
          //      VTigerLoginPage login = new VTigerLoginPage(driver);
            //    login.loginToVtiger(USERNAME, PASSWORD);
                
    //             driver.findElement(By.cssSelector("[name='user_name']")).sendKeys(USERNAME);
      //      	driver.findElement(By.cssSelector("[name='user_password']")).sendKeys(PASSWORD);
        //       driver.findElement(By.id("submitButton")).click();
               
            WebElement morelink = driver.findElement(By.xpath("//a[text()='More']")); 
            wlib.moveToElement(driver, morelink);
            driver.findElement(By.linkText("Campaigns")).click();
        	driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
            Excel_Utility elib=new Excel_Utility();
         String campData = elib.getExcelData("Campaign", 0, 0)+ranNum;
           //  String campData=elib.getExcelData("Campaign",0,0)+ranNum;
		     System.out.println(campData);
		       driver.findElement(By.name("campaignname")).sendKeys(campData);
		       driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click()  ;
		   	Thread.sleep(2000);
		   	String actData=driver.findElement(By.xpath("//span[@id='dtlview_Campaign Name']")).getText();
		   	if(actData.contains(campData)) {
		   		System.out.println("campaign name is created");
		   	}
		   	else {
		   		System.out.println("campaign name is not created");
		   	}
		   	driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		   	driver.findElement(By.linkText("Sign Out")).click();
		   	
                                
      
	}

}
