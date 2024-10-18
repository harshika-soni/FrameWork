package objectRepo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeletePrdName {
	
	public DeletePrdName(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//input[@value='Delete']")
	private WebElement deleteButton;


     public  void selectPrdData(WebDriver driver,String PrdName) {
    	driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr/td//a[text()='\"+prdName+\"']/../preceding-sibling::td//input[@type='checkbox']")).click(); 
    }
     public void clickOnDeleteButton() {
    	 deleteButton.click();
     }
     
    	 public void validatePrdDeleted(WebDriver driver, String prdName1) {
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
    	 }
    	 
}
