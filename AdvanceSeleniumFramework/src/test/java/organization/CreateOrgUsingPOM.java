package organization;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import genericutility.Excel_Utility;
import genericutility.File_Utility;
import genericutility.Java_Utility;
import genericutility.WebDriver_Utility;
import objectRepo.VTigerHomePage;
import objectRepo.VTigerLoginPage;
import objectRepo.VTigerOrganization;

public class CreateOrgUsingPOM {

	public static void main(String[] args) throws Throwable {
		
		WebDriver driver = new ChromeDriver();
          File_Utility file=new File_Utility();
          WebDriver_Utility wlib= new WebDriver_Utility();
          Excel_Utility elib= new Excel_Utility();
 		 Java_Utility jlib= new Java_Utility();
 		 int ranNum=jlib.getRandomNum();
		
		String URL=file.getKeyAndValuePair("url");
		String USERNAME = file.getKeyAndValuePair("username");
		String PASSWORD = file.getKeyAndValuePair("password");
		
         driver.get(URL);
     	VTigerLoginPage login= new  VTigerLoginPage(driver);
        
    	login.getUserTextField().sendKeys(USERNAME);
    	login.getPasswordTextField().sendKeys(PASSWORD);
    	login.getLoginButton().click();
    	 VTigerHomePage vhp=new VTigerHomePage(driver);
    	 vhp.getOrganizationlink().click();
    	// String orgName = elib.getExcelData("Organization", 0, 0);
    	 VTigerOrganization cop= new  VTigerOrganization(driver);
    	 cop.getOrgicon().click();
    	String orgName = elib.getExcelData("Organization", 0, 0)+ranNum ;
                  cop.getOrgName().sendKeys(orgName); 
                 String PartNo = elib.getExcelDataUsingDataformatter("Organization", 1, 1)+ranNum;
                 cop.getPhone().sendKeys(PartNo);
             String email = elib.getExcelData("Organization", 2, 0) +ranNum; 
               cop.getEmail().sendKeys(email);
               cop.getSave().click();
	}

}
