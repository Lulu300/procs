package domain;

import domain.DAO;
import models.Adresse;
import models.Contact;


public class AdresseDAO extends DAO 
{   
    public AdresseDAO() {
        super();
    }
    
    public void save(Adresse adresse) {
		try {
			super.beginTransaction();
			super.getSession().save(adresse);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			super.endTransaction();
		}
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
