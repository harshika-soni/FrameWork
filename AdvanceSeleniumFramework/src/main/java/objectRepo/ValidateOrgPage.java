package objectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ValidateOrgPage {
     
	public ValidateOrgPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public void validateorgPage(WebDriver driver, String OrgName) {
// String actData = driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();
String actData = driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();
		if(actData.contains(OrgName)) {
	   		System.out.println("Organization name is created");
	   	}
	   	else {
	   		System.out.println("Organization name is not created");
	   	}
	}
}
