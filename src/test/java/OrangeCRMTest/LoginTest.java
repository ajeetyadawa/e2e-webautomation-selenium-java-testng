package OrangeCRMTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import Util.RunCommandLine;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {
	WebDriver driver;
	@Test (priority =0)
	public void LoginTest() {
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		driver.findElement(By.id("txtUsername")).sendKeys("Admin"); 
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		Assert.assertEquals("OrangeHRM", driver.getTitle());
		
	}
	
	@Test
	public void homePageTest() {
		List<WebElement> headerMenu= driver.findElements(By.xpath("//*[@id='mainMenuFirstLevelUnorderedList']/li"));
		Iterator<WebElement> menuIteration = headerMenu.iterator();
		List<String> actualMenuItems= new ArrayList<String>();
		
		while(menuIteration.hasNext()) {
			actualMenuItems.add(menuIteration.next().getText());
		}
		
		List<String>expectedMenu = Arrays.asList("Admin", "PIM", "Leave", "Time",
				"Recruitment", "My Info", "Performance", "Dashboard", "Directory", "Maintenance","Buzz");
		Assert.assertEquals(actualMenuItems, expectedMenu);
		Assert.assertEquals(actualMenuItems.size(), 11, "Verify Menu Count");
	}
	
	@AfterTest
	public void driverClose() {
		driver.close();
		try {
			RunCommandLine.executeCMD("taskkill /im chromedriver.exe /f");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
