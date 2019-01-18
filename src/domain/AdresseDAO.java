package domain;

import org.hibernate.SessionFactory;

import domain.DAO;
import models.Adresse;

public class AdresseDAO extends DAO {
	
    public AdresseDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
    
    public boolean save(Adresse adresse) {
    	boolean success;
    	
    	// super.beginTransaction();
		try {
			super.getSessionFactory().getCurrentSession().save(adresse);
			success = true;
		} catch (Exception e) {
			success = false;
			e.printStackTrace();
		} finally {
			// super.endTransaction();
		}
		
		return success;
	}
    
    public Adresse getAdresse(int id) {
		Adresse adresse = null;
		
		// super.beginTransaction();
		try {
			adresse = (Adresse) super.getSessionFactory().getCurrentSession().get(Adresse.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// super.endTransaction();
		}
		
		return adresse;
	}
    
}
