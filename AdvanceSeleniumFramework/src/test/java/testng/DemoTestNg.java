package testng;

import org.testng.annotations.Test;

public class DemoTestNg {
	
	@Test(priority=1)
	public void createContact() {
		System.out.println("contact created");
		}
	@Test(priority=0)
	public void modifyContact() {
		System.out.println("contact modified");
	}
    @Test(priority=-1)
	public void deleteContact() {
		System.out.println("contact deleted");
	}
    

}
