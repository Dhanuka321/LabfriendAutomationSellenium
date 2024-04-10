package functions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import contexts.Labfriend_LoginContext;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.LabFriend_LoginPage;

public class Labfriend_BaseClassFun {
	public static WebDriver driver = null;
	public LabFriend_LoginPage labfriendLoginPage = null;
	public static ExtentReports extent = null;

	public static WebDriver initilizeDriver() throws IOException {

		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\data\\LabFriendGlobalData\\GlobalData.properties");
		prop.load(fis);
		String browserName = System.getProperty("browser") != null ? System.getProperty("browser")
				: prop.getProperty("browser");
		// String browserName = prop.getProperty("browser");
		if (browserName.equalsIgnoreCase("chrome")) {
			//WebDriverManager.chromedriver().setup();
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\DhanukaD\\Work Folders\\Desktop\\chromedriver.exe");
			 driver = new ChromeDriver();
			//driver = new ChromeDriver();

		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("edgebrowser")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
		driver.manage().window().maximize();

		return driver;

	}

	public static ExtentReports reportConfig() {

		System.out.println("reportConfig");
		String path = System.getProperty("user.dir") + "\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Report NAMEEE");
		reporter.config().setDocumentTitle("Document Title");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Labfreind", "pathh");

		return extent;
	}

	public String getScreenshot(String testcaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);

		File file = new File(System.getProperty("user.dir") + "\\reports\\" + testcaseName + ".png");
		FileUtils.copyFile(source, file);

		return System.getProperty("user.dir") + "\\reports\\" + testcaseName + ".png";
	}
	public static void implicitGlobalWait(int waitTimeInSeconds) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitTimeInSeconds));
	}

	@BeforeMethod
	public void launchApplication() throws IOException {
		// Before Method is executed before each test is executed.
		Labfriend_LoginContext loginContext=new Labfriend_LoginContext();
		driver = initilizeDriver();
		labfriendLoginPage = new LabFriend_LoginPage(driver);
		labfriendLoginPage.gotoHomePage(driver);
		labfriendLoginPage.loginApplication(loginContext.getemail(), loginContext.getpassword());

	}

	@AfterMethod
	public void tearDown() {
		// After Method is executed after each test is executed completely.
		//driver.quit();
		// extent.flush();
	}
}
