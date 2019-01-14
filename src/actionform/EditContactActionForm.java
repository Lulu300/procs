package actionform;

import models.Adresse;
import models.Company;
import models.Contact;
import models.Group;
import models.PhoneNumber;
import service.GroupService;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

public class EditContactActionForm extends ActionForm {
	
	private static final long serialVersionUID = 1L;
	/* Contact */
	private String lastName = null;
	private String firstName = null;
	private String email = null;
	private String id = null;
	/* Company */
	private String name = null;
	private String numSiret = null;
	/* Adresse */
	private String street = null;
	private String city = null;
	private String zip = null;
	private String country = null;
	/* PhoneNumber */
	private String[] phoneKind = null;
	private String[] phoneNumber = null;
	private String[] idPhone = null;
	/* Group */
	private List<Group> listGroups;
	private String[] groups;
	
	final GroupService groupService;
	
	public EditContactActionForm() {
		super();
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		groupService = (GroupService) context.getBean("groupService");
		
		this.listGroups = groupService.getAllGroups();
	}
	
	public String[] getGroups() {
		return groups;
	}

	public void setGroups(String[] groups) {
		this.groups = groups;
	}

	public String[] getIdPhone() {
		return idPhone;
	}

	public void setIdPhone(String[] idPhone) {
		this.idPhone = idPhone;
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
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String[] getPhoneKind() {
		return phoneKind;
	}

	public void setPhoneKind(String[] phoneKind) {
		this.phoneKind = phoneKind;
	}

	public String[] getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String[] phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getNumSiret() {
		return numSiret;
	}

	public void setNumSiret(String numSiret) {
		this.numSiret = numSiret;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();
		/* Contact */
		if (this.lastName == null || this.lastName.length() < 1 || this.lastName.length() > 45) {
			errors.add("lastName", new ActionMessage("form.contact.lastName.error"));
		}
		if (this.firstName == null || this.firstName.length() < 1 || this.firstName.length() > 45) {
			errors.add("firstName", new ActionMessage("form.contact.firstName.error"));
		}
		if (this.email == null || this.email.length() < 5 || this.email.length() > 75) {
			errors.add("email", new ActionMessage("form.contact.email.error"));
		}
		/* Adress */
		if ((this.street != "" && this.street.length() < 1) || this.street.length() > 100) {
			errors.add("street", new ActionMessage("form.contact.street.error.size"));
		}
		if ((this.city != "" && this.city.length() < 1) || this.city.length() > 50) {
			errors.add("city", new ActionMessage("form.contact.city.error.size"));
		}
		if ((this.zip != "" && this.zip.length() < 5) || this.zip.length() > 10) {
			errors.add("zip", new ActionMessage("form.contact.zip.error.size"));
		}
		if ((this.country != "" && this.country.length() < 3) || this.country.length() > 50) {
			errors.add("country", new ActionMessage("form.contact.country.error.size"));
		}
		/* Company */
		if (this.numSiret != null && this.numSiret != null) {
			if (this.numSiret != "" && this.name != "" || this.numSiret.length() != 14) {
				errors.add("numSiret", new ActionMessage("form.contact.numSiret.error.size"));
			}
			if (this.name != "" && this.numSiret != "" || (this.name.length() < 1 || this.name.length() > 45)) {
				errors.add("name", new ActionMessage("form.contact.companyName.error.size"));
			}
		}
		
		if(!errors.isEmpty()) {	
			Set<PhoneNumber> phoneNumbers = new HashSet<PhoneNumber>();
			for (int i=0; i<this.phoneKind.length; i++) {
				phoneNumbers.add(new PhoneNumber(this.phoneKind[i], this.phoneNumber[i]));
			}
			
			Set<Group> contactGroups = new HashSet<Group>();
			for (String idGroup : this.groups) {
				contactGroups.add(groupService.getGroup(Integer.parseInt(idGroup)));
			}
			
			Adresse adresse = new Adresse(this.street, this.city, this.zip, this.country);
			Contact contact = new Contact(Integer.parseInt(this.id), this.lastName, this.firstName, this.email, adresse, phoneNumbers, contactGroups);
			
			request.setAttribute("listGroups", this.listGroups);
			if (this.name != null && this.numSiret != null) {
				Company company = new Company(contact, numSiret, name);
				request.setAttribute("contact", company);
			} else {
				request.setAttribute("contact", contact);
			}
        }
		
		return errors;
	}
	
}
