package domain;

import java.util.ArrayList;
import java.util.List;
import domain.DAO;
import domain.Contact;


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
			e.printStackTrace();
		} finally {
			super.endTransaction();
		}
		return res;
	}
	
	public Contact getContact(int id) {
		return (Contact) super.getSession().get(Contact.class, id);
	}
	
	public String removeContact(Contact contact) {
		String res = null;
		try {
			super.getSession().delete(contact);
			res = "Successfully removing contact with id " + contact.getId();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			super.endTransaction();
		}
		return res;
	}
	
	public List<Contact> getAllContacts() {
		List<Contact> contacts = new ArrayList<Contact>();
		StringBuffer request = new StringBuffer();
		request.append("SELECT contact FROM Contact contact");
		super.beginTransaction();
		for (final Object o : super.getSession().createCriteria(Contact.class).list()) {
			contacts.add((Contact) o);
		}
		super.endTransaction();
		return contacts;
	}

}
