package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProductPage {
	
	public CreateProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
 @FindBy(css="[title='Create Product...']")	
	 private WebElement lookUpImg; 
 
   @FindBy(name="productname")
   private WebElement prdName;

   @FindBy(xpath="//input[@title='Save [Alt+S]']")
   private WebElement saveButton;

public WebElement getLookUpImg() {
	return lookUpImg;
}

public WebElement getPrdName() {
	return prdName;
}

public WebElement getSaveButton() {
	return saveButton;
}
   public void clicklookUpImg() {
	   lookUpImg.click();
   }
   public void enterPrdName(String name) {
	   prdName.sendKeys(name);
   }
   public void clicksaveButton() {
	   saveButton.click();
   }
   
   
   
   
   
   
   
   
}



