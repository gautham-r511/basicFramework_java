	package utils;
	
	import java.io.IOException;
	
	import org.openqa.selenium.WebDriver;
	import org.testng.ITestResult;
	import org.testng.annotations.AfterSuite;
	import org.testng.annotations.AfterTest;
	import org.testng.annotations.BeforeSuite;
	import org.testng.annotations.BeforeTest;
	
	import com.aventstack.extentreports.ExtentReports;
	import com.aventstack.extentreports.ExtentTest;
	import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
	import com.aventstack.extentreports.reporter.configuration.Theme;
	
	public class Reports extends GetScreenshot {
	
		public WebDriver driver;
		public ExtentHtmlReporter reports;
		public ExtentReports extent;
		public ExtentTest test;
	
		public String testCaseName, reportPageTitle, reportName;
		public String excelFileName;
	
		@BeforeSuite
		public void startReport() {
			reports = new ExtentHtmlReporter("./reports/result.html");
			reports.setAppendExisting(true);
			extent = new ExtentReports();
			extent.attachReporter(reports);
	
			extent.setSystemInfo("TestCaseName", testCaseName);
			reports.config().setDocumentTitle(reportPageTitle);
			reports.config().setReportName(reportName);
			reports.config().setTheme(Theme.DARK);
	
		}
	
		@BeforeTest
		public void testname(String testcaseName) {
			test = extent.createTest(testcaseName);
		}
	
		@AfterTest
		public void getResult(ITestResult result) throws IOException {
			if (result.getStatus() == ITestResult.FAILURE) {
				String screenshotpath = GetScreenshot.capture(driver, testCaseName);
				test.fail(result.getThrowable());
				test.fail("Snapshot Below: " + test.addScreenCaptureFromPath(screenshotpath));
			} else {
				test.pass(result.getName() + " Test Passed.");
			}
		}
	
		public void reportStep(String desc, String status) {
			reportStep(desc, status);
		}
	
		@AfterSuite
		public void stopReport() {
			extent.flush();
		}
	
	}
