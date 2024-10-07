package ddt;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class InsertDataToProperties_File {

	public static void main(String[] args) throws Throwable {
	
	//	WebDriver driver= new ChromeDriver();
		
		Properties pro=new Properties();
		pro.setProperty("Browser","chrome");
		pro.setProperty("url", "http://localhost:8888/");
		pro.setProperty("username","admin");
		pro.setProperty("password","admin");
		
	//properties file in write mode
		FileOutputStream fos=new FileOutputStream("./src/test/resources/AdvanceData.properties");
		pro.store(fos,"commondata");
		
	
			FileInputStream fis = new FileInputStream("./src/test/resources/Advancedata.properties");
			Properties pro1  = new Properties();
			pro1.load(fis);
			
			String BROWSER = pro.getProperty("Browser");
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
