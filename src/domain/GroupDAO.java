package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sun.rowset.CachedRowSetImpl;

import domain.Group;

public class GroupDAO extends DAO
{

	public GroupDAO() 
	{
        super();
    }
	
	public List<Group> getAllGroups()
    {
    	List<Group> groups = new ArrayList<Group>();
    	String query = "SELECT * FROM `group`;";
    	CachedRowSetImpl crs = null;
    	try 
		{
			super.setStmt(super.getCx().prepareStatement(query));
			crs = super.executeQuery();
			while(crs.next())
			{
				int id = crs.getInt("id");
				String groupName = crs.getString("groupName");
				groups.add(new Group(id, groupName));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
    	return groups;
    }
	
	public Group getGroup(int id) 
	{
		String query = "SELECT * FROM `group` WHERE id = ?;";
    	CachedRowSetImpl crs = null;
    	Group group = null;
    	try 
		{
			super.setStmt(super.getCx().prepareStatement(query));
			super.getStmt().setLong(1, id);
			crs = super.executeQuery();
			while(crs.next())
			{
				String groupName = crs.getString("groupName");
				group = new Group(id, groupName);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
    	return group;
	}
	
	public String addGroup(Group group)
	{
		String res = null;
		String query = "INSERT INTO `group` (groupName) VALUES(?);";
		try 
		{
			super.setStmt(super.getCx().prepareStatement(query, Statement.RETURN_GENERATED_KEYS));
			super.getStmt().setString(1, group.groupName);
			res = super.updateQuery();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return res;
	}
	
	public String editGroup(Group group)
	{
		String res = null;
		String query = "UPDATE `group` SET groupName = ? WHERE id = ?;";
		try 
		{
			super.setStmt(super.getCx().prepareStatement(query, Statement.RETURN_GENERATED_KEYS));
			super.getStmt().setString(1, group.groupName);
			super.getStmt().setInt(2, group.id);
			res = super.updateQuery();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return res;
	}
	
}
