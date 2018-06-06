package helpers;

import globals.SharedObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class MYAssert extends SharedObjects {

	public MYAssert() {		
	}
	
	public void assertTrue(WebDriver driver, boolean valueToAssert, String reportingMessage) {
		
		try {
			Assert.assertTrue(valueToAssert);
			extentTest.pass(reportingMessage, MYReporting.getScreenshot(driver));
		}
		catch (AssertionError ae) {
			extentTest.fail("AssertTrue failed when evaluating check '" + reportingMessage + "'", MYReporting.getScreenshot(driver));
			throw new AssertionError(reportingMessage);
		}		
	}
	
	public void assertFalse(WebDriver driver, boolean valueToAssert, String reportingMessage) {
		
		try {
			Assert.assertFalse(valueToAssert);
			extentTest.pass(reportingMessage);
		}
		catch (AssertionError ae) {
			extentTest.fail("AssertFalse failed when evaluating check '" + reportingMessage + "'", MYReporting.getScreenshot(driver));
			throw new AssertionError(reportingMessage);
		}		
	}
	
	public void assertEquals(WebDriver driver, String expectedValue, String actualValue, String reportingMessage) {
		
		try {
			Assert.assertEquals(expectedValue, actualValue);
			extentTest.pass(reportingMessage);
		}
		catch (AssertionError ae) {
			extentTest.fail("AssertEquals failed when evaluating check '" + reportingMessage + "', actual value was '" + actualValue + "', where '" + expectedValue + "' was expected", MYReporting.getScreenshot(driver));
			throw new AssertionError(reportingMessage);
		}		
	}
	
	public void assertEquals(WebDriver driver, long expectedValue, long actualValue, String reportingMessage) {
		
		try {
			Assert.assertEquals(expectedValue, actualValue);
			extentTest.pass(reportingMessage);
		}
		catch (AssertionError ae) {
			extentTest.fail("AssertEquals failed when evaluating check '" + reportingMessage + "', actual value was " + actualValue + ", where " + expectedValue + " was expected", MYReporting.getScreenshot(driver));
			throw new AssertionError(reportingMessage);
		}		
	}
}
