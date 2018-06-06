package pages.aop;

import helpers.MYElements;

import org.openqa.selenium.*;

public class AopConfirmationPage {
	
	private WebDriver driver;
	private MYElements myElements = new MYElements();
	
	private By textfieldConfirmation = By.xpath("//h2[@class='slogan' and text()='Bedankt voor je aanvraag']");
	
	public AopConfirmationPage(WebDriver driver) {
		
		this.driver = driver;          
    }
	
	public boolean isAt() {
		
		return myElements.checkElementIsVisible(driver, textfieldConfirmation);
	}	
}
