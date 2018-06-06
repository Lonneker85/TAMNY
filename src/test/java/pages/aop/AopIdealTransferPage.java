package pages.aop;

import helpers.MYElements;

import org.openqa.selenium.*;

public class AopIdealTransferPage {
	
	private WebDriver driver;
	private MYElements myElements = new MYElements();
	
	private By btnOneCent = By.xpath("//button[contains(text(),'0,01')]");
	private By btnTransferMoney = By.xpath("//button[contains(text(),'Boek over')]");
	private By btnConfirmTransferMoney = By.xpath("//input[@value='Confirm Transaction']");
	private By btnNextStep = By.xpath("(//button[contains(text(),'Volgende stap')])[3]");
	private By dropdownIdealIssuer = By.id("aop_IdealIssuers");

	public AopIdealTransferPage(WebDriver driver) {
		
		this.driver = driver;          
    }
	
	public AopIdealTransferPage performDefaultIdealTransfer() {
		
		selectIdealIssuer("Issuer Simulation V3 - ING").
		selectOneCentForAmount().
		transferMoney();
		return this;		
	}
	
	public AopIdealTransferPage selectIdealIssuer(String idealIssuer) {
		
		myElements.select(driver, dropdownIdealIssuer, idealIssuer);
		return this;
	}
	
	public AopIdealTransferPage selectOneCentForAmount() {
		
		myElements.click(driver, btnOneCent);
		return this;
	}
	
	public AopIdealTransferPage transferMoney() {
		
		myElements.click(driver, btnTransferMoney);
		myElements.click(driver, btnConfirmTransferMoney);
		return this;
	}
	
	public AopIdealTransferPage clickButtonNextStep() {
				
		myElements.click(driver, btnNextStep);
		return this;
	}
}