package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericutility.WebDriver_Utility;

public class VTigerHomePage {
	
	public VTigerHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(linkText="Campaigns")
	private WebElement campaignlink;
	
	@FindBy(xpath="//a[text()='Calendar']")
     private WebElement calenderlink;
	
	public WebElement getCampaignlink() {
		return campaignlink;
	}

	public WebElement getCalenderlink() {
		return calenderlink;
	}

	public WebElement getLeadlink() {
		return leadlink;
	}

	public WebElement getOrganizationlink() {
		return organizationlink;
	}

	public WebElement getProductlink() {
		return productlink;
	}

	public WebElement getDocumentlink() {
		return documentlink;
	}

	public WebElement getMorelink() {
		return morelink;
	}

	public WebElement getSignoutLink() {
		return signoutLink;
	}

	public WebElement getAdmLink() {
		return AdmLink;
	}
	@FindBy(xpath="(//a[text()='Leads'])[1]")
	private WebElement leadlink;
	
	@FindBy(linkText="Organizations")
	private WebElement organizationlink;
	
	@FindBy(linkText="Products")
	private WebElement productlink;
	
	@FindBy(xpath="//a[text()='Documents']")
	private WebElement documentlink;
	
	//@FindBy(xpath="//a[text()='More']")
	@FindBy(linkText="More")
	private WebElement morelink;
	
	@FindBy(linkText="Sign Out")
	private WebElement signoutLink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement AdmLink;
 
	//Business Logics
	 
	public void clickorganizationlink() {
		organizationlink.click();
	}
	public void clickproductlink() {
		productlink.click();
	}
	public void clickmorelink() {
		morelink.click();
	}
	public void clickcampaignlink() {
		campaignlink.click();
	}
	public void clicksignoutLink() {
		signoutLink.click();
	}
	public void clickAdmLink() {
		AdmLink.click();
	}
 	public void navigatecamp(WebDriver driver) 
 	{
 		//  Actions act= new Actions(driver)
 	//   act.moveToElement(morelink).perform();
 		WebDriver_Utility wlib= new WebDriver_Utility();
 		wlib.moveToElement(driver, morelink);
 		campaignlink.click();
 	}
 	public void logOutFromApp()
 	{
 		AdmLink.click();
 		signoutLink.click();
 	}
		
	}
	
	

	



