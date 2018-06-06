package pages;

import helpers.MYElements;

import org.openqa.selenium.*;

public class CookieWall {

	private WebDriver driver;
	private MYElements myElements = new MYElements();
		
	private By iFrameCookieWall = By.xpath("//iframe[contains(@style,'privacy-en-cookies')]");
	private By buttonAcceptCookies = By.linkText("Accepteren");
	
	public CookieWall(WebDriver driver) {
        
        this.driver = driver;
    }
	
	public void acceptCookies() {
		
		driver.switchTo().frame(myElements.getElement(driver, iFrameCookieWall));
		myElements.click(driver, buttonAcceptCookies);
		driver.switchTo().defaultContent();		
	}
}
