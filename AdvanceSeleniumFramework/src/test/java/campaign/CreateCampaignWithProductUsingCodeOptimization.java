package campaign;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import genericutility.Excel_Utility;
import genericutility.File_Utility;
import genericutility.Java_Utility;
import genericutility.WebDriver_Utility;
import objectRepo.CreateCampPage;
import objectRepo.CreateProductPage;
import objectRepo.VTigerHomePage;
import objectRepo.VTigerLoginPage;
import objectRepo.ValidateProductPage;
import objectRepo.ValidatingPage;

public class CreateCampaignWithProductUsingCodeOptimization {

	public static void main(String[] args) throws Throwable {
		

		WebDriver driver= new ChromeDriver();
		File_Utility flib= new File_Utility();
		Excel_Utility elib= new Excel_Utility();
		Java_Utility jlib= new Java_Utility();
		WebDriver_Utility wlib= new WebDriver_Utility();
		 int ranNum=jlib.getRandomNum();
	      wlib.windowMaximize(driver);
		
		  String URL = flib.getKeyAndValuePair("url")  ;  	
		  String USERNAME = flib.getKeyAndValuePair("username");
	  String PASSWORD = flib.getKeyAndValuePair("password");
		  
	  driver.get(URL);
	//Business logic
            VTigerLoginPage login = new VTigerLoginPage(driver);
           login.loginToVtiger(USERNAME, PASSWORD);
           //create Product
       	VTigerHomePage home= new VTigerHomePage(driver);
      	home.clickproductlink();
          CreateProductPage   productPage= new CreateProductPage (driver);
            productPage.clicklookUpImg();
             String prdData = elib.getExcelData("Product", 2, 2)+ranNum;
             System.out.println(prdData) ;  
        	productPage.enterPrdName(prdData);
        	productPage.clicksaveButton();
        	ValidateProductPage validate= new ValidateProductPage(driver);
        	validate.validateproductPage(driver, prdData);
        	home.navigatecamp(driver);
            
            CreateCampPage campPage= new CreateCampPage(driver);
             	campPage.clickLookUpImg();
             	
                String campData = elib.getExcelData("Campaign", 0, 0)+ranNum;
                  System.out.println(campData) ;  
             	campPage.enterCampName(campData);
             	campPage.clickSaveButton();
             	ValidatingPage validate1= new ValidatingPage(driver);
            	validate1.validateCampPage(driver, campData);
             	Thread.sleep(2000);
             	home.logOutFromApp();
	}

}
