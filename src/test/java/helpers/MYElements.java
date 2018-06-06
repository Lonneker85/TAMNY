package helpers;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

import globals.Globals;
import globals.SharedObjects;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import stepdefinitions.SetupAndTeardownSteps;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

public class MYElements extends SharedObjects {
	
	public MYElements() {		
	}
	
	public void get(WebDriver driver, String pageToLoad) {
		
		try {
			driver.get(pageToLoad);
		}
		catch (TimeoutException te){
			extentTest.error("Loading page took more than " + Globals.DEFAULT_TIMEOUT + " seconds", MYReporting.getScreenshot(driver));
			Assert.fail();
		}
	}

	public boolean waitForElementOnPageLoad(WebDriver driver, By by) {

		try
		{
			new WebDriverWait(driver, Globals.DEFAULT_TIMEOUT).until(ExpectedConditions.elementToBeClickable(by));
		}
		catch (TimeoutException te)
		{
			extentTest.error("TimeoutException caught while waiting for element " + by.toString() + " on page load");
			return false;
		}
		return true;
	}
	
	public boolean waitForElementToBeVisible(WebDriver driver, By by) {
		
		try {
			new WebDriverWait(driver, Globals.DEFAULT_TIMEOUT).until(ExpectedConditions.visibilityOfElementLocated(by));
		}
		catch (TimeoutException te)
		{
			extentTest.error("TimeoutException caught while waiting for element " + by.toString() + " to be visible", MYReporting.getScreenshot(driver));
			return false;
		}
		return true;
	}

	public void click(WebDriver driver, By by) {
		
		try {
			new WebDriverWait(driver, Globals.DEFAULT_TIMEOUT).until(ExpectedConditions.elementToBeClickable(by));
			driver.findElement(by).click();
		}
		catch (TimeoutException te) {
			extentTest.error("Timeout occurred when clicking on " + by.toString() + ": " + te.getMessage(), MYReporting.getScreenshot(driver));
			Assert.fail();
		}
		catch (NoSuchElementException nse) {
			extentTest.error("Element " + by.toString() + "could not be found: " + nse.getMessage(), MYReporting.getScreenshot(driver));
			Assert.fail();
		}
		catch (WebDriverException wde) {
			// probably due to modal blocking access to the element to be clicked
			// wait a second and then wait for the modal to go away
			// finally, try clicking again
			
			uglyWaitThatShouldBeAvoided(1000);		
			
			waitForSpinners(driver);
			
			driver.findElement(by).click();
		}
	}

	public void select(WebDriver driver, By by, String valueToBeSelected) {

		try {
			new WebDriverWait(driver, Globals.DEFAULT_TIMEOUT).until(ExpectedConditions.elementToBeClickable(by));			
			Select selectDropdown = new Select(driver.findElement(by));
			selectDropdown.selectByVisibleText(valueToBeSelected);
		}
		catch (TimeoutException | NoSuchElementException ex) {
			extentTest.error("Error in select(): Element " + by.toString() + " could not be found", MYReporting.getScreenshot(driver));
			Assert.fail();
		}
	}

	public void sendKeys(WebDriver driver, By by, String textToSend) {

		try {
			new WebDriverWait(driver, Globals.DEFAULT_TIMEOUT).until(ExpectedConditions.elementToBeClickable(by));
			driver.findElement(by).sendKeys(textToSend);
		}
		catch (TimeoutException | NoSuchElementException ex) {
			extentTest.error("Error in sendKeys(): Element " + by.toString() + " could not be found", MYReporting.getScreenshot(driver));
			Assert.fail();
		}
	}
	
	public void sendKeys(WebDriver driver, By by, Keys keysToSend) {

		try {
			new WebDriverWait(driver, Globals.DEFAULT_TIMEOUT).until(ExpectedConditions.elementToBeClickable(by));
			driver.findElement(by).sendKeys(keysToSend);
		}
		catch (TimeoutException | NoSuchElementException ex) {
			extentTest.error("Error in sendKeys(): Element " + by.toString() + " could not be found", MYReporting.getScreenshot(driver));
			Assert.fail();
		}
	}
	
	public void sendResourceToUpload(WebDriver driver, By by, String pathToFile) {

		String absolutePath = "";
		URL resourceUrl = MYElements.class.getResource(pathToFile);
		
		try {
			absolutePath = Paths.get(resourceUrl.toURI()).toFile().getAbsolutePath();
		} catch (URISyntaxException use) {
			extentTest.error("Caught URISyntaxException in sendResourceToUpload, is the specified path '" + pathToFile + "' correct?");
		}
		
		try {
			new WebDriverWait(driver, Globals.DEFAULT_TIMEOUT).until(ExpectedConditions.presenceOfElementLocated(by));
			driver.findElement(by).sendKeys(absolutePath);
		}
		catch (TimeoutException | NoSuchElementException ex) {
			extentTest.error("Error in sendResourceToUpload(): Element " + by.toString() + " could not be found", MYReporting.getScreenshot(driver));
			Assert.fail();
		}
	}

	public WebElement getElement(WebDriver driver, By by) {

		try {
			new WebDriverWait(driver, Globals.DEFAULT_TIMEOUT).until(ExpectedConditions.elementToBeClickable(by));			
		}
		catch (TimeoutException | NoSuchElementException ex) {
			extentTest.error("Error in getElement(): Element " + by.toString() + " could not be found");
			Assert.fail();
		}
		return driver.findElement(by);
	}
	
	public boolean checkElementIsVisible(WebDriver driver, By by) {
		
		try {
			new WebDriverWait(driver, Globals.DEFAULT_TIMEOUT).until(ExpectedConditions.visibilityOfElementLocated(by));
		}
		catch (TimeoutException | NoSuchElementException ex) {
			extentTest.error("Error in checkElementIsVisible(): Element " + by.toString() + " could not be found");
			return false;
		}
		return true;
	}

	public void waitForSpinners(WebDriver driver) {

		try {
			new WebDriverWait(driver, Globals.SPINNER_TIMEOUT).until(ExpectedConditions.visibilityOfElementLocated(Globals.DIV_SPINNER));
			// spinner is visible, wait until it disappears
			try {
				new WebDriverWait(driver, Globals.DEFAULT_TIMEOUT).until(ExpectedConditions.invisibilityOfElementLocated(Globals.DIV_SPINNER));				
			}
			catch (TimeoutException ex) {
				extentTest.error("Spinner " + Globals.DIV_SPINNER.toString() + " did not disappear after " + Globals.DEFAULT_TIMEOUT + " seconds", MYReporting.getScreenshot(driver));
				Assert.fail();
			}
		}
		catch (TimeoutException | NoSuchElementException ex) {
			// spinner does not appear, do nothing
		}
	}
	
	public void sendKeysToBrowser(WebDriver driver, Keys keysToSend) {
		
		driver.switchTo().activeElement().sendKeys(keysToSend);
		driver.switchTo().defaultContent();
	}
	
	public void uglyWaitThatShouldBeAvoided(long durationInMilliSeconds) {
		
		try {
			Thread.sleep(durationInMilliSeconds);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
}
