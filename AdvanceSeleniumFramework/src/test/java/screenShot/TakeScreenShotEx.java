package screenShot;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TakeScreenShotEx {

	public static void main(String[] args) throws Throwable {
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.flipkart.in");
		        TakesScreenshot ts = (TakesScreenshot)driver;
		       File src = ts.getScreenshotAs(OutputType.FILE);
               File dest = new File("./ScreenShotImgs.png");
               FileUtils.copyFile(src, dest);
                         
                         
	}

}
