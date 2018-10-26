package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sun.rowset.CachedRowSetImpl;

import domain.DAO;
import domain.Contact;


public class ContactDAO extends DAO 
{   
    public ContactDAO() {
        super();
    }
    
    public List<Contact> getAllContacts()
    {
    	List<Contact> contacts = new ArrayList<Contact>();
    	String query = "SELECT * FROM contact;";
    	CachedRowSetImpl crs = null;
    	try 
		{
			super.setStmt(super.getCx().prepareStatement(query));
			crs = super.executeQuery();
			while(crs.next())
			{
				int id = crs.getInt("id");
				String firstName = crs.getString("firstName");
				String lastName = crs.getString("lastName");
				String email = crs.getString("email");
				int idEntreprise = crs.getInt("idEntreprise");
				EntrepriseDAO entrepriseDAO = new EntrepriseDAO();
				Entreprise entreprise = entrepriseDAO.getEntreprise(idEntreprise);
				if (entreprise == null)
				{
					entreprise = new Entreprise(-1);
				}
				
				int idAdress = crs.getInt("idAdress");
				AdressDAO adressDAO = new AdressDAO();
				Adress adress = adressDAO.getAdress(idAdress);
				
				int idPhoneNumber = crs.getInt("idPhoneNumber");
				PhoneNumberDAO phoneNumberDAO = new PhoneNumberDAO();
				PhoneNumber phone = phoneNumberDAO.getPhoneNumber(idPhoneNumber);
				
				ContactGroupDAO cgDAO = new ContactGroupDAO();
				List<Group> groups = cgDAO.getAllContactGroups(id);
				
				contacts.add(new Contact(id, lastName, firstName, email, adress, phone, entreprise, groups));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
    	return contacts;
    }

	public String removeContact(Contact contact)
	{
		String res = null;
		String query = "DELETE FROM contact WHERE id = ?;";
		try 
		{
			super.setStmt(super.getCx().prepareStatement(query));
			super.getStmt().setInt(1, contact.id);
			res = super.execute();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return res;
	}
	
	public String editContact(Contact contact)
	{
		String res = null;
		String query = "UPDATE contact SET firstName = ?, lastName = ?, email = ?, idEntreprise = ?, idAdress = ?, idPhoneNumber = ? WHERE id = ?;";
		try 
		{
			super.setStmt(super.getCx().prepareStatement(query, Statement.RETURN_GENERATED_KEYS));
			super.getStmt().setString(1, contact.firstName);
			super.getStmt().setString(2, contact.lastName); 
			super.getStmt().setString(3, contact.email);
			if (contact.entreprise.getId() == -1)
				super.getStmt().setNull(4, java.sql.Types.INTEGER);
			else
				super.getStmt().setInt(4, contact.entreprise.getId());
			if (contact.adress.getId() == -1)
				super.getStmt().setNull(5, java.sql.Types.INTEGER);
			else
				super.getStmt().setInt(5, contact.adress.getId());
			if (contact.phoneNumber.getId() == -1)
				super.getStmt().setNull(6, java.sql.Types.INTEGER);
			else
				super.getStmt().setInt(6, contact.phoneNumber.getId());
			super.getStmt().setInt(7, contact.id);
			res = super.updateQuery();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return res;
	}
	
	public String addContact(Contact contact)
	{
		String res = null;
		String query = "INSERT INTO contact (firstName, lastName, email, idEntreprise, idAdress, idPhoneNumber) VALUES(?, ?, ?, ?, ?, ?);";
		try 
		{
			super.setStmt(super.getCx().prepareStatement(query, Statement.RETURN_GENERATED_KEYS));
			super.getStmt().setString(1, contact.firstName);
			super.getStmt().setString(2, contact.lastName); 
			super.getStmt().setString(3, contact.email);
			if (contact.entreprise.getId() == -1)
				super.getStmt().setNull(4, java.sql.Types.INTEGER);
			else
				super.getStmt().setInt(4, contact.entreprise.getId());
			if (contact.adress.getId() == -1)
				super.getStmt().setNull(5, java.sql.Types.INTEGER);
			else
				super.getStmt().setInt(5, contact.adress.getId());
			if (contact.phoneNumber.getId() == -1)
				super.getStmt().setNull(6, java.sql.Types.INTEGER);
			else
				super.getStmt().setInt(6, contact.phoneNumber.getId());
			res = super.updateQuery();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return res;
	}
	
	public String searchContact(String search)
	{
		return "Je suis la méthode searchContact, vous avez cherchez : " + search;
	}

	public Contact getContact(int id) 
	{
		String query = "SELECT * FROM contact WHERE id = ?;";
    	CachedRowSetImpl crs = null;
    	Contact contact = null;
    	try 
		{
			super.setStmt(super.getCx().prepareStatement(query));
			super.getStmt().setLong(1, id);
			crs = super.executeQuery();
			while(crs.next())
			{
				String firstName = crs.getString("firstName");
				String lastName = crs.getString("lastName");
				String email = crs.getString("email");
				int idEntreprise = crs.getInt("idEntreprise");
				EntrepriseDAO entrepriseDAO = new EntrepriseDAO();
				Entreprise entreprise = entrepriseDAO.getEntreprise(idEntreprise);
				if (entreprise == null)
				{
					entreprise = new Entreprise(-1);
				}
				
				int idAdress = crs.getInt("idAdress");
				AdressDAO adressDAO = new AdressDAO();
				Adress adress = adressDAO.getAdress(idAdress);
				
				int idPhoneNumber = crs.getInt("idPhoneNumber");
				PhoneNumberDAO phoneNumberDAO = new PhoneNumberDAO();
				PhoneNumber phone = phoneNumberDAO.getPhoneNumber(idPhoneNumber);
				ContactGroupDAO cgDAO = new ContactGroupDAO();
				List<Group> groups = cgDAO.getAllContactGroups(id);
				contact = new Contact(id, firstName, lastName, email, adress, phone, entreprise, groups);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
    	return contact;
	}

}
