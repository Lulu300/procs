package service;

import domain.AdresseDAO;
import models.Adresse;
import models.Contact;

public class AdresseService {
	
	private AdresseDAO adresseDAO;
	
	public AdresseService() {}
	
	public void setAdresseDAO(AdresseDAO adresseDAO) {
		this.adresseDAO = adresseDAO;
	}

	public void addAdresse(Adresse adresse) {
		this.adresseDAO.save(adresse);
	}
	
	public Adresse getAdresse(int id) {
		return this.adresseDAO.getAdresse(id);
	}
}