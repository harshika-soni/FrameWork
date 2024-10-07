package product;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import genericutility.BaseClass;
import genericutility.Excel_Utility;
import genericutility.File_Utility;
import genericutility.Java_Utility;
import genericutility.WebDriver_Utility;
import objectRepo.CreateProductPage;
import objectRepo.DeletePrdAndValidate;
import objectRepo.VTigerHomePage;

public class CreateProductAndDeleteTest extends BaseClass {
@Test
public void createProductAndDeleteTest() throws Throwable {
		
		WebDriver_Utility wlib = new WebDriver_Utility();
	    File_Utility file = new File_Utility();
		Java_Utility jlib = new Java_Utility();
		Excel_Utility elib = new Excel_Utility();
		
		int ranNum = jlib.getRandomNum();

		VTigerHomePage home = new VTigerHomePage(driver);
		home.clickproductlink();
		 CreateProductPage   productPage= new CreateProductPage (driver);
         productPage.clicklookUpImg();
          String productName = elib.getExcelData("Product", 2, 2)+ranNum;
          System.out.println(productName) ;  
     	productPage.enterPrdName(productName);
     	productPage.clicksaveButton();
    	Thread.sleep(2000);
	   	   String actData = driver.findElement(By.xpath("//span[@id='dtlview_Product Name']")).getText();
	   	if(actData.contains(productName)) {
			System.out.println("Product  name is created");
		}
		else {
			System.out.println("Product  name is not created");
		}
      	driver.findElement(By.xpath("(//a[text()='Products'])[2]")).click();
      	driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr/td//a[text()='"+productName+"']/../preceding-sibling::td//input[@type='checkbox']")).click();
      		   driver.findElement(By.xpath("//input[@value='Delete']")).click();
      		    driver.switchTo().alert().accept();
      	List<WebElement> productlist = driver.findElements(By.xpath("(//table[@class='lvt small']/tbody/tr/td[3])[position()>1]"));
      			      boolean flag=false;
      			      for(WebElement prdName: productlist) {
      			    	  String actData1= prdName.getText();{
      			    		  flag=true;
      			    		  break;
      			    		  }
      			    	  }
      			  if(flag) {
      				  System.out.println("product is deleted");
      			  }else {
      				  System.out.println("product is deleted");
      			  }
      			 DeletePrdAndValidate delprd= new DeletePrdAndValidate(driver);
      		   //   delprd.clickPrdlink();
      		     // delprd.clickPrdName(driver, productName);
      		     // delprd.clickOnDeleteLink();
      		    // wlib.alertAccept(driver);
      		      delprd.validatePrdDeleted(driver, productName);
	
}}
