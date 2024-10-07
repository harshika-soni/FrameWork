package campaign;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import genericutility.Excel_Utility;
import genericutility.File_Utility;
import genericutility.Java_Utility;
import genericutility.WebDriver_Utility;
import objectRepo.CreateCampPage;
import objectRepo.VTigerHomePage;
import objectRepo.VTigerLoginPage;
import objectRepo.ValidatingPage;



public class CreateCampaignUsingcodeOPtimization  {

	public static void main (String[] args) throws Throwable {
		
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
           	home.navigatecamp(driver);
          
       CreateCampPage campPage= new CreateCampPage(driver);
        	campPage.clickLookUpImg();
        	
           String campData = elib.getExcelData("Campaign", 0, 0)+ranNum;
             System.out.println(campData) ;  
        	campPage.enterCampName(campData);
        	campPage.clickSaveButton();
        	ValidatingPage validate= new ValidatingPage(driver);
        	validate.validateCampPage(driver, campData);
        	
        	home.clickAdmLink();
        	home.clicksignoutLink();

	}

}
