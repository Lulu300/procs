package servletaction;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import actionform.EditContactActionForm;
import domain.Address;
import domain.AdressDAO;
import domain.Contact;
import domain.ContactDAO;
import domain.Entreprise;
import domain.EntrepriseDAO;
import domain.Group;
import domain.GroupDAO;
import domain.PhoneNumber;
import domain.PhoneNumberDAO;

public class EditContactAction extends Action 
{
	public ActionForward execute(final ActionMapping pMapping, ActionForm pForm, final HttpServletRequest pRequest, final HttpServletResponse pResponse)
	{
		HttpSession session = pRequest.getSession();
        if(session.getAttribute("user") == null) {
            return pMapping.findForward("connection");
        }
		
		final EditContactActionForm lForm = (EditContactActionForm) pForm;
		/* Contact */
		final String firstName = lForm.getFirstName();
		final String lastName = lForm.getLastName();
		final String email = lForm.getEmail();
		final int id = Integer.parseInt(lForm.getId());
		
		/* PhoneNumber */
		final String phoneKind = lForm.getPhoneKind();
		final String phoneNumber = lForm.getPhoneNumber();
		final int idPhone = Integer.parseInt(lForm.getIdPhone());
		PhoneNumber phone = new PhoneNumber(idPhone, phoneKind, phoneNumber);
		
		/* Adress */
		final String country = lForm.getCountry();
		final String city = lForm.getCity();
		final String zip = lForm.getZip();
		final String street = lForm.getStreet();
		final int idAdress = Integer.parseInt(lForm.getIdAdress());
		Address adress = new Address(idAdress, street, city, zip, country);
		
		/* Entreprise */
		int idEntreprise = -1;
		try
		{
			idEntreprise = Integer.parseInt(lForm.getEntreprise());
		}
		catch (Exception e) {}
		Entreprise entreprise = new Entreprise(idEntreprise);

		/* Group */
		final String[] lgroups = lForm.getGroups();
		List<Group> listContactGroup = new ArrayList<Group>();
		
		if (lgroups != null)
		{
			for (String group : lgroups)
			{
				try 
				{
					int id_group = Integer.parseInt(group);
					listContactGroup.add(new Group(id_group));
				}
				catch (Exception e) {}
			}
		}
		
		Contact contact = new Contact(id, firstName, lastName, email, adress, phone, entreprise, listContactGroup);
		return pMapping.findForward("success");
		/* try
		{
			String lError;
			final ContactDAO lContactDAO = new ContactDAO();
			AdressDAO adressDAO = new AdressDAO();
			PhoneNumberDAO phoneNumberDAO = new PhoneNumberDAO();
			
			lError = phoneNumberDAO.editPhoneNumber(phone);
			lError = adressDAO.editAdress(adress);
			lError = lContactDAO.editContact(contact);
			
			lError = lContactDAO.editContact(contact);
			ContactGroupDAO cgDAO = new ContactGroupDAO();
			cgDAO.removeContactGroup(contact);
			for (Group g : contact.groups)
			{
				String result = cgDAO.addContactGroup(contact.getId(), g.getId());
			}
			return pMapping.findForward("success");
		}
		catch (Exception e)
		{
			final EntrepriseDAO lEntrepriseDAO = new EntrepriseDAO();
			List<Entreprise> entreprises = lEntrepriseDAO.getAllEntreprises();
			pRequest.setAttribute("entreprises", entreprises);
			final GroupDAO lGroupDAO = new GroupDAO();
			List<Group> listGroups = lGroupDAO.getAllGroups();
			pRequest.setAttribute("listGroups", listGroups);
			pRequest.setAttribute("contact", contact);
			return pMapping.findForward("error");
		} */
	}
}
