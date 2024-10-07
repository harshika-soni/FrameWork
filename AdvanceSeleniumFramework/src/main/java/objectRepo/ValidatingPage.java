package objectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ValidatingPage {

	public ValidatingPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void validateCampPage(WebDriver driver, String campName) {
	 	String actData=driver.findElement(By.xpath("//span[@id='dtlview_Campaign Name']")).getText();
	 	Assert.assertEquals(actData, campName);
	 	System.out.println("CampName is created");
	//   	if(actData.contains(campName)) {
	 //  		System.out.println("campaign name is created");
	 //  	}
	   //	else {
	  // 		System.out.println("campaign name is not created");
	   //	}
	}

	public void validateOrgPage(WebDriver driver, String OrgName) {
		
		String actData=driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();
		Assert.assertEquals(actData, OrgName);
	 	System.out.println("OrgName is created");
/*		if(actData.contains(OrgName)) {
			System.out.println("organisation name is created");
		}
		else {
			System.out.println("organisation name is not created");
		}*/
		
	}
}
