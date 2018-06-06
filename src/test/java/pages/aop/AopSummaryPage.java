package pages.aop;

import helpers.MYElements;

import org.openqa.selenium.*;

public class AopSummaryPage {
	
	private WebDriver driver;
	private MYElements myElements = new MYElements();
	
	private By btnFinishAOP = By.xpath("//button[text()='Rond je aanvraag af']");

	public AopSummaryPage(WebDriver driver) {
		
		this.driver = driver;          
    }
	
	public AopConfirmationPage finishAOP() {
		
		myElements.click(driver, btnFinishAOP);
		return new AopConfirmationPage(driver);
	}	
}