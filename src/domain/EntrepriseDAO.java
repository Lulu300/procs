package domain;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sun.rowset.CachedRowSetImpl;

import domain.DAO;
import domain.Entreprise;

public class EntrepriseDAO extends DAO
{
	
	public EntrepriseDAO()
	{
		super();
	}
	
	public String addEntreprise(Entreprise entreprise)
	{
		String res = null;
		String query = "INSERT INTO entreprise (numsiret, name) VALUES(?, ?);";
		try 
		{
			super.setStmt(super.getCx().prepareStatement(query, Statement.RETURN_GENERATED_KEYS));
			super.getStmt().setString(1, entreprise.numsiret);
			super.getStmt().setString(2, entreprise.name);
			res = super.updateQuery();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return res;
	}
	
	public String editEntreprise(Entreprise entreprise)
	{
		String res = null;
		String query = "UPDATE entreprise SET numsiret = ?, name = ? WHERE id = ?;";
		try 
		{
			super.setStmt(super.getCx().prepareStatement(query, Statement.RETURN_GENERATED_KEYS));
			super.getStmt().setString(1, entreprise.numsiret);
			super.getStmt().setString(2, entreprise.name);
			super.getStmt().setInt(3, entreprise.id);
			res = super.updateQuery();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return res;
	}
	
	public Entreprise getEntreprise(int id) 
	{
		String query = "SELECT * FROM entreprise WHERE id = ?;";
    	CachedRowSetImpl crs = null;
    	Entreprise entreprise = null;
    	try 
		{
			super.setStmt(super.getCx().prepareStatement(query));
			super.getStmt().setLong(1, id);
			crs = super.executeQuery();
			while(crs.next())
			{
				String numsiret = crs.getString("numsiret");
				String name = crs.getString("name");
				entreprise = new Entreprise(id, numsiret, name);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
    	return entreprise;
	}

	public List<Entreprise> getAllEntreprises() 
	{
		List<Entreprise> entreprises = new ArrayList<Entreprise>();
    	String query = "SELECT * FROM entreprise;";
    	CachedRowSetImpl crs = null;
    	try 
		{
			super.setStmt(super.getCx().prepareStatement(query));
			crs = super.executeQuery();
			while(crs.next())
			{
				int id = crs.getInt("id");
				String numsiret = crs.getString("numsiret");
				String name = crs.getString("name");
				entreprises.add(new Entreprise(id, numsiret, name));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
    	return entreprises;
	}

}
