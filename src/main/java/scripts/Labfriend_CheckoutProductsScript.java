package scripts;


import org.testng.annotations.Test;
import functions.Labfriend_BaseClassFun;
import functions.Labfriend_CheckoutProductsFun;

/**
 * @author Dhanuka_Dulanjana
 * 
 */

public class Labfriend_CheckoutProductsScript extends Labfriend_BaseClassFun {

	public String PROPERTY_FILE_NAME = "CheckoutProducts";
	public String PROPERTY_FOLDER_NAME = "LabFriendCheckoutProducts";

	// public static WebDriver driver;

	@Test
	public void checkoutProducts() throws Exception {
		// This method name reflects exactly your Test case name, Therefore this method
		// name should be written meaningfully.
		//implicitGlobalWait(5);
		Labfriend_CheckoutProductsFun checkoutProductsFun = new Labfriend_CheckoutProductsFun(driver,
				PROPERTY_FILE_NAME, PROPERTY_FOLDER_NAME);
		checkoutProductsFun.mainTest();

	}

}
