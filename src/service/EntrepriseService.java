package service;

import java.util.List;

import domain.Contact;
import domain.Entreprise;
import domain.EntrepriseDAO;

public class EntrepriseService {

private EntrepriseDAO entrepriseDAO;
	
	public EntrepriseService() {
		this.entrepriseDAO = new EntrepriseDAO();
	}
	
	public String saveOrUpdate(Entreprise entreprise) {
		return this.entrepriseDAO.saveOrUpdateEntreprise(entreprise);
	}
	
	public List<Entreprise> getAllEntreprises() {
		return this.entrepriseDAO.getAllEntreprises();
	}
	
	public Contact getEntreprise(int id) {
		return this.entrepriseDAO.getEntreprise(id);
	}
	
	public String removeEntreprise(Entreprise entreprise) {
		return this.removeEntreprise(entreprise);
	}
	
}
