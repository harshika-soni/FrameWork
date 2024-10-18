package organization;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericutility.BaseClass;
import genericutility.Excel_Utility;
import genericutility.File_Utility;
import genericutility.Java_Utility;
import genericutility.WebDriver_Utility;
import objectRepo.CreateCampPage;
import objectRepo.CreateOrgPage;
import objectRepo.VTigerHomePage;
import objectRepo.ValidatingPage;
@Listeners(genericutility.ExtendsReports.class)
public class CreateOrganiZATIONtstTest  extends BaseClass {
	@Test(groups="smokeTest")
	public void createOrganiZATIONtstTest() throws Throwable{
	WebDriver_Utility wlib = new WebDriver_Utility();
    File_Utility file = new File_Utility();
	Java_Utility jlib = new Java_Utility();
	Excel_Utility elib = new Excel_Utility();
	
	int ranNum = jlib.getRandomNum();

	VTigerHomePage home = new VTigerHomePage(driver);
	home.clickorganizationlink();
	 CreateOrgPage OrgPage= new CreateOrgPage(driver);
     	OrgPage.clickLookUpImg();
     	
        String OrgName = elib.getExcelData("Organization", 0, 0)+ranNum;
        System.out.println(OrgName) ;  
       	OrgPage.enterOrgName(OrgName);
       	OrgPage.clickSaveButton();
   	ValidatingPage validate=new ValidatingPage(driver);
        Thread.sleep(2000);
    	validate.validateOrgPage(driver, OrgName);
        
   //     String actData=driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();
   //	Assert.assertEquals(actData,OrgName);

}
}