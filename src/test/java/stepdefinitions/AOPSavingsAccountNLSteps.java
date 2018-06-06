package stepdefinitions;

import globals.*;
import helpers.MYAssert;
import helpers.MYElements;

import org.openqa.selenium.Keys;

import pages.*;
import pages.aop.*;
import pages.aop.nl.*;
import cucumber.api.java.en.*;

public class AOPSavingsAccountNLSteps extends SharedObjects {
	
	private SharedObjects _so;
	private MYElements myElements = new MYElements();
	private MYAssert myAssert = new MYAssert();
	
	public AOPSavingsAccountNLSteps(SharedObjects sharedObjects) {
		
		_so = sharedObjects;
	}
	
	@Given("^he wants to create a (.*) savings account$")
	public void wants_to_create_a_savings_account(String accountType) throws Throwable {
	
		new AopIntroPage(_so.driver).
			loadAOP(accountType);
		
		new CookieWall(_so.driver).
			acceptCookies();
		
		new AopIntroPage(_so.driver).
			openAccountForSelf();
	}
	
	@When("^he completes the NL AOP$")
	public void he_completes_the_NL_AOP() throws Throwable {
		
		new AopIdentificationPage(_so.driver).
			setDefaultIdentification();
		
		new AopPersonalDataNLPage(_so.driver).
			setGender(_so.prospect.getSalutation()).
			setBsn(_so.prospect.getBsn());
		
		new AopContactDetailsPage(_so.driver).
			setDefaultContactDetails(_so.prospect).
			clickButtonNextStep();
		
		new AopUsernameAndSecurityQuestionPage(_so.driver).
			setDefaultUsernameAndSecurityQuestion();
		
		new AopTermsAndConditionsPage(_so.driver).
			checkTermsAndConditions().
			clickButtonNextStep();
		
		new AopIdealTransferPage(_so.driver).
			performDefaultIdealTransfer().
			clickButtonNextStep();
		
		new AopSummaryPage(_so.driver).
			finishAOP();
	}
	
	@When("^he enters his bsn in the savings account AOP")
	public void he_enters_his_bsn_in_the_savings_account_AOP() throws Throwable {
	
		new AopPersonalDataNLPage(_so.driver).
			setBsn(_so.prospect.getBsn());
	}
	
	@When("^he enters his date of birth in the savings account AOP")
	public void he_enters_his_date_of_birth_in_the_savings_account_AOP() throws Throwable {
	
		new AopPersonalDataNLPage(_so.driver).
			setDateOfBirth(_so.prospect.getDateOfBirth());
	}

	@Then("^(.*) is the proud owner of a (.*) savings account$")
	public void is_the_proud_owner_of_a_savings_account(String prospectName, String accountType) throws Throwable {
		
		myAssert.assertTrue(_so.driver, new AopConfirmationPage(_so.driver).isAt(), "AOP confirmation page is shown");
	}
	
	@Then("^an error message is shown stating that the BSN is incorrect$")
	public void an_error_message_is_shown_stating_that_the_bsn_is_incorrect() throws Throwable {
		
		// send a TAB to the browser to make sure that the BSN entered is validated
		myElements.sendKeysToBrowser(_so.driver, Keys.TAB);
		
		myAssert.assertTrue(_so.driver, new AopPersonalDataNLPage(_so.driver).errorMessageIsShown(ErrorMessages.AOP_BSN_INCORRECT), "Error message stating that BSN is incorrect is shown on the page");
	}
	
	@Then("^an error message is shown stating that the date of birth needs to be in the past$")
	public void an_error_message_is_shown_stating_that_the_date_of_birth_needs_to_be_in_the_past() throws Throwable {
		
		// send a TAB to the browser to make sure that the date of birth entered is validated
		myElements.sendKeysToBrowser(_so.driver, Keys.TAB);
		
		myAssert.assertTrue(_so.driver, new AopPersonalDataNLPage(_so.driver).errorMessageIsShown(ErrorMessages.AOP_DATE_OF_BIRTH_NOT_IN_THE_PAST), "Error message stating that date of birth needs to be in the future is shown on the page");
	}

}
