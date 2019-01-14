package service;

import domain.PhoneDAO;
import models.PhoneNumber;

public class PhoneService {
	
	private PhoneDAO phoneDAO;
	
	public PhoneService() {}
	
	public void setPhoneDAO(PhoneDAO phoneDAO) {
		this.phoneDAO = phoneDAO;
	}
	
	public boolean addPhoneNumber(PhoneNumber phoneNumber) {
		return this.phoneDAO.save(phoneNumber);
	}
	
	public PhoneNumber getPhoneNumber(int id) {
		return this.phoneDAO.getPhoneNumber(id);
	}
	
}