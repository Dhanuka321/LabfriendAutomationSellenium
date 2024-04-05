package scripts;


import java.time.Duration;

import org.testng.annotations.Test;
import functions.Labfriend_BaseClassFun;
import functions.Labfriend_CheckoutProductsFun;

/**
 * @author Dhanuka_Dulanjana
 * 
 */

public class Labfriend_CheckoutProductsScript extends Labfriend_BaseClassFun {
	
	public String PROPERTY_FILE_NAME="";
	public String TEST_CASE_NAME="Checkout_Products";
	
	//public static WebDriver driver;

	@Test
	public void checkoutProducts() throws Exception {
		implicitGlobalWait(5);
		Labfriend_CheckoutProductsFun checkoutProductsFun = new Labfriend_CheckoutProductsFun(driver);
		checkoutProductsFun.mainTest();
		
	}

}
