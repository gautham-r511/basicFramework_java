package utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import cucumber.api.testng.AbstractTestNGCucumberTests;

public abstract class Reports extends AbstractTestNGCucumberTests {

	public WebDriver driver;
	public ExtentHtmlReporter reports;
	public ExtentReports extent;
	public ExtentTest test, node;

	public String testCaseName, testDescription, reportPageTitle, reportName, nodes;
	public String excelFileName;

	@BeforeSuite
	public void startReport() {
		reports = new ExtentHtmlReporter("./reports/result.html");
		reports.setAppendExisting(true);
		extent = new ExtentReports();
		extent.attachReporter(reports);

		extent.setSystemInfo("TestCaseName", testCaseName);
		// Give page title
		reports.config().setDocumentTitle("Execution");
		// Give report name
		reports.config().setReportName("My Report name");
		reports.config().setTheme(Theme.DARK);

	}

	@BeforeClass
	public void testname() {
		test = extent.createTest(testCaseName, testDescription);
	}

	public abstract long takeSnap();

	public void reportStep(String dec, String status, boolean bSnap) {
		MediaEntityModelProvider img = null;
		if (bSnap && !status.equalsIgnoreCase("INFO")) {

			long snapNumber = 100000L;
			snapNumber = takeSnap();
			try {
				img = MediaEntityBuilder.createScreenCaptureFromPath("./../reports/images/" + snapNumber + ".jpg")
						.build();
			} catch (IOException e) {

			}
		}
		if (status.equalsIgnoreCase("pass")) {
			node.pass(dec, img);
		} else if (status.equalsIgnoreCase("fail")) {
			node.fail(dec, img);
		}
	}

	public void reportStep(String desc, String status) {
		reportStep(desc, status, true);
	}

	@AfterSuite
	public void stopReport() {
		extent.flush();
	}

}
