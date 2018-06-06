package pages;

import helpers.MYElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TopMenu {
	
	private WebDriver driver;
	private MYElements myElements = new MYElements();
	
	private By linkMenuOptionSparen = By.xpath("//a[contains(@data-ns,'topmenu.sparen')]");
	
	public TopMenu(WebDriver driver) {
        
        this.driver = driver;
    }

	public TopMenu openMenuSparen() {
		
		myElements.click(driver, linkMenuOptionSparen);
		return this;
	}
	
	public void selectMenuItem(String menuItem) {
		
		myElements.click(driver, By.linkText(menuItem));
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}