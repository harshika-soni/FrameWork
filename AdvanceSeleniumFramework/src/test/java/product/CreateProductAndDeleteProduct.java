package product;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import genericutility.Excel_Utility;
import genericutility.File_Utility;
import genericutility.Java_Utility;
import genericutility.WebDriver_Utility;
import objectRepo.CreateProductPage;
import objectRepo.DeletePrdAndValidate;
import objectRepo.VTigerHomePage;
import objectRepo.VTigerLoginPage;

public class CreateProductAndDeleteProduct {

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
              VTigerLoginPage login = new VTigerLoginPage(driver);
                  login.loginToVtiger(USERNAME, PASSWORD);
              	VTigerHomePage home= new VTigerHomePage(driver);
              	home.clickproductlink();
              	CreateProductPage prdPage= new CreateProductPage(driver);
              	prdPage.clicklookUpImg();
             String prdName= elib.getExcelData("Product",2,2)+ranNum;
             prdPage.enterPrdName(prdName);
             prdPage.clicksaveButton();
      ///====================================================================================       
      DeletePrdAndValidate delprd= new DeletePrdAndValidate(driver);
      delprd.clickPrdlink();
      delprd.clickPrdName(driver, prdName);
      delprd.clickOnDeleteLink();
     wlib.alertAccept(driver);
      delprd.validatePrdDeleted(driver, prdName);
      Thread.sleep(2000);
      home.logOutFromApp();

	}

}
