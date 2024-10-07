package product;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import genericutility.Excel_Utility;
import genericutility.File_Utility;
import genericutility.Java_Utility;
import genericutility.WebDriver_Utility;
import objectRepo.CreateProductPage;
import objectRepo.VTigerHomePage;
import objectRepo.VTigerLoginPage;
import objectRepo.ValidateProductPage;
import objectRepo.ValidatingPage;

public class CreateProductUsingCodeOptimization {

	public static void main(String[] args) throws Throwable {
		
		WebDriver driver = new ChromeDriver();
		
		 Excel_Utility elib=new Excel_Utility();
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
            //	VTigerHomePage home= new VTigerHomePage(driver);
            	home.clickAdmLink();
            	home.clicksignoutLink();

	}

}
