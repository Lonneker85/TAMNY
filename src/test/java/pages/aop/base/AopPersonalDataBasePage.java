package pages.aop.base;

import helpers.MYElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import dataentities.Prospect;

public class AopPersonalDataBasePage {
	
	private WebDriver driver;
	private MYElements myElements = new MYElements();
	
	private By dropdownGender = By.id("aop_Gender");
	private By txtFieldBsn = By.id("aop_IDCitizenServiceNumber");
	private By txtFieldDateOfBirth = By.id("aop_BirthDate");
	
	public AopPersonalDataBasePage(WebDriver driver) {
		
		this.driver = driver;		
    }
	
	public AopPersonalDataBasePage setGender(String gender) {
		
		myElements.select(driver, dropdownGender, gender);
		return this;
	}
	
	public AopPersonalDataBasePage setBsn(String bsn) {
		
		myElements.sendKeys(driver, txtFieldBsn, bsn);
		return this;
	}
	
	public AopPersonalDataBasePage setDateOfBirth(String dateOfBirth) {
		
		myElements.sendKeys(driver, txtFieldDateOfBirth, dateOfBirth);
		return this;
	}
	
	public boolean errorMessageIsShown(String errorMessage) {
		
		return myElements.checkElementIsVisible(driver, By.xpath("//span[contains(@class,'error') and text()='" + errorMessage + "']"));
	}
}