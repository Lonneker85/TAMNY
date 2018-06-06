package pages.aop;

import helpers.MYElements;

import org.openqa.selenium.*;

public class AopTermsAndConditionsPage {
	
	private WebDriver driver;
	private MYElements myElements = new MYElements();
	
	private By checkboxConditionsAgreed = By.xpath("//input[@id='aop_ConditionsAgreed']/parent::div");
	private By checkboxFatca = By.xpath("//input[@id='aop_Fatca']/parent::div");
	private By btnNextStep = By.xpath("(//button[contains(text(),'Volgende stap')])[2]");

	public AopTermsAndConditionsPage(WebDriver driver) {
		
		this.driver = driver;          
    }
	
	public AopTermsAndConditionsPage checkTermsAndConditions() {
		
		myElements.click(driver, checkboxConditionsAgreed);
		myElements.click(driver, checkboxFatca);
		return this;
	}
	
	public AopTermsAndConditionsPage clickButtonNextStep() {
				
		myElements.click(driver, btnNextStep);
		return this;
	}
}
