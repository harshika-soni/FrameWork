package objectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ValidateProductPage {
	
	public ValidateProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	

	public void validateproductPage(WebDriver driver, String prdData) {
		String actData=driver.findElement(By.xpath("//span[@id='dtlview_Product Name']")).getText();
	   
		if(actData.contains(prdData)) {
	   		System.out.println("Product name is created");
	   	}
	   	else {
	   		System.out.println("Product name is not created");
	   	}
		
	}

}
