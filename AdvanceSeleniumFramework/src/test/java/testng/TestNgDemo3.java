package testng;

import org.testng.annotations.Test;

public class TestNgDemo3 {
	
	@Test()
	public void createContact() {
		System.out.println("contact created");
		}
	@Test(enabled=false)
	public void modifyContact() {
		System.out.println("contact modified");
	}
    @Test()
	public void deleteContact() {
		System.out.println("contact deleted");
	}

}
