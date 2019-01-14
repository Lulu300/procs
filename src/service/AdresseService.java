package service;

import domain.AdresseDAO;
import models.Adresse;

public class AdresseService {
	
	private AdresseDAO adresseDAO;
	
	public AdresseService() {}
	
	public void setAdresseDAO(AdresseDAO adresseDAO) {
		this.adresseDAO = adresseDAO;
	}

	public boolean addAdresse(Adresse adresse) {
		return this.adresseDAO.save(adresse);
	}
	
	public Adresse getAdresse(int id) {
		return this.adresseDAO.getAdresse(id);
	}
	
}