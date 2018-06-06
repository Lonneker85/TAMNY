package stepdefinitions;

import globals.Globals;
import globals.SharedObjects;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import cucumber.api.Scenario;
import cucumber.api.java.*;
import dataentities.Prospect;

public class SetupAndTeardownSteps extends SharedObjects {
	
	private SharedObjects _so;
	
	public SetupAndTeardownSteps(SharedObjects sharedObjects) {
		
		_so = sharedObjects;
	}
		
	@Before
	public void openBrowser(Scenario scenario) {
				
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
		System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver");
		
		//extentReports = new ExtentReports();
		
		//htmlReporter = new ExtentHtmlReporter(Globals.EXTENTREPORTS_FOLDER + "myreport.html");
		
		//extentReports.attachReporter(htmlReporter);
		
		_so.extentTest = RunCucumberTest.extentReports.createTest(scenario.getName());
		
		_so.driver = new ChromeDriver();
		
		/*h
		DesiredCapabilities capa = new DesiredCapabilities();
		capa.setBrowserName("chrome");
		
		try {
			driver = new RemoteWebDriver(new URL("http://localhost:4445/wd/hub"), capa);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
		_so.driver.manage().window().setSize(new Dimension(Globals.SCREEN_RESOLUTION_X,Globals.SCREEN_RESOLUTION_Y));
		
		_so.driver.manage().window().maximize();
	}
	
	@After
	public void closeBrowser() {
				
		_so.driver.quit();
		
		//extentReports.flush();
	}
}
