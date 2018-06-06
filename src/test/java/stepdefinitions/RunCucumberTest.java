package stepdefinitions;

import globals.Globals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "classpath:features",
		plugin = {"pretty", "json:target/cucumber-json-report/cucumber-json-report.json"},
		tags = {"~@ignore"}
		)

public class RunCucumberTest{
	
	public static ExtentReports extentReports;
	public static ExtentHtmlReporter htmlReporter;
	
	@BeforeClass
	public static void initialize() {
		
		extentReports = new ExtentReports();
		
		htmlReporter = new ExtentHtmlReporter(Globals.EXTENTREPORTS_FOLDER + "myreport.html");
		
		extentReports.attachReporter(htmlReporter);		
	}
	
	@AfterClass
	public static void tearDown() {
		
		extentReports.flush();
	}
}
