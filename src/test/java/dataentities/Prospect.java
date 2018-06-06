package dataentities;

import helpers.MYTestDataUtil;

public class Prospect {
	
	String prospectName;
	String salutation;
	String initials;
	String middleName;
	String lastName;
	String dateOfBirth;
	String bsn;
	String idExpiryDate;
	String nationality;
	ContactDetails contactDetails;
	
	public Prospect(String prospectName) {
		
		this.prospectName = prospectName;
		this.salutation = ProspectDefaultData.SALUTATION;
		this.initials = ProspectDefaultData.INITIALS;
		this.middleName = ProspectDefaultData.MIDDLE_NAME;
		this.lastName = ProspectDefaultData.LAST_NAME;
		this.dateOfBirth = ProspectDefaultData.DATE_OF_BIRTH;
		this.bsn = MYTestDataUtil.generateBsn();
		this.idExpiryDate = ProspectDefaultData.ID_EXPIRY_DATE;
		this.nationality = ProspectDefaultData.NATIONALITY;
		this.contactDetails = new ContactDetails();
	}
	
	public String getSalutation() {
		return salutation;
	}

	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}

	public String getInitials() {
		return initials;
	}

	public void setInitials(String initials) {
		this.initials = initials;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getBsn() {
		return bsn;
	}

	public void setBsn(String bsn) {
		this.bsn = bsn;
	}

	public String getIdExpiryDate() {
		return idExpiryDate;
	}

	public void setIdExpiryDate(String idExpiryDate) {
		this.idExpiryDate = idExpiryDate;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	
	public ContactDetails getContactDetails() {
		return contactDetails;		
	}
}
