package domain;

import domain.DAO;
import models.Adresse;

public class AdresseDAO extends DAO {
	
    public AdresseDAO() {
        super();
    }
    
    public boolean save(Adresse adresse) {
    	boolean success;
    	
    	super.beginTransaction();
		try {
			super.getSession().save(adresse);
			success = true;
		} catch (Exception e) {
			success = false;
			e.printStackTrace();
		} finally {
			super.endTransaction();
		}
		
		return success;
	}
    
    public Adresse getAdresse(int id) {
		Adresse adresse = null;
		
		super.beginTransaction();
		try {
			adresse = (Adresse) super.getSession().get(Adresse.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			super.endTransaction();
		}
		
		return adresse;
	}
    
}
