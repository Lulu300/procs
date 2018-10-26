package domain;

import java.sql.SQLException;
import java.sql.Statement;
import com.sun.rowset.CachedRowSetImpl;

import domain.DAO;
import domain.Adress;

public class AdressDAO extends DAO
{
	
	public AdressDAO()
	{
		super();
	}
	
	public String addAdress(Adress adress)
	{
		String res = null;
		String query = "INSERT INTO address (country, city, zip, street) VALUES(?, ?, ?, ?);";
		try 
		{
			super.setStmt(super.getCx().prepareStatement(query, Statement.RETURN_GENERATED_KEYS));
			super.getStmt().setString(1, adress.country);
			super.getStmt().setString(2, adress.city);
			super.getStmt().setString(3, adress.zip);
			super.getStmt().setString(4, adress.street);
			res = super.updateQuery();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return res;
	}
	
	public String editAdress(Adress adress)
	{
		String res = null;
		String query = "UPDATE adress SET country = ?, city = ?, zip = ?, street = ? WHERE id = ?;";
		try 
		{
			super.setStmt(super.getCx().prepareStatement(query, Statement.RETURN_GENERATED_KEYS));
			super.getStmt().setString(1, adress.country);
			super.getStmt().setString(2, adress.city);
			super.getStmt().setString(3, adress.zip);
			super.getStmt().setString(4, adress.street);
			super.getStmt().setInt(5, adress.id);
			res = super.updateQuery();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return res;
	}
	
	public Adress getAdress(int id) 
	{
		String query = "SELECT * FROM address WHERE id = ?;";
    	CachedRowSetImpl crs = null;
    	Adress adress = null;
    	try 
		{
			super.setStmt(super.getCx().prepareStatement(query));
			super.getStmt().setLong(1, id);
			crs = super.executeQuery();
			while(crs.next())
			{
				String country = crs.getString("country");
				String city = crs.getString("city");
				String zip = crs.getString("zip");
				String street = crs.getString("street");
				adress = new Adress(id, street, city, zip, country);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
    	return adress;
	}
	
	public String removeAdress(Adress adress)
	{
		String res = null;
		String query = "DELETE FROM address WHERE id = ?;";
		try 
		{
			super.setStmt(super.getCx().prepareStatement(query));
			super.getStmt().setInt(1, adress.id);
			res = super.execute();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return res;
	}

}
