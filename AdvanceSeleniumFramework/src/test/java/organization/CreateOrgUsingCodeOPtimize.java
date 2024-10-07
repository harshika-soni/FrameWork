package organization;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import genericutility.Excel_Utility;
import genericutility.File_Utility;
import genericutility.Java_Utility;
import genericutility.WebDriver_Utility;
import objectRepo.CreateOrgPage;
import objectRepo.VTigerHomePage;
import objectRepo.VTigerLoginPage;
import objectRepo.ValidateOrgPage;
import objectRepo.ValidateProductPage;
import objectRepo.ValidatingPage;

public class CreateOrgUsingCodeOPtimize {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		
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
        	  VTigerLoginPage login= new  VTigerLoginPage(driver);
        	  login.getUserTextField().sendKeys(USERNAME);
          	login.getPasswordTextField().sendKeys(PASSWORD);
          	login.getLoginButton().click();
          	 VTigerHomePage home=new  VTigerHomePage(driver);
          	home.clickorganizationlink();
              CreateOrgPage OrgPage= new CreateOrgPage(driver);
               	OrgPage.clickLookUpImg();
               	
                  String OrgName = elib.getExcelData("Organization", 0, 0)+ranNum;
                    System.out.println(OrgName) ;  
               	OrgPage.enterOrgName(OrgName);
               	OrgPage.clickSaveButton();
           //    	ValidateOrgPage validate= new ValidateOrgPage(driver);
             //  validate.validateorgPage(driver, OrgName);
              // 	ValidateOrgPage validate= new ValidateOrgPage(driver);
               	ValidatingPage validate=new ValidatingPage(driver);
                Thread.sleep(2000);
            	validate.validateOrgPage(driver, OrgName);
               Thread.sleep(2000);
               	home.clickAdmLink();
               	home.clicksignoutLink();

        	  
        	  
              
          
	}

}
