package pages;

import globals.Globals;
import helpers.MYElements;

import org.openqa.selenium.*;

public class OpenSavingsAccountPage {

	public OpenSavingsAccountPage(WebDriver driver, String savingsAccountType) {
        
        switch(savingsAccountType.toLowerCase()) {
        
        case "vrij opneembaar" :
        	driver.get(Globals.BASE_URL_TST + "/sparen/particulier/moneyou-sparen-vrij-opneembaar");
        	break;
        case "kwartaal spaarrekening" :
        	driver.get(Globals.BASE_URL_TST + "/sparen/particulier/moneyou-sparen-kwartaal-spaarrekening");
        	break;
        default :
        	//TODO: better error handling
        	throw new Error("Unknown savingsAccountType " + savingsAccountType);
        }
        
    }
}
