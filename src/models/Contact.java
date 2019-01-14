package models;

import java.util.Set;

public class Contact {
	
	public int id;
	public String lastName;
	public String firstName;
	public String email;
	private int version;
	public Adresse adresse;
	public Set<PhoneNumber> phoneNumbers;
	public Set<Group> groups;

	public Contact() {}
	
	public Contact(String lastName, String firstName, String email, Adresse adresse, Set<PhoneNumber> phoneNumbers, Set<Group> groups) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.email = email;
		this.adresse = adresse;
		this.phoneNumbers = phoneNumbers;
		this.groups = groups;
	}
	
	public Contact(int id, String lastName, String firstName, String email, Adresse adresse, Set<PhoneNumber> phoneNumbers, Set<Group> groups) {
		this.id = id;
		this.lastName = lastName;
		this.firstName = firstName;
		this.email = email;
		this.adresse = adresse;
		this.phoneNumbers = phoneNumbers;
		this.groups = groups;
	}

	public Set<Group> getGroups() {
		return groups;
	}

	public void setGroups(Set<Group> groups) {
		this.groups = groups;
	}

	public Set<PhoneNumber> getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(Set<PhoneNumber> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "Contact [id=" + this.id + ", lastName=" + lastName + ", firstName=" + firstName + ", email=" + email + "]";
	}
	
}
