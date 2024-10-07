package screenShot;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TakeScrenShotYoutube {

	public static void main(String[] args) throws Throwable {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.youtube.com/");
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));		
driver.findElement(By.xpath("//input[@id='search']")).sendKeys("selenium with java");
driver.findElement(By.xpath("//button[@id='search-icon-legacy']")).click();

driver.findElement(By.xpath("(//img[@id='img'])[3]")).click();
String mainId=driver.getWindowHandle();
System.out.println(mainId);
Set<String> AllId = driver.getWindowHandles();
System.out.println(AllId);
for(String id:AllId) {
	  if(!mainId.equals(id)) {
		  driver.switchTo().window(id);
	
	  }

TakesScreenshot ts = (TakesScreenshot)driver;
File src1 = ts.getScreenshotAs(OutputType.FILE);
File dest1 = new File("./ScreenShotImgs.png");
FileUtils.copyFile(src1, dest1);
	}
	}
}
