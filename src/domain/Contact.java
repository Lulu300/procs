package domain;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

public class Contact implements Serializable {

	private static final long serialVersionUID = -2239017619970927960L;
	public int id;
	public String lastName;
	public String firstName;
	public String email;
	public Address address;
	public Set<PhoneNumber> phoneNumbers;
	public Set<Group> groups;
	public long version;

	public Contact(int id, String lastName, String firstName, String email, Address address, Set<PhoneNumber> phoneNumbers, Set<Group> groups) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.email = email;
		this.address = address;
		this.phoneNumbers = phoneNumbers;
		this.groups = groups;
	}
	
	public Contact(String lastName, String firstName, String email, Address address, Set<PhoneNumber> phoneNumbers, Set<Group> groups) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.email = email;
		this.address = address;
		this.phoneNumbers = phoneNumbers;
		this.groups = groups;
	}

	public Set<Group> getGroups() {
		return groups;
	}

	public void setGroups(Set<Group> groups) {
		this.groups = groups;
	}
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	public Set<PhoneNumber> getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(Set<PhoneNumber> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}
	
	public boolean addPhoneNumber(PhoneNumber phoneNumber) {
		return this.phoneNumbers.add(phoneNumber);
	}
	
	public boolean removePhoneNumber(PhoneNumber phoneNumber) {
		return this.phoneNumbers.remove(phoneNumber);
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
