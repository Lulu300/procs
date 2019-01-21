package domain;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.stat.Statistics;

import domain.DAO;
import models.Contact;
import util.HibernateUtil;


public class ContactDAO extends DAO {
	
    public ContactDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
	
	public Contact getContact(int id) {
		Contact contact = null;
		
		// super.beginTransaction();
		try {
			System.out.println("hello");
			contact = (Contact) this.sessionFactory.getCurrentSession().get(Contact.class, id);
			System.out.println("hello 2");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// super.endTransaction();
		}
		
		return contact;
	}
	
	public boolean removeContact(Contact contact) {
		boolean success;
		
		// super.beginTransaction();
		try {
			this.sessionFactory.getCurrentSession().delete(contact);
			success = true;
		} catch (Exception e) {
			success = false;
			e.printStackTrace();
		} finally {
			// super.endTransaction();
		}
		
		return success;
	}

	public List<Contact> getAllContacts() {
		List<Contact> contacts = new ArrayList<Contact>();	
		// super.beginTransaction();
		try {
			List cs = this.sessionFactory.getCurrentSession().createCriteria(Contact.class).addOrder(Order.asc("lastName")).list();
			for (int i=0; i < cs.size(); i++) {
				Contact c = (Contact) cs.get(i);
				contacts.add(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// super.endTransaction();
		}
		
		return contacts;
	}
	
	public boolean merge(Contact contact) {
		boolean success;
		
		// super.beginTransaction();
		try {
			this.sessionFactory.getCurrentSession().merge(contact);
			success = true;
		} catch (Exception e) {
			success = false;
			e.printStackTrace();
		} finally {
			// super.endTransaction();
		}
		
		return success;
	}
	
	public boolean save(Contact contact) {
		boolean success;
		
		// super.beginTransaction();
		try {
			this.sessionFactory.getCurrentSession().save(contact);
			success = true;
		} catch (Exception e) {
			success = false;
			e.printStackTrace();
		} finally {
			// super.endTransaction();
		}
		
		return success;
	}
	
}
