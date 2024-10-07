package product;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericutility.BaseClass;
import genericutility.Excel_Utility;
import genericutility.File_Utility;
import genericutility.Java_Utility;
import genericutility.WebDriver_Utility;
import objectRepo.CreateOrgPage;
import objectRepo.CreateProductPage;
import objectRepo.VTigerHomePage;
import objectRepo.ValidateProductPage;
import objectRepo.ValidatingPage;
@Listeners(genericutility.ExtendsReports.class)
public class CreateProductTest extends BaseClass {

	@Test
	public void createProductTest() throws Throwable {
		
		WebDriver_Utility wlib = new WebDriver_Utility();
	    File_Utility file = new File_Utility();
		Java_Utility jlib = new Java_Utility();
		Excel_Utility elib = new Excel_Utility();
		
		int ranNum = jlib.getRandomNum();

		VTigerHomePage home = new VTigerHomePage(driver);
		home.clickproductlink();;
		  CreateProductPage   productPage= new CreateProductPage (driver);
          productPage.clicklookUpImg();
           String prdData = elib.getExcelData("Product", 2, 2)+ranNum;
           System.out.println(prdData) ;  
      	productPage.enterPrdName(prdData);
      	productPage.clicksaveButton();
      	ValidateProductPage validate= new ValidateProductPage(driver);
      	validate.validateproductPage(driver, prdData);
     

		
		
		
	}

}
