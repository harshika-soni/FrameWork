package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VTigerOrganization {

	
		public VTigerOrganization(WebDriver driver) {
					PageFactory.initElements(driver,this);}
		
		@FindBy(id="phone")
		private WebElement phone;
		
     public WebElement getPhone() {
			return phone;
		}
     @FindBy(id="email1")
     private WebElement email;

	public WebElement getEmail() {
		return email;
	}
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement save;

public WebElement getSave() {
		return save;
	}

@FindBy(xpath="//img[@alt='Create Organization...']")	
		private WebElement orgicon;
     
     public WebElement getOrgicon() {
		return orgicon;
	}

	public WebElement getOrgName() {
		return orgName;
	}


	@FindBy(name="accountname")
     private WebElement orgName;
					

	}


