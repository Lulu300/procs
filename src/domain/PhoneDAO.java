package domain;

import org.hibernate.SessionFactory;

import domain.DAO;
import models.PhoneNumber;


public class PhoneDAO extends DAO {
	
    public PhoneDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
    
    public boolean save(PhoneNumber phoneNumber) {
    	boolean success;
		try {
			super.getSessionFactory().getCurrentSession().save(phoneNumber);
			success = true;
		} catch (Exception e) {
			success = false;
			e.printStackTrace();
		}
		
		return success;
	}
    
    public PhoneNumber getPhoneNumber(int id) {
    	PhoneNumber phone = null;
		try {
			phone = (PhoneNumber) super.getSessionFactory().getCurrentSession().get(PhoneNumber.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return phone;
	}
    
}
