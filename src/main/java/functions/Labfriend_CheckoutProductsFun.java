package functions;

import org.openqa.selenium.WebDriver;

import pages.Labfriend_CheckoutProductsPage;

public class Labfriend_CheckoutProductsFun extends LabFriend_CommonFun {

	WebDriver driver;

	public Labfriend_CheckoutProductsFun(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void mainTest() {

		Labfriend_CheckoutProductsPage checkoutProductsPage = new Labfriend_CheckoutProductsPage(driver);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		checkoutProductsPage.cartSymbol().click();
	}

}
