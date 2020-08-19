	package BrowserAndElements;
	
	
	import org.openqa.selenium.WebElement;
	
	public interface Elements {
	
		// Click an element and take snap
		public void click(WebElement element);
	
		// Enter value in textbox
		public void append(WebElement element, String data);
	
		// Clear an existing text in the text box
		public void clear(WebElement element);
	
		// Clear the text in the text box and enter a new value
		public void clearAndType(WebElement element, String data);
	
		// Getting the text of an element.
		public String getElementText(WebElement element);
	
		// Getting the entered text of an element.
		public String getTypedText(WebElement element);
	
		// Select a value in the dropdown using the text
		public void selectDropDownUsingText(WebElement element, String value);
	
		// Select a value in the dropdown using the index
		public void selectDropDownUsingIndex(WebElement element, int index);
	
		// Select a value in the dropdown using the value of the element
		public void selectDropDownUsingValue(WebElement element, String value);
	
		// Verify if the element is displayed
		public boolean verifyDisplayed(WebElement element);
	
		// Verify if the element is invisible
		public boolean verifyDisappeared(WebElement element);
	
		// Verify if the element is enabled.
		public boolean verifyEnabled(WebElement element);
	
		// Verify if a radio button or checkox is selected.
		public void verifySelected(WebElement element);
	
	}
