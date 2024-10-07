package product;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
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

public class CreateProductwithDelete {

	public static void main(String[] args) throws Throwable {
		
		FileInputStream fis = new FileInputStream("./src/test/resources/Advacedata.properties");
		Properties pro  = new Properties();
		pro.load(fis);
		
		String BROWSER = pro.getProperty("browser");
	String URL=pro.getProperty("url");
	String USERNAME = pro.getProperty("username");
	String PASSWORD = pro.getProperty("password");
	
	WebDriver driver;
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
	driver.get(URL);
	driver.findElement(By.cssSelector("[name='user_name']")).sendKeys(USERNAME);
	driver.findElement(By.cssSelector("[name='user_password']")).sendKeys(PASSWORD);
	driver.findElement(By.id("submitButton")).click();
	driver.findElement(By.linkText("Products")).click();
	driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
	 Random ran=new Random();
	 int ranNum=ran.nextInt(1000);
	FileInputStream	fis1=new	FileInputStream("./src/test/resources/ExcelMultipledata.xlsx");
	
	Workbook book = WorkbookFactory.create(fis1);

	      Sheet sheet = book.getSheet("Product");
	      Row row = sheet.getRow(2);
	      Cell cell = row.getCell(2);
	     String ProductName = cell.getStringCellValue()+ranNum ;
	       driver.findElement(By.name("productname")).sendKeys(ProductName);
	       driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click()  ;
	       driver.findElement(By.xpath("//a[text()='Products']")).click();
 driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr/td//a[text()='"+ProductName+"']/../preceding-sibling::td//input[@type='checkbox']")).click();
	       driver.findElement(By.xpath("//input[@value='Delete']")).click();
	       driver.switchTo().alert().accept();
	      List<WebElement> productlist = driver.findElements(By.xpath("(//table[@class='lvt small']/tbody/tr/td[3])[position()>1]"));
	      boolean flag=false;
	      for(WebElement prdName: productlist) {
	    	  String actData= prdName.getText();{
	    		  flag=true;
	    		  break;
	    		  }
	    	  }
	  if(flag) {
		  System.out.println("product is deleted");
	  }else {
		  System.out.println("product is deleted");
	  }
	  driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.linkText("Sign Out")).click();  
	    	  
	    	  
	      }

	}


