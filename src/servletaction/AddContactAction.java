package servletaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import actionform.AddContactActionForm;
import domain.Address;
import domain.AddressDAO;
import domain.Contact;
import domain.ContactDAO;
import domain.Entreprise;
import domain.EntrepriseDAO;
import domain.Group;
import domain.GroupDAO;
import domain.PhoneNumber;
import domain.PhoneNumberDAO;
import service.ContactService;
import service.EntrepriseService;

public class AddContactAction extends Action {
	public ActionForward execute(final ActionMapping pMapping, ActionForm pForm, final HttpServletRequest pRequest, final HttpServletResponse pResponse) {
		
		HttpSession session = pRequest.getSession();
        if(session.getAttribute("user") == null) {
            return pMapping.findForward("connection");
        }
        
        final EntrepriseService entrepriseService = new EntrepriseService();
        		
		final AddContactActionForm lForm = (AddContactActionForm) pForm;
		
		/* Entreprise */
		final String companyName = lForm.getCompanyName();
		final String numSiret = lForm.getNumSiret();
		
		/* Contact */
		final String firstName = lForm.getFirstName();
		final String lastName = lForm.getLastName();
		final String email = lForm.getEmail();
		
		/* PhoneNumber */
		final String phoneKind = lForm.getPhoneKind();
		final String phoneNumber = lForm.getPhoneNumber();
		PhoneNumber phone = new PhoneNumber(phoneKind, phoneNumber);
		Set<PhoneNumber> phoneNumbers = new HashSet<>(1);
		phoneNumbers.add(phone);
		
		/* PhoneNumberDAO phoneNumberDAO = new PhoneNumberDAO();
		String sIdPhoneNumber = phoneNumberDAO.addPhoneNumber(phone);
		int idPhoneNumber = -1;
		try {
			idPhoneNumber = Integer.parseInt(sIdPhoneNumber);
		} catch(Exception e) {}
		phone.setId(idPhoneNumber);
		*/
		
		/* Adress */
		final String country = lForm.getCountry();
		final String city = lForm.getCity();
		final String zip = lForm.getZip();
		final String street = lForm.getStreet();
		Address address = new Address(street, city, zip, country);
		
		/* AdressDAO adressDAO = new AdressDAO();
		String sIdAdress = adressDAO.addAdress(adress);
		int idAdress = -1;
		try {
			idAdress = Integer.parseInt(sIdAdress);
		} catch(Exception e) {}
		adress.setId(idAdress);
		*/

		/* Group */
		final String[] lgroups = lForm.getGroups();
		Set<Group> listContactGroup = new HashSet<Group>();
		
		if (lgroups != null) {
			for (String group : lgroups) {
				try {
					System.out.println(group);
					int id_group = Integer.parseInt(group);
					listContactGroup.add(new Group(id_group));
				} catch (Exception e) {}
			}
		}
		
		Entreprise entreprise = new Entreprise(lastName, firstName, email, address, phoneNumbers, listContactGroup, numSiret, companyName);
		String res = entrepriseService.saveOrUpdate(entreprise);
		return pMapping.findForward("success");
		/* final ContactDAO lContactDAO = new ContactDAO();
		final String idContact = lContactDAO.addContact(contact);
		try {
			System.out.println(idContact);
			int r = Integer.parseInt(idContact);
			contact.setId(r);
			ContactGroupDAO cgDAO = new ContactGroupDAO();
			cgDAO.removeContactGroup(contact);
			for (Group g : contact.groups) {
				System.out.println(g.getId());
				String result = cgDAO.addContactGroup(contact.getId(), g.getId());
				System.out.println(result);
			}
			return pMapping.findForward("success");
		} catch (Exception e) {
			final EntrepriseDAO lEntrepriseDAO = new EntrepriseDAO();
			List<Entreprise> entreprises = lEntrepriseDAO.getAllEntreprises();
			pRequest.setAttribute("entreprises", entreprises);
			final GroupDAO lGroupDAO = new GroupDAO();
			List<Group> listGroups = lGroupDAO.getAllGroups();
			pRequest.setAttribute("listGroups", listGroups);
			return pMapping.findForward("error");
		} */
	}
}
