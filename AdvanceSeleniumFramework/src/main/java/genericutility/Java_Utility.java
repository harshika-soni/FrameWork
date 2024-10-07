package genericutility;

import java.util.Random;

public class Java_Utility {
	/*
	 * This method is used to avoid Duplicates
	 * @Returns
	 * @author  Harshika
	 */

	public int getRandomNum() {
		Random ran=new Random();
		 int ranNum=ran.nextInt(3000);
		return ranNum;
	}
}
