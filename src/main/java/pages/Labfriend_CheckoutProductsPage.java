package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Labfriend_CheckoutProductsPage {

	public WebDriver driver;
	private static WebElement element = null;

	public Labfriend_CheckoutProductsPage(WebDriver driver) {
		this.driver = driver;

	}

	public WebElement cartSymbol() {
		// cart-icon-button-container

		element = driver.findElement(By.xpath("//a[@data-cy='cart-icon-button-container']"));
		return element;
	}

}
