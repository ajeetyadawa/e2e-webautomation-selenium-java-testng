package OrangeCRMTest;

import org.testng.annotations.Test;


import OrangeCRMPages.LoginPage;

public class LoginTest3 extends BaseTest{
	
	@Test
	public void loginTest() {
		LoginPage lpage= new LoginPage(driver);
		lpage.login("Admin", "admin123");
		lpage.isLogin();
	}

}
