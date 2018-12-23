package models;

public class PhoneNumber {
	public int id;
	private int version;
	public String phoneKind;
	public String phoneNumber;
	public Contact contact;

	public PhoneNumber() { }

	public PhoneNumber(String phoneKind, String phoneNumber) {
		this.phoneKind = phoneKind;
		this.phoneNumber = phoneNumber;
	}
	
	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public String getPhoneKind() {
		return phoneKind;
	}

	public void setPhoneKind(String phoneKind) {
		this.phoneKind = phoneKind;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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
}
