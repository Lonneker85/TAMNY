package globals;

import org.openqa.selenium.By;

public class Globals {
	
	public static final String BASE_URL_TST = "https://tst-2015.moneyou.nl";
	public static final String AOP_VRIJ_OPNEEMBAAR = "/aop/intro?code=moneyou_sparen_vrijopneembaar";
	public static final String AOP_KWARTAAL_SPAARREKENING = "/aop/intro?code=moneyou_sparen_kwartaal_spaarrekening";
	
	public static final int DEFAULT_TIMEOUT = 30;
	public static final int SPINNER_TIMEOUT = 5;
	
	public static final String USERNAME_PREFIX = "at";
	
	public static final String EXTENTREPORTS_FOLDER = "target/extentreports/";
	public static final String EXTENTREPORTS_IMAGES_FOLDER = "images/";
	
	public static final int SCREEN_RESOLUTION_X = 1920;
	public static final int SCREEN_RESOLUTION_Y = 1200;
	
	public static final By DIV_SPINNER = By.className("spinner");
}
