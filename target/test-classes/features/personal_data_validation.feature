Feature: Personal data validation
	As MoneYou
	I want to verify the personal data entered by a prospect
	So that only valid personal data enters my system

	@ignore	
	Scenario: BSN that is not 11-proof results in an error message
		Given John is a prospective client
		And John uses 123456789 as a BSN 
		And John wants to create a Vrij opneembaar savings account
		When he enters his bsn in the savings account AOP
		Then an error message is shown stating that the BSN is incorrect
		
	@ignore
	Scenario: Date of birth in the future results in an error message
		Given John is a prospective client
		And John uses 31122018 as a date of birth
		And John wants to create a Vrij opneembaar savings account
		When he enters his date of birth in the savings account AOP
		Then an error message is shown stating that the date of birth needs to be in the past