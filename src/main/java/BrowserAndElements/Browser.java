package BrowserAndElements;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public interface Browser {

	// Default browser is Chrome browser. Input is only the url.
	public RemoteWebDriver browser(String url);

	// Input is only the browser and url.
	public RemoteWebDriver browser(String Browser, String url);

	// Locate all matching elements located by specific locator and value.
	public WebElement locateElement(String locatorType, String value);

	// Locate all matching elements located by ID
	public WebElement locateElement(String value);

	// Locate all matching elements.
	public List<WebElement> locateElements(String type, String value);

	// Switch to alert to handle.
	public void switchToAlert();

	// Accept the Alert.
	public void acceptAlert();

	// Decline an alert
	public void dismissAlert();

	// Get alert text.
	public String getAlertText();

	// Enter text in alert.
	public void typeAlert(String data);

	// Switch to multiple window using index.
	public void switchToWindow(int index);

	// Switch to multiple window using title.
	public void switchToWindow(String title);

	// Switch to multiple frame using index.
	public void switchToFrame(int index);

	// Switch to multiple frame using webelement.
	public void switchToFrame(WebElement ele);

	// Switch to multiple frame using ID or name of the element.
	public void switchToFrame(String idOrName);

	// Switch to default content in both window and frame.
	public void defaultContent();

	// Close the window.
	public void close();

	// Quit the browser.
	public void quit();

}
