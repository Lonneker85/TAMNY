package pages.aop.nl;

import helpers.MYElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import pages.aop.base.AopPersonalDataBasePage;
import dataentities.Prospect;

public class AopPersonalDataNLPage extends AopPersonalDataBasePage {
	
	private WebDriver driver;
	
	private By dropdownGender = By.id("aop_Gender");
	private By txtFieldBsn = By.id("aop_IDCitizenServiceNumber");
	private By txtFieldDateOfBirth = By.id("aop_BirthDate");
	
	public AopPersonalDataNLPage(WebDriver driver) {
		
		super(driver);          
    }
}
