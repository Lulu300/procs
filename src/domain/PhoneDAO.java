package domain;

import domain.DAO;
import models.PhoneNumber;


public class PhoneDAO extends DAO {
	
    public PhoneDAO() {
        super();
    }
    
    public boolean save(PhoneNumber phoneNumber) {
    	boolean success;
    	
    	super.beginTransaction();
		try {
			super.getSession().save(phoneNumber);
			success = true;
		} catch (Exception e) {
			success = false;
			e.printStackTrace();
		} finally {
			super.endTransaction();
		}
		
		return success;
	}
    
    public PhoneNumber getPhoneNumber(int id) {
    	PhoneNumber adresse = null;
    	
		super.beginTransaction();
		try {
			adresse = (PhoneNumber) super.getSession().get(PhoneNumber.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			super.endTransaction();
		}
		
		return adresse;
	}
    
}
