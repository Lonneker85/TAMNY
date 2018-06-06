package pages.aop;

import helpers.MYElements;

import org.openqa.selenium.*;

public class AopIdentificationPage {
	
	private WebDriver driver;
	private MYElements myElements = new MYElements();
	
	private By dropdownIdentificationType = By.id("aop_IDType");
	private By inputDriversLicenseFront = By.xpath("//input[@doc-type='IdVerifyDriversLicense_0']");
	private By inputDriversLicenseBack = By.xpath("//input[@doc-type='IdVerifyDriversLicense_1']");
	private By divDriversLicenseFrontProgressBarComplete = By.xpath("//ng-upload-form[@doc-type='IdVerifyDriversLicense_0']//div[contains(@class,'progress-bar') and contains(@style,'100%')]");
	private By divDriversLicenseBackProgressBarComplete = By.xpath("//ng-upload-form[@doc-type='IdVerifyDriversLicense_1']//div[contains(@class,'progress-bar') and contains(@style,'100%')]");

	public AopIdentificationPage(WebDriver driver) {
		
		this.driver = driver;          
    }
	
	public AopIdentificationPage setDefaultIdentification() {
		
		selectIdentificationType("Nederlands rijbewijs").
		uploadIdentificationFront("/images/SWE_DL_front.png").
		uploadIdentificationBack("/images/SWE_DL_back.png");
		return this;
	}
	
	public AopIdentificationPage selectIdentificationType(String idType) {
		
		myElements.select(driver, dropdownIdentificationType, idType);
		return this;
	}
	
	public AopIdentificationPage uploadIdentificationFront(String pathToImage) {
		
		myElements.sendResourceToUpload(driver, inputDriversLicenseFront, pathToImage);
		
		myElements.waitForElementToBeVisible(driver, divDriversLicenseFrontProgressBarComplete);
		
		return this;
	}
	
	public AopIdentificationPage uploadIdentificationBack(String pathToImage) {
		
		myElements.sendResourceToUpload(driver, inputDriversLicenseBack, pathToImage);
		
		myElements.waitForElementToBeVisible(driver, divDriversLicenseBackProgressBarComplete);
		
		myElements.waitForSpinners(driver);
		
		return this;
	}
}