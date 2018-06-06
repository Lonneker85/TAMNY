package stepdefinitions;

import globals.*;
import cucumber.api.java.en.*;
import dataentities.Prospect;

public class ClientDefinitionSteps extends SharedObjects {
	
	private SharedObjects _so;
	
	public ClientDefinitionSteps(SharedObjects sharedObjects) {
		
		_so = sharedObjects;
	}
	
	@Given("^(.*) is a prospective (.*) client$")
	public void is_a_prospective_client(String prospectName, String nationality) throws Throwable {
		
		_so.prospect = new Prospect(prospectName);
		
		switch(nationality.toUpperCase()) {
		case "NL":
			_so.prospect.setNationality(Nationalities.NL);
			break;
		case "DE":
			_so.prospect.setNationality(Nationalities.DE);
			break;
		case "AT":
			_so.prospect.setNationality(Nationalities.AT);
			break;
		case "BE":
			_so.prospect.setNationality(Nationalities.BE);
			break;
		default:
			throw new Error("I can't process the nationality '" + nationality + "' you supplied..");
		}
	}
	
	@Given("^(.*) uses (.*) as a BSN$")
	public void uses_as_a_bsn(String prospectName, String bsn) throws Throwable {
		
		_so.prospect.setBsn(bsn);
	}
	
	@Given("^(.*) uses (.*) as a date of birth$")
	public void uses_as_a_date_of_birth(String prospectName, String dateOfBirth) throws Throwable {
		
		_so.prospect.setDateOfBirth(dateOfBirth);
	}
}
