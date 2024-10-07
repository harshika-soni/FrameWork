package testng;

import org.testng.annotations.Test;

public class TestNgDemo2 {
	
	@Test()
	public void createContact() {
		System.out.println("contact created");
		}
	@Test(dependsOnMethods="createContact")
	public void modifyContact() {
		System.out.println("contact modified");
	}
    @Test(dependsOnMethods="createContact")
	public void deleteContact() {
		System.out.println("contact deleted");
	}

}
