package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class VTigerLoginPage {
	
	public VTigerLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	//Declaration
	@FindBy(name="user_name")
	private WebElement userTextField;
	
	//AND
	//@FindBys({@FindBy(css="[type='password']"),@FindBy(name="user_password")})
	@FindBy(name="user_password")
	private WebElement passwordTextField;
	
	@FindAll({@FindBy(xpath="//input[@type='submit']"),@FindBy(id="submitButton")})
      private WebElement loginButton;

	public WebElement getUserTextField() {
		return userTextField;
	}

	public WebElement getPasswordTextField() {
		return passwordTextField;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}
	//bussiness logic
	public void loginToVtiger(String Usrname,String Password) {
		userTextField.sendKeys(Usrname);
		passwordTextField.sendKeys(Password);
		loginButton.click();
	}
	
	

}
