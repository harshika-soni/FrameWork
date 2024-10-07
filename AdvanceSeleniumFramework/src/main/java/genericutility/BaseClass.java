package genericutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import objectRepo.VTigerHomePage;
import objectRepo.VTigerLoginPage;

public class BaseClass {
	
	
	public   WebDriver driver;
	public static WebDriver sdriver;
	
	@BeforeSuite(groups= {"smokeTest","regressionTest","sanityTest"})
	public void BS() {
		System.out.println("DataBase Open");	
		}
	
	@BeforeTest(groups= {"smokeTest","regressionTest","sanityTest"})
	public void BT() {
		System.out.println("parallel execution");
	}
	//@Parameters("BROWSER")
	@BeforeClass(groups= {"smokeTest","regressionTest","sanityTest"})
	//public void BC(String BROWSER) throws Throwable {
		public void BC() throws Throwable {
		
		File_Utility flib=new File_Utility();
     String BROWSER = flib.getKeyAndValuePair("browser");
	
	if(BROWSER.equalsIgnoreCase("chrome")) {
		driver= new ChromeDriver();
	}
	else if(BROWSER.equalsIgnoreCase("edge")) {
		driver=new EdgeDriver();
	}
	else if(BROWSER.equalsIgnoreCase("firefox")) {
		driver=new FirefoxDriver();
	}
	else {
		driver=new ChromeDriver();
	}
	}
	@BeforeMethod(groups= {"smokeTest","regressionTest","sanityTest"})
	public  void BM() throws Throwable
	{
		WebDriver_Utility wlib = new WebDriver_Utility();
		  File_Utility file = new File_Utility();

	 wlib.windowMaximize(driver);

		String URL = file.getKeyAndValuePair("url");
		String USERNAME = file.getKeyAndValuePair("username");
		String PASSWORD = file.getKeyAndValuePair("password");

		driver.get(URL);

		// Business Logics
		VTigerLoginPage login = new VTigerLoginPage(driver);
		login.loginToVtiger(USERNAME, PASSWORD);

		System.out.println("Login To App");
	}
	@AfterMethod(groups= {"smokeTest","regressionTest","sanityTest"})
	public void AM()
	{
		VTigerHomePage home = new VTigerHomePage(driver);
	//	home.logOutFromApp();
		home.clickAdmLink();
		home.clicksignoutLink();
		System.out.println("logout from App");
	}
	
	@AfterClass(groups= {"smokeTest","regressionTest","sanityTest"})
	public void AC()
	{
		driver.quit();
		System.out.println("close browser");
	}
	
	@AfterTest(groups= {"smokeTest","regressionTest","sanityTest"})
	public void AT()
	{
		System.out.println("parallel execution");
	}
	
	@AfterSuite(groups= {"smokeTest","regressionTest","sanityTest"})
	public void AS()
	{
		System.out.println("close DataBase");
	
	}
	

}
