package screenShot;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ProKabaddi {

	public static void main(String[] args) {
		 WebDriver driver= new ChromeDriver();
		 driver.manage().window().maximize();
		 
		 driver.get("https://www.prokabaddi.com/standings");
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	//driver.findElement(By.xpath("//button[text()='Accept All Cookies']")).click();
	 String name="Puneri Paltan";
	List<WebElement> form = driver.findElements(By.xpath("//p[text()='"+name+"']/ancestor::div[@class='row-head']//div[@class='table-data form']//li"));
	
for(WebElement FORM:form) {
	System.out.println(FORM.getText());
}
	}

}
