package domain;

import java.util.List;

public class Contact extends Entreprise {

	public String lastName;
	public String firstName;
	public String email;
	public Address adress;
	public PhoneNumber phoneNumber;
	public List<Group> groups;

	public Contact(int id, String numsiret, String name, String lastName, String firstName, String email, Address adress, PhoneNumber phoneNumber, Entreprise entreprise, List<Group> groups) {
		super(id, numsiret, name);
		this.lastName = lastName;
		this.firstName = firstName;
		this.email = email;
		this.adress = adress;
		this.phoneNumber = phoneNumber;
		this.groups = groups;
	}
	
	public Contact(String numsiret, String name, String lastName, String firstName, String email, Address adress, PhoneNumber phoneNumber, Entreprise entreprise, List<Group> groups) {
		super(numsiret, name);
		this.lastName = lastName;
		this.firstName = firstName;
		this.email = email;
		this.adress = adress;
		this.phoneNumber = phoneNumber;
		this.groups = groups;
	}
	
	public List<Group> getGroups() {
		return groups;
	}

	public void setGroups(List<Group> groups) {
		this.groups = groups;
	}
	
	public Address getAdress() {
		return adress;
	}

	public void setAdress(Address adress) {
		this.adress = adress;
	}
	
	public PhoneNumber getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(PhoneNumber phoneNumber) {
		this.phoneNumber = phoneNumber;
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
