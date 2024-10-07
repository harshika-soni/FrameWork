package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrgPage {

	public CreateOrgPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@alt='Create Organization...']")
		private WebElement lookUpImg;
	
	@FindBy(name="accountname")
	private WebElement OrgName;
	
   @FindBy(xpath="//input[@title='Save [Alt+S]']")	
    private WebElement saveButton;

    public WebElement getLookUpImg() {
	return lookUpImg;
   }
  public WebElement getOrgName() {
	return OrgName;
  }
  public WebElement getSaveButton() {
	return saveButton;
  }
  public void clickLookUpImg() {
	  lookUpImg.click();
  }
  public void enterOrgName(String name) {
	  OrgName.sendKeys(name);
  }
  public void clickSaveButton() {
	  saveButton.click();
  }


	
}
