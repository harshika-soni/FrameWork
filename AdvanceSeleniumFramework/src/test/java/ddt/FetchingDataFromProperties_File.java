package ddt;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FetchingDataFromProperties_File {

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
	
	
	

	}

}
