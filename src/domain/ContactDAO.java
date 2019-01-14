package domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;

import domain.DAO;
import models.Company;
import models.Contact;


public class ContactDAO extends DAO 
{   
    public ContactDAO() {
        super();
    }
    
    public String saveOrUpdateContact(Contact contact) {
		String res = null;
		super.beginTransaction();
		try {
			super.getSession().saveOrUpdate(contact);
			res = "Successfully saving/updating contact";
		} catch (Exception e) {
			res = "failed to save or update";
			e.printStackTrace();
		} finally {
			super.endTransaction();
		}
		return res;
	}
	
	public Contact getContact(int id) {
		Contact contact = null;
		super.beginTransaction();
		try {
			contact = (Contact) super.getSession().get(Contact.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			super.endTransaction();
		}
		return contact;
		
	}
	
	public String removeContact(Contact contact) {
		String res = null;
		try {
			super.beginTransaction();
			super.getSession().delete(contact);
			res = "Successfully removing contact with id " + contact.getId();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			super.endTransaction();
		}
		return res;
	}
	
	public List<Company> getAllContacts() {
		List<Company> contacts = new ArrayList<Company>();
		
		super.beginTransaction();
		try {
			List res = super.getSession().createQuery("select distinct contact from Contact contact left join fetch contact.phoneNumbers phone").list();
			for (int i=0; i < res.size(); i++) {
				Company c;
				if (res.get(i).getClass().getName().equals("models.Contact")) {
					c = new Company((Contact) res.get(i), null, null);
				} else {
					c = (Company) res.get(i);
				}
				contacts.add(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			super.endTransaction();
		}
		return contacts;
	}
	
	public void merge(Contact contact) {
		super.beginTransaction();
		try {
			super.getSession().merge(contact);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			super.endTransaction();
		}
	}
	
	public void save(Contact contact) {
		super.beginTransaction();
		try {
			super.getSession().save(contact);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			super.endTransaction();
		}
	}
	
	public void save(Company company) {
		super.beginTransaction();
		try {
			super.getSession().save(company);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			super.endTransaction();
		}
	}
}
