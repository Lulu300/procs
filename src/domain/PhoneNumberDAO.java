package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sun.rowset.CachedRowSetImpl;

import domain.DAO;
import domain.PhoneNumber;

public class PhoneNumberDAO extends DAO
{
	
	public PhoneNumberDAO()
	{
		super();
	}
	
	public String addPhoneNumber(PhoneNumber phoneNumber)
	{
		String res = null;
		String query = "INSERT INTO phoneNumber (phoneKind, phoneNumber) VALUES(?, ?);";
		try 
		{
			super.setStmt(super.getCx().prepareStatement(query, Statement.RETURN_GENERATED_KEYS));
			super.getStmt().setString(1, phoneNumber.phoneKind);
			super.getStmt().setString(2, phoneNumber.phoneNumber);
			res = super.updateQuery();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return res;
	}
	
	public String editPhoneNumber(PhoneNumber phoneNumber)
	{
		String res = null;
		String query = "UPDATE phoneNumber SET phoneKind = ?, phoneNumber = ? WHERE id = ?;";
		try 
		{
			super.setStmt(super.getCx().prepareStatement(query, Statement.RETURN_GENERATED_KEYS));
			super.getStmt().setString(1, phoneNumber.phoneKind);
			super.getStmt().setString(2, phoneNumber.phoneNumber);
			super.getStmt().setInt(3, phoneNumber.id);
			res = super.updateQuery();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return res;
	}
	
	public PhoneNumber getPhoneNumber(int id) 
	{
		String query = "SELECT * FROM phoneNumber WHERE id = ?;";
    	CachedRowSetImpl crs = null;
    	PhoneNumber phone = null;
    	try 
		{
			super.setStmt(super.getCx().prepareStatement(query));
			super.getStmt().setLong(1, id);
			crs = super.executeQuery();
			while(crs.next())
			{
				String phoneKind = crs.getString("phoneKind");
				String phoneNumber = crs.getString("phoneNumber");
				phone = new PhoneNumber(id, phoneKind, phoneNumber);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
    	return phone;
	}
	
	public String removePhoneNumber(PhoneNumber phoneNumber)
	{
		String res = null;
		String query = "DELETE FROM phoneNumber WHERE id = ?;";
		try 
		{
			super.setStmt(super.getCx().prepareStatement(query));
			super.getStmt().setInt(1, phoneNumber.id);
			res = super.execute();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return res;
	}

}
