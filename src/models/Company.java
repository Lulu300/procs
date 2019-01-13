package models;

import java.util.Set;

public class Company extends Contact {
	
	private String numSiret;
	private String name;
	
	public Company() {}
	
	
	
	public Company(Contact contact, String numSiret, String name) {
		super(contact.id, contact.lastName, contact.firstName, contact.email, contact.adresse, contact.phoneNumbers, contact.groups);
		this.numSiret = numSiret;
		this.name = name;
	}
	
	public Company(String lastName, String firstName, String email, Adresse adresse, Set<PhoneNumber> phoneNumbers, Set<Group> groups, String numSiret, String name) {
		super(lastName, firstName, email, adresse, phoneNumbers, groups);
		this.numSiret = numSiret;
		this.name = name;
	}
	public Company(int id, String lastName, String firstName, String email, Adresse adresse, Set<PhoneNumber> phoneNumbers, Set<Group> groups, String numSiret, String name) {
		super(id, lastName, firstName, email, adresse, phoneNumbers, groups);
		this.numSiret = numSiret;
		this.name = name;
	}

	public String getNumSiret() {
		return numSiret;
	}

	public void setNumSiret(String numSiret) {
		this.numSiret = numSiret;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Company [numSiret=" + numSiret + ", name=" + name + ", id=" + id + ", lastName=" + lastName
				+ ", firstName=" + firstName + ", email=" + email + ", adresse=" + adresse + ", phoneNumbers="
				+ phoneNumbers + ", groups=" + groups + "]";
	}

}
