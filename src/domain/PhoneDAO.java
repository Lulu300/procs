package domain;

import domain.DAO;
import models.PhoneNumber;


public class PhoneDAO extends DAO 
{   
    public PhoneDAO() {
        super();
    }
    
    public void save(PhoneNumber phoneNumber) {
		try {
			super.beginTransaction();
			super.getSession().save(phoneNumber);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			super.endTransaction();
		}
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
