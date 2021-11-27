package OrangeCRMTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public static WebDriver driver;
	public static String browserName;
	 public static WebDriver getDriver() {
	        return driver;
	    }
	@BeforeTest
	public void browserLaunch() {
		browserName="Chrome";
		if(browserName.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver","E:\\SeleniumJar\\IEDriverServer_x64_4.0.0\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		else {
			System.setProperty("webdriver.edge.driver", "E:\\SeleniumJar\\edgedriver_win64\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
	}
	
	
	
	@AfterTest
	public void closeBrowser() {
		driver.close();
	}
	
	
}
