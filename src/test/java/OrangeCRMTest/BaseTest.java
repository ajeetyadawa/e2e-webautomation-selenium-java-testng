package OrangeCRMTest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Util.PropReader;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public static WebDriver driver;
	public static String browserName;
	public static String username;
	public static String password;
	public static String driverPath;
	public static PropReader property;
	
	 public static WebDriver getDriver() {
	        return driver;
	    }
	@BeforeTest
	public void browserLaunch() throws IOException {
		property= new PropReader();
		browserName=property.getValue("browser");
		if(browserName.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("ie")) {
			driverPath =property.getValue("iedriverpath");
			System.setProperty("webdriver.ie.driver",driverPath);
			driver = new InternetExplorerDriver();
		}
		else {
			driverPath =property.getValue("edgedriverpath");
			System.setProperty("webdriver.edge.driver", driverPath);
			driver = new EdgeDriver();
		}
		driver.get(property.getValue("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
	}
	
	
	
	@AfterTest
	public void closeBrowser() {
		driver.close();
	}
	
	
}
