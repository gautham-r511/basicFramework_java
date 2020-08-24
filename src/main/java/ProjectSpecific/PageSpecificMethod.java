package ProjectSpecific;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import BaseWorks.BasicOperations;
import utils.DataLibrary;

public class PageSpecificMethod extends BasicOperations {

	public String dataSheetName;

	@DataProvider(name = "fetchData")
	public Object[][] fetchData() throws IOException {
		return DataLibrary.readExcelData(dataSheetName);
	}

	@BeforeMethod
	public void beforeMethod() {
		driver = browser("chrome", "http://leaftaps.com/opentaps");
		node = test.createNode(testCaseName);
	}

	@AfterMethod
	public void afterMethod() {
		close();
	}

}
