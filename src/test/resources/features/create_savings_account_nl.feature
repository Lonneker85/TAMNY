Feature: Create a savings account in the Netherlands
	As a Dutch prospect
	I want to open a savings account
	So that I can start using the services MoneYou offers in the Netherlands
	
	Scenario: Create a Vrij opneembaar savings account
		Given John is a prospective NL client
		And he wants to create a Vrij opneembaar savings account
		When he completes the NL AOP
		Then John is the proud owner of a Vrij opneembaar savings account