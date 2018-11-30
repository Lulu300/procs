package domain;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;

import domain.DAO;
import domain.Entreprise;

public class EntrepriseDAO extends DAO {
	
	public EntrepriseDAO() {
		super();
	}
	
	public String saveOrUpdateEntreprise(Entreprise entreprise) {
		String res = null;
		super.beginTransaction();
		try {
			super.getSession().saveOrUpdate(entreprise);
			res = "Successfully saving/updating entreprise";
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			super.endTransaction();
		}
		return res;
	}
	
	public Entreprise getEntreprise(int id) {
		return (Entreprise) super.getSession().get(Entreprise.class, id);
	}
	
	public String removeEntreprise(Entreprise entreprise) {
		String res = null;
		try {
			super.getSession().delete(entreprise);
			res = "Successfully removing address with id " + entreprise.getId();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			super.endTransaction();
		}
		return res;
	}
	
	public List<Entreprise> getAllEntreprises() {
		List<Entreprise> entreprises = new ArrayList<Entreprise>();
		StringBuffer request = new StringBuffer();
		request.append("SELECT entreprise FROM Entreprise entreprise");
		for (final Object o : super.getSession().createCriteria(Entreprise.class).list()) {
			entreprises.add((Entreprise) o);
		}
		return entreprises;
	}
}
