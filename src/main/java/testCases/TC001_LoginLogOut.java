package testCases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ProjectSpecific.PageSpecificMethod;
import pages.LoginPage;

public class TC001_LoginLogOut extends PageSpecificMethod{	

	@BeforeTest
	public void setValues() {
		testCaseName = "Login and LoginOut";
		
		dataSheetName = "TC001";
	}

	@Test(dataProvider = "fetchData")
	public void createLeaf(String uName, String pwd) {
		new LoginPage(driver, test)
		.enterUserName(uName)
		.enterPassword(pwd)
		.clickLogin()
		.clickLogout();		
	}


}





