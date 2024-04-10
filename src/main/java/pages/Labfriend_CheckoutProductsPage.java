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

	public WebElement searchField() {
		element = driver.findElement(By.xpath("//input[@name='q'][1]"));
		return element;
	}

	public WebElement searchItem() {

		element = driver.findElement(By.xpath("//li[contains(text(),'Part #: ')]"));
		return element;
	}

	public WebElement searchResultImage() {

//		element = driver.findElement(By.xpath("//img[@class='ss__result-image object-contain object-center']"));
//		return element;
		element = driver.findElement(By.xpath("//h3[@class='ss__result-title text-md md:text-lg product-card__title font-400 mb-[4px] line-clamp-3']"));
		return element;

	}

	public WebElement addToCartButton() {
		element = driver.findElement(By.xpath("//button[@data-cy='add-to-cart-button']"));
		return element;

	}

	public WebElement checkoutButton() {
		element = driver.findElement(By.xpath("//div[text()='Checkout']"));
		return element;
	}

}
