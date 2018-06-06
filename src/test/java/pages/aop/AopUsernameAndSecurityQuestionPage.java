package pages.aop;

import helpers.MYElements;
import helpers.MYTestDataUtil;

import org.openqa.selenium.*;

public class AopUsernameAndSecurityQuestionPage {
	
	private WebDriver driver;
	private MYElements myElements = new MYElements();
	
	private By dropdownPersonalSecurityQuestion = By.id("aop_PSQuestion");
	private By txtFieldUsername = By.id("aop_UserID");
	private By txtFieldPersonalSecurityAnswer = By.id("aop_PSAnswer");
		
	public AopUsernameAndSecurityQuestionPage(WebDriver driver) {
		
		this.driver = driver;          
    }
	
	public AopUsernameAndSecurityQuestionPage setDefaultUsernameAndSecurityQuestion() {
		
		createAndEnterUsername().
		selectPersonalSecurityQuestion("Wat is je favoriete hobby?").
		setPersonalSecurityAnswer("Fietsen");
		return this;
	}
	
	public AopUsernameAndSecurityQuestionPage createAndEnterUsername() {
		
		myElements.sendKeys(driver, txtFieldUsername, MYTestDataUtil.generateUsername());
		return this;
	}
	
	public AopUsernameAndSecurityQuestionPage selectPersonalSecurityQuestion(String question) {
		
		myElements.select(driver, dropdownPersonalSecurityQuestion, question);
		return this;
	}
	
	public AopUsernameAndSecurityQuestionPage setPersonalSecurityAnswer(String answer) {
		
		myElements.sendKeys(driver, txtFieldPersonalSecurityAnswer, answer);
		return this;
	}
}
