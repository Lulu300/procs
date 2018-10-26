package domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.sun.rowset.CachedRowSetImpl;

public class DAO {

	private Connection cx;
	private PreparedStatement stmt;
	private DataSource ds;
	
	DAO() 
	{
		super();
		this.cx = null;
        this.stmt = null;
        this.ds = this.getDataSource();
	}
	
	private DataSource getDataSource(){
		DataSource ds = null;
		try 
		{
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/miage");
		
		} 
		catch (NamingException e) 
		{
			e.printStackTrace();
		}
		return ds;
	}

	protected PreparedStatement getStmt() {
		return stmt;
	}
	
	public Connection getCx() 
	{
        this.openCx();
		if (this.cx == null)
		{
			this.openCx();
		}
		return cx;
	}

	public void setStmt(PreparedStatement stmt) 
	{
		this.stmt = stmt;
	}

	private void openCx()
    {
    	try 
    	{
			this.cx = this.ds.getConnection();

		} 
    	catch (SQLException e) 
    	{

			e.printStackTrace();
		}
    }
    
    private void closeCx()
    {
    	try 
    	{
    		if (this.cx != null)
    		{
    			this.cx.close();
    		}
		} 
    	catch (SQLException e) 
    	{
			e.printStackTrace();
		}
    }

	protected String updateQuery()
	{
		String result = null;
		try 
		{
			//this.stmt = this.cx.prepareStatement(query);
			this.stmt.executeUpdate();
			ResultSet rs = this.stmt.getGeneratedKeys();
			if (rs.next())
			{
				result = String.valueOf(rs.getLong(1));
			}
		}
		catch (SQLException e) 
		{
			result = "SQLException : " + e.getMessage();
		}
		finally 
		{
			try 
			{
				if (this.stmt != null) 
				{
					this.stmt.close();
				}
			}
			catch (Exception e) 
			{ 
				throw new RuntimeException(e); 
			}
		}
		this.closeCx();
		return result;
	}
	
	public CachedRowSetImpl executeQuery()
	{
		ResultSet rs = null;
		CachedRowSetImpl crs = null;
		try 
		{
			rs = this.stmt.executeQuery();
			crs = new CachedRowSetImpl();
			crs.populate(rs);
		} 
		catch (Exception e) 
		{ 
			throw new RuntimeException(e);
		}
		finally 
		{
			try 
			{
				if (this.stmt != null) 
				{
					stmt.close();
				}
				if(rs != null)
				{
					rs.close();
				}
			}
			catch (Exception e) 
			{ 
				throw new RuntimeException(e); 
			}
		}
		this.closeCx();
		return crs;
		
	}
	
	public String execute()
	{
		String result = null;
		try 
		{
			this.stmt.execute();
		}
		catch (SQLException e) 
		{
			result = "SQLException : " + e.getMessage();
		}
		finally {
			try 
			{
				if (this.stmt != null) 
				{
					stmt.close();
				}
			}
			catch (Exception e) 
			{ 
				throw new RuntimeException(e); 
			}
		}
		this.closeCx();
		return result;
	}
	
}
