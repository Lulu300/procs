package actionform;

import domain.Group;
import domain.GroupDAO;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class AddContactActionForm extends ActionForm
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/* Contact */
	private String lastName = null;
	private String firstName = null;
	private String email = null;
	
	/* PhoneNumber */
	private String phoneKind = null;
	private String phoneNumber = null;
	
	/* Company */
	private String numSiret = null;
	private String companyName = null;
	
	/* Adress */
	private String street = null;
	private String city = null;
	private String zip = null;
	private String country = null;
	
	/* Group */
	private List<Group> listGroups;
	private String[] groups;
	
	public AddContactActionForm() 
	{
		super();
		
		GroupDAO lGroupDAO = new GroupDAO();
		this.listGroups = lGroupDAO.getAllGroups();
	}
	
	public String[] getGroups() {
		return groups;
	}

	public void setGroups(String[] groups) {
		this.groups = groups;
	}

	public String getPhoneKind() {
		return phoneKind;
	}
	
	public void setPhoneKind(String phoneKind) {
		this.phoneKind = phoneKind;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getNumSiret() {
		return numSiret;
	}

	public void setNumSiret(String numSiret) {
		this.numSiret = numSiret;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getLastName() 
	{
		return lastName;
	}
	
	public void setLastName(String lastName) 
	{
		this.lastName = lastName;
	}
	
	public String getFirstName() 
	{
		return firstName;
	}
	
	public void setFirstName(String firstName) 
	{
		this.firstName = firstName;
	}
	
	public String getEmail() 
	{
		return email;
	}
	
	public void setEmail(String email) 
	{
		this.email = email;
	}
	
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request)
	{
		ActionErrors errors = new ActionErrors();
		/* Contact */
		if (this.lastName == null || this.lastName.length() < 1 || this.lastName.length() > 45)
		{
			errors.add("lastName", new ActionMessage("form.contact.lastName.error"));
		}
		if (this.firstName == null || this.firstName.length() < 1 || this.firstName.length() > 45)
		{
			errors.add("firstName", new ActionMessage("form.contact.firstName.error"));
		}
		if (this.email == null || this.email.length() < 5 || this.email.length() > 75)
		{
			errors.add("email", new ActionMessage("form.contact.email.error"));
		}
		
		/* Company */
		if (this.numSiret == null || this.numSiret.length() != 14)
		{
			errors.add("numSiret", new ActionMessage("form.contact.numSiret.error.size"));
		}
		if (this.companyName == null || this.companyName.length() < 1 || this.companyName.length() > 45)
		{
			errors.add("companyName", new ActionMessage("form.contact.companyName.error.size"));
		}
		
		/* PhoneNumber */
		if ((this.phoneKind != "" && this.phoneKind.length() < 3) || this.phoneKind.length() > 10)
		{
			errors.add("phoneKind", new ActionMessage("form.contact.phoneKind.error.size"));
		}
		if ((this.phoneNumber != "" && this.phoneNumber.length() < 10) || this.phoneKind.length() > 15)
		{
			errors.add("phoneNumber", new ActionMessage("form.contact.phoneNumber.error.size"));
		}
		
		/* Adress */
		if ((this.street != "" && this.street.length() < 1) || this.street.length() > 100)
		{
			errors.add("street", new ActionMessage("form.contact.street.error.size"));
		}
		if ((this.city != "" && this.city.length() < 1) || this.city.length() > 50)
		{
			errors.add("city", new ActionMessage("form.contact.city.error.size"));
		}
		if ((this.zip != "" && this.zip.length() < 5) || this.zip.length() > 10)
		{
			errors.add("zip", new ActionMessage("form.contact.zip.error.size"));
		}
		if ((this.country != "" && this.country.length() < 3) || this.country.length() > 50)
		{
			errors.add("country", new ActionMessage("form.contact.country.error.size"));
		}
		
		if(!errors.isEmpty()) 
		{
            request.setAttribute("listGroups", this.listGroups);
        }
		
		return errors;
	}
}
