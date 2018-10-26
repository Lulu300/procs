package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sun.rowset.CachedRowSetImpl;

public class ContactGroupDAO extends DAO
{

	public ContactGroupDAO()
	{
		super();
	}
	
	public String addContactGroup(int idContact, int idGroup)
	{
		String res = null;
		String query = "INSERT INTO `contactGroup` (idGroup, idContact) VALUES(?, ?);";
		try 
		{
			super.setStmt(super.getCx().prepareStatement(query, Statement.RETURN_GENERATED_KEYS));
			super.getStmt().setInt(1, idGroup);
			super.getStmt().setInt(2, idContact);
			res = super.updateQuery();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return res;
	}
	
	public String removeContactGroup(Contact contact)
	{
		String res = null;
		String query = "DELETE FROM contactGroup WHERE idContact = ?;";
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
	
	public List<Group> getAllContactGroups(int idContact)
    {
    	List<Group> groups = new ArrayList<Group>();
    	String query = "SELECT * FROM `contactGroup` WHERE idContact = ?;";
    	CachedRowSetImpl crs = null;
    	try 
		{
			super.setStmt(super.getCx().prepareStatement(query));
			super.getStmt().setInt(1, idContact);
			crs = super.executeQuery();
			GroupDAO groupDAO = new GroupDAO();
			while(crs.next())
			{
				int idGroup = crs.getInt("idGroup");
				
				groups.add(groupDAO.getGroup(idGroup));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
    	return groups;
    }
	
}
