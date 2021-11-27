package OrangeCRMTest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import OrangeCRMPages.HomePage;
import OrangeCRMPages.LoginPage;
import Util.RunCommandLine;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest2 {

	public WebDriver driver;
	
	@Test(priority=0)
	public void loginTest2() {
	    WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
	    driver.get("https://opensource-demo.orangehrmlive.com/");
		LoginPage lPage = new LoginPage(driver);
		lPage.login("Admin", "admin123");
			
	}
	
	@Test(priority=1)
	public void LogOff() {
		HomePage hPage = new HomePage(driver);
		hPage.logOff();
	}
	
	@AfterTest
	public void closeSetUp() throws InterruptedException, IOException {
		driver.close();
		RunCommandLine.executeCMD("taskkill /im chromedriver.exe /f");
	}
	
}
