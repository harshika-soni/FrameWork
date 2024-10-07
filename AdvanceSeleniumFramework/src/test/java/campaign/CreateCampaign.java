package campaign;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import genericutility.Excel_Utility;
import genericutility.File_Utility;
import genericutility.Java_Utility;
import genericutility.WebDriver_Utility;
import objectRepo.VTigerHomePage;
import objectRepo.VTigerLoginPage;

public class CreateCampaign {

	public static void main(String[] args) throws Throwable {
		
		WebDriver driver=new ChromeDriver();
		WebDriver_Utility wlib= new WebDriver_Utility();
	/*	FileInputStream fis = new FileInputStream("./src/test/resources/Advacedata.properties");
		Properties pro  = new Properties();
		pro.load(fis);
		
		String BROWSER = pro.getProperty("browser");
	String URL=pro.getProperty("url");
	String USERNAME = pro.getProperty("username");
	String PASSWORD = pro.getProperty("password");
	
//	WebDriver driver;
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
	}*/
		File_Utility file=new File_Utility();
		
		String URL=file.getKeyAndValuePair("url");
		String USERNAME = file.getKeyAndValuePair("username");
		String PASSWORD = file.getKeyAndValuePair("password");
		
		
	driver.get(URL);
/*	driver.findElement(By.cssSelector("[name='user_name']")).sendKeys(USERNAME);
	driver.findElement(By.cssSelector("[name='user_password']")).sendKeys(PASSWORD);
	driver.findElement(By.id("submitButton")).click();*/
//	VTigerLoginPage login= new  VTigerLoginPage(driver);
	          
//	login.getUserTextField().sendKeys(USERNAME);
	//login.getPasswordTextField().sendKeys(PASSWORD);
//	login.getLoginButton().click();
	//Business logic
         VTigerLoginPage login = new VTigerLoginPage(driver);
         login.loginToVtiger(USERNAME, PASSWORD);
          
	
	WebElement morelink = driver.findElement(By.xpath("//a[text()='More']"));
	wlib.moveToElement(driver, morelink);
	//Actions act= new Actions(driver);
	//act.moveToElement(morelink).perform();
	VTigerHomePage vhp= new VTigerHomePage(driver);
	vhp.getCampaignlink().click();

	//driver.findElement(By.linkText("Campaigns")).click();
	driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
//	 Random ran=new Random();
	// int ranNum=ran.nextInt(1000)
        Java_Utility jlib=new Java_Utility();
        int ranNum=jlib.getRandomNum();
	/*	FileInputStream	fis1=new	FileInputStream("./src/test/resources/ExcelMultipledata.xlsx");
		
		Workbook book = WorkbookFactory.create(fis1);

		      Sheet sheet = book.getSheet("Campaign");
		      Row row = sheet.getRow(0);
		      Cell cell = row.getCell(0);
		     String campName = cell.getStringCellValue() +ranNum;*/
        Excel_Utility elib=new Excel_Utility();
		     String campData=elib.getExcelData("Campaign",0,0)+ranNum;
		     System.out.println(campData);
		       driver.findElement(By.name("campaignname")).sendKeys(campData);
		       driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click()  ;
		   	Thread.sleep(2000);
		   	String actData=driver.findElement(By.xpath("//span[@id='dtlview_Campaign Name']")).getText();
		   	if(actData.contains(campData)) {
		   		System.out.println("campaign name is created");
		   	}
		   	else {
		   		System.out.println("campaign name is not created");
		   	}
		   	driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		   	driver.findElement(By.linkText("Sign Out")).click();
		   	

	}

}
