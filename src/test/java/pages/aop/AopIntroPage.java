package pages.aop;

import globals.Globals;
import helpers.MYElements;

import org.openqa.selenium.*;

public class AopIntroPage {
	
	private WebDriver driver;
	private MYElements myElements = new MYElements();
	
	private By btnOpenAccountForSelf = By.xpath("//button[contains(text(),'Voor mijzelf')]");
	private By btnOpenJointAccount = By.id("contentregion_0_introbuttonregion_0_button2");
	
	public AopIntroPage(WebDriver driver) {
		
		this.driver = driver;          
    }
	
	public AopIntroPage loadAOP(String aopName) {
		
		switch(aopName.toLowerCase()) {
        
        case "vrij opneembaar" :
        	myElements.get(driver, Globals.BASE_URL_TST + Globals.AOP_VRIJ_OPNEEMBAAR);
        	break;
        case "kwartaal spaarrekening" :
        	myElements.get(driver, Globals.BASE_URL_TST + Globals.AOP_KWARTAAL_SPAARREKENING);
        	break;
        default :
        	//TODO: better error handling
        	throw new Error("Unknown aopName " + aopName);
        }
		
		return this;
	}
	
	public void openAccountForSelf() {
		
		myElements.click(driver, btnOpenAccountForSelf);
	}
	
	public void openJointAccount() {
		
		myElements.click(driver, btnOpenJointAccount);
	}
}