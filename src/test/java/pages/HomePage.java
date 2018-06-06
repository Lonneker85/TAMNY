package pages;

import globals.Globals;
import helpers.MYElements;

import org.openqa.selenium.*;

public class HomePage {

	private WebDriver driver;
		
	public HomePage(WebDriver driver) {
        
        this.driver = driver;
        driver.get(Globals.BASE_URL_TST);
    }
}
