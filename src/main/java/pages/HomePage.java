package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import com.aventstack.extentreports.ExtentTest;
import ProjectSpecific.PageSpecificMethod;

public class HomePage extends PageSpecificMethod {

	public HomePage(RemoteWebDriver driver, ExtentTest test, ExtentTest node) {
		this.driver = driver;
		this.test = test;
		this.node = node;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//h2[text()[contains(.,'Demo')]]")
	public WebElement eleLoggedName;

	public HomePage verifyLoggedName(String data) {
		verifyPartialText(eleLoggedName, data);
		return this;
	}

	@FindBy(how = How.CLASS_NAME, using = "decorativeSubmit")
	private WebElement eleLogOut;

	public LoginPage clickLogout() {
		click(eleLogOut);
		return new LoginPage(driver, test, node);

	}

}
