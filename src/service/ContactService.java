package service;

import java.util.List;

import domain.Contact;
import domain.ContactDAO;

public class ContactService {
	
	private ContactDAO contactDAO;
	
	public ContactService() {
		this.contactDAO = new ContactDAO();
	}
	
	public String saveOrUpdate(Contact contact) {
		return this.contactDAO.saveOrUpdateContact(contact);
	}
	
	public List<Contact> getAllContacts() {
		return this.contactDAO.getAllContacts();
	}
	
	public Contact getContact(int id) {
		return this.contactDAO.getContact(id);
	}
	
	public String removeContact(Contact contact) {
		return this.removeContact(contact);
	}
	
}
