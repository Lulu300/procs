package service;

import domain.PhoneNumber;
import domain.PhoneNumberDAO;

public class PhoneNumberService {

	private PhoneNumberDAO phoneNumberDAO;
	
	public PhoneNumberService() {
		this.phoneNumberDAO = new PhoneNumberDAO();
	}
	
	public String saveOrUpdate(PhoneNumber phoneNumber) {
		return this.saveOrUpdate(phoneNumber);
	}
	
	public PhoneNumber getPhoneNumber(int id) {
		return this.phoneNumberDAO.getPhoneNumber(id);
	}
	
	public String removePhoneNumber(PhoneNumber phoneNumber) {
		return this.removePhoneNumber(phoneNumber);
	}
	
}
