package testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertEx1 {
	
	@Test
	public void m1() {
		String expData = "Qspiders";
		String actData = "Qspider";
		Assert.assertEquals(actData, expData);
		System.out.println("Gud evng");
	}

	@Test
	public void m2()

	{
		System.out.println("Hello");
	}

}
