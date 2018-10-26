package actionform;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import javax.servlet.http.HttpServletRequest;

public class ConnectionActionForm extends ActionForm 
{

	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	
	public ConnectionActionForm() 
	{
		super();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request)
	{
		ActionErrors errors = new ActionErrors();

		if (this.username.length() < 1 || this.username.length() > 45)
		{
			errors.add("username", new ActionMessage("form.connection.username.error"));
		}
		
		if (this.password.length() < 1 || this.password.length() > 45)
		{
			errors.add("password", new ActionMessage("form.connection.password.error"));
		}
		
		if (!this.username.equals(this.password))
		{
			errors.add("password", new ActionMessage("form.connection.username.password.error"));
		}
		return errors;
	}
	
}
