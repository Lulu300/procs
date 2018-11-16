package domain;

import domain.DAO;
import domain.Address;

public class AdressDAO extends DAO {
	
	public AdressDAO() {
		super();
	}
	
	public String saveOrUpdateAddress(Address address) {
		String res = null;
		super.beginTransaction();
		try {
			super.getSession().saveOrUpdate(address);
			res = "Successfully saving/updating address";
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			super.endTransaction();
		}
		return res;
	}
	
	public Address getAddress(int id) {
		return (Address) super.getSession().get(Address.class, id);
	}
	
	public String removeAddress(Address address) {
		String res = null;
		try {
			super.getSession().delete(address);
			res = "Successfully removing address with id " + address.getId();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			super.endTransaction();
		}
		return res;
	}
}