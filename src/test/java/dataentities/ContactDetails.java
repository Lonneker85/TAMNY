package dataentities;

public class ContactDetails {
	
	String zipCode;
	String houseNumber;
	String houseNumberExt;
	String street;
	String city;
	String emailAddress;
	String telephoneNumber;
	
	public ContactDetails() {
		
		this.zipCode = ContactDetailsDefaultData.ZIPCODE;
		this.houseNumber = ContactDetailsDefaultData.HOUSE_NUMBER;
		this.houseNumberExt = ContactDetailsDefaultData.HOUSE_NUMBER_EXT;
		this.street = ContactDetailsDefaultData.STREET;
		this.city = ContactDetailsDefaultData.CITY;
		this.emailAddress = ContactDetailsDefaultData.EMAIL_ADDRESS;
		this.telephoneNumber = ContactDetailsDefaultData.TELEPHONE_NUMBER;
	}
	
	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getHouseNumberExt() {
		return houseNumberExt;
	}

	public void setHouseNumberExt(String houseNumberExt) {
		this.houseNumberExt = houseNumberExt;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}
}
