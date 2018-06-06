package pages.aop;

import helpers.MYElements;

import org.openqa.selenium.*;

import dataentities.Prospect;

public class AopContactDetailsPage {
	
	private WebDriver driver;
	private MYElements myElements = new MYElements();
	
	private By txtFieldPostalCode = By.id("aop_PostalCode");
	private By txtFieldHouseNumber = By.id("aop_HouseNumber");
	private By txtFieldStreet = By.id("aop_Street");
	private By txtFieldCity = By.id("aop_City");
	private By txtFieldEmail = By.id("aop_Email");
	private By txtFieldEmailConfirm = By.id("aop_EmailConfirm");
	private By txtFieldTelephone = By.id("aop_Telephone");
	private By btnNextStep = By.xpath("(//button[contains(text(),'Volgende stap')])[1]");
		
	public AopContactDetailsPage(WebDriver driver) {
		
		this.driver = driver;          
    }
	
	public AopContactDetailsPage setDefaultContactDetails(Prospect prospect) {

		setPostalCode(prospect.getContactDetails().getZipCode()).
		setHouseNumber(prospect.getContactDetails().getHouseNumber()).
		setEmailAddress(prospect.getContactDetails().getEmailAddress()).
		setTelephoneNumber(prospect.getContactDetails().getTelephoneNumber());		
		return this;
	}
	
	public AopContactDetailsPage setPostalCode(String postalCode) {
		
		myElements.sendKeys(driver, txtFieldPostalCode, postalCode);
		return this;
	}
	
	public AopContactDetailsPage setHouseNumber(String houseNumber) {
		
		myElements.sendKeys(driver, txtFieldHouseNumber, houseNumber);
		return this;
	}
	
	public AopContactDetailsPage setStreet(String street) {
		
		myElements.sendKeys(driver, txtFieldStreet, street);
		return this;
	}
	
	public AopContactDetailsPage setCity(String city) {
		
		myElements.sendKeys(driver, txtFieldCity, city);
		return this;
	}
	
	public AopContactDetailsPage setEmailAddress(String emailAddress) {
		
		myElements.sendKeys(driver, txtFieldEmail, emailAddress);
		myElements.sendKeys(driver, txtFieldEmailConfirm, emailAddress);
		return this;
	}
	
	public AopContactDetailsPage setTelephoneNumber(String telephoneNumber) {
		
		myElements.sendKeys(driver, txtFieldTelephone, telephoneNumber);
		return this;
	}
		
	public AopContactDetailsPage clickButtonNextStep() {
				
		myElements.click(driver, btnNextStep);
		return this;
	}
}