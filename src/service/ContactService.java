package service;

import domain.ContactDAO;

public class ContactService {
	
	private ContactDAO contactDAO;
	
	public ContactService() {
		this.contactDAO = new ContactDAO();
	}
	
	public String saveOrUpdate() {
		return "TODO";
	}
	
}
