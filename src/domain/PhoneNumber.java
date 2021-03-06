package domain;

import java.io.Serializable;

public class PhoneNumber implements Serializable {

	private static final long serialVersionUID = -2309726161885701701L;
	public int id;
	public String phoneKind;
	public String phoneNumber;
	public long version;
	
	public PhoneNumber(int id, String phoneKind, String phoneNumber)
	{
		this.id = id;
		this.phoneKind = phoneKind;
		this.phoneNumber = phoneNumber;
	}
	
	public PhoneNumber(String phoneKind, String phoneNumber)
	{
		this.id = -1;
		this.phoneKind = phoneKind;
		this.phoneNumber = phoneNumber;
	}
	
	public PhoneNumber(int id)
	{
		this.id = id;
		this.phoneKind = "NULL";
		this.phoneNumber = "NULL";
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	
}
