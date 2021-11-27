package OrangeCRMPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {
WebDriver driver;
public LoginPage(WebDriver driver){
	this.driver=driver;
	PageFactory.initElements(driver, this);
}

@FindBy(id="txtUsername")
WebElement inputUserName;

@FindBy(id="btnLogin")
WebElement submitButton;

@FindBy(id="txtPassword")
WebElement inputPassword;

public void login(String userName, String Password) {
	inputUserName.sendKeys(userName);
	inputPassword.sendKeys(Password);
	submitButton.click();
}

public void isLogin() {
	String title= driver.getTitle();
	System.out.println("BrowserTitle"+title);
	Assert.assertEquals(title, "OrangeHRM");

}
}
