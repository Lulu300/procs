package service;

import domain.AdresseDAO;
import models.Adresse;
import models.Contact;

public class AdresseService {
	
	private AdresseDAO adresseDAO;
	
	public AdresseService() {
		this.adresseDAO = new AdresseDAO();
	}
	
	public void addAdresse(Adresse adresse) {
		this.adresseDAO.save(adresse);
	}
	
	public Adresse getAdresse(int id) {
		return this.adresseDAO.getAdresse(id);
	}
}