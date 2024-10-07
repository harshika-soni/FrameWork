package product;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import genericutility.Excel_Utility;
import genericutility.File_Utility;
import genericutility.Java_Utility;
import genericutility.WebDriver_Utility;

public class CreateProductUsingUtilityClass {

	public static void main(String[] args) throws Throwable {
		
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
        	  driver.findElement(By.name("user_name")).sendKeys(USERNAME);
        	  driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
        	  driver.findElement(By.id("submitButton")).click();    
        		driver.findElement(By.linkText("Products")).click();
        		driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
        String		productName=elib.getExcelData("Product", 2, 2)+ranNum;
        driver.findElement(By.name("productname")).sendKeys(productName);
        String partNum = elib.getExcelDataUsingDataformatter("Organization", 1, 1);
		  driver.findElement(By.id("productcode")).sendKeys(partNum);
		    driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click()  ;
	   	Thread.sleep(2000);
	   	   String actData = driver.findElement(By.xpath("//span[@id='dtlview_Product Name']")).getText();
	   	if(actData.contains(productName)) {
			System.out.println("Product  name is created");
		}
		else {
			System.out.println("Product  name is not created");
		}
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.linkText("Sign Out")).click();
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
	  driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.linkText("Sign Out")).click();  
	    	  
	}

}
