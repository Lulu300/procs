package service;

import java.util.List;

import domain.ContactDAO;
import models.Contact;

public class ContactService {
	
	private ContactDAO contactDAO;
	
	public ContactService() {}
	
	public void setContactDAO(ContactDAO contactDAO) {
		this.contactDAO = contactDAO;
	}
	
	public List<Contact> getAllContacts() {
		return this.contactDAO.getAllContacts();
	}
	
	public Contact getContact(int id) {
		return this.contactDAO.getContact(id);
	}
	
	public boolean removeContact(Contact contact) {
		return this.contactDAO.removeContact(contact);
	}
	
	public boolean merge(Contact contact) {
		return this.contactDAO.merge(contact);
	}
	
	public boolean save(Contact contact) {
		return this.contactDAO.save(contact);
	}
	
}
