package functions;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LabFriend_CommonFun {
	WebDriver driver;

	public LabFriend_CommonFun(WebDriver driver) {

		this.driver = driver;
	}

	public void waitForElementToAppear(By findBy, int timeInSeconds) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}

	public static Properties getPropertyData(String propertyFileName, String folderPath) {

		Properties prop = new Properties();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(
					System.getProperty("user.dir") + "\\data\\" + folderPath + "\\" + propertyFileName + ".properties");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return prop;
	}

}
