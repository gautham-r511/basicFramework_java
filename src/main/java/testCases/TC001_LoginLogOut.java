package testCases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import ProjectSpecific.PageSpecificMethod;
import pages.LoginPage;

public class TC001_LoginLogOut extends PageSpecificMethod {

	@BeforeTest
	public void setValues() {
		testCaseName = "Login and LoginOut";
		testDescription = "Login testCase using DemoSalesManager UserName and LogOut";
		dataSheetName = "TC001";
		nodes = "Leads";

	}

	@Test(dataProvider = "fetchData")
	public void createLeaf(String uName, String pwd) {
		new LoginPage(driver, test, node)
		.enterUserName(uName)
		.enterPassword(pwd)
		.clickLogin()
		.clickLogout();
	}

}
