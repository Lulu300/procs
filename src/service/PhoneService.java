package service;

import domain.PhoneDAO;
import models.PhoneNumber;

public class PhoneService {
	
	private PhoneDAO phoneDAO;
	
	public PhoneService() {
		this.phoneDAO = new PhoneDAO();
	}
	
	public void addPhoneNumber(PhoneNumber phoneNumber) {
		this.phoneDAO.save(phoneNumber);
	}
	
	public PhoneNumber getPhoneNumber(int id) {
		return this.phoneDAO.getPhoneNumber(id);
	}
}