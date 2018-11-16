package domain;

import domain.DAO;
import domain.PhoneNumber;

public class PhoneNumberDAO extends DAO {
	
	public PhoneNumberDAO() {
		super();
	}
	
	public String saveOrUpdatePhoneNumber(PhoneNumber phoneNumber) {
		String res = null;
		super.beginTransaction();
		try {
			super.getSession().saveOrUpdate(phoneNumber);
			res = "Successfully saving/updating phoneNumber";
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			super.endTransaction();
		}
		return res;
	}
	
	public PhoneNumber getPhoneNumber(int id) {
		return (PhoneNumber) super.getSession().get(PhoneNumber.class, id);
	}
	
	public String removePhoneNumber(PhoneNumber phoneNumber) {
		String res = null;
		try {
			super.getSession().delete(phoneNumber);
			res = "Successfully removing phoneNumber with id " + phoneNumber.getId();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			super.endTransaction();
		}
		return res;
	} 

}
