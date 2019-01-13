package service;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import domain.ContactDAO;
import models.Company;
import models.Contact;

public class ContactService {
	
	private ContactDAO contactDAO;
	
	public ContactService() {}
	
	public void setContactDAO(ContactDAO contactDAO) {
		this.contactDAO = contactDAO;
	}
	
	public String saveOrUpdate(Contact contact) {
		return this.contactDAO.saveOrUpdateContact(contact);
	}
	
	public List<Company> getAllContacts() {
		return this.contactDAO.getAllContacts();
	}
	
	public Company getContact(int id) {
		return this.contactDAO.getContact(id);
	}
	
	public String removeContact(Contact contact) {
		return this.contactDAO.removeContact(contact);
	}
	
	public void merge(Contact contact) {
		this.contactDAO.merge(contact);
	}
	
	public void save(Contact contact) {
		this.contactDAO.save(contact);
	}
	
}
