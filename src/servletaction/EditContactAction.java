package servletaction;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import actionform.EditContactActionForm;
import models.Adresse;
import models.Company;
import models.Contact;
import models.Group;
import models.PhoneNumber;
import service.AdresseService;
import service.ContactService;
import service.GroupService;
import service.PhoneService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EditContactAction extends Action {
	
	public ActionForward execute(final ActionMapping pMapping, ActionForm pForm, final HttpServletRequest pRequest, final HttpServletResponse pResponse) {
		HttpSession session = pRequest.getSession();
        if(session.getAttribute("user") == null) {
            return pMapping.findForward("connection");
        }
		
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        final ContactService contactService = (ContactService) context.getBean("contactService");
        final AdresseService adresseService = (AdresseService) context.getBean("adresseService");
        final PhoneService phoneService = (PhoneService) context.getBean("phoneService");
        final GroupService groupService = (GroupService) context.getBean("groupService");
        
		final EditContactActionForm lForm = (EditContactActionForm) pForm;
		/* Contact */
		final String firstName = lForm.getFirstName();
		final String lastName = lForm.getLastName();
		final String email = lForm.getEmail();
		final int id = Integer.parseInt(lForm.getId());
		/* Company */
		final String numSiret = lForm.getNumSiret();
		final String name = lForm.getName();
		/* Adresse */
		final String street = lForm.getStreet();
		final String city = lForm.getCity();
		final String zip = lForm.getZip();
		final String country = lForm.getCountry();
		final int idA = Integer.parseInt(lForm.getId());
		/* PhoneNumbers */
		final String[] idPhone = lForm.getIdPhone();
		final String[] phoneKind = lForm.getPhoneKind();
		final String[] phoneNumber = lForm.getPhoneNumber();
		/* Groups */
		final String[] groups = lForm.getGroups();
		
		Set<PhoneNumber> phones = new HashSet<>();
		if (phoneKind.length == phoneNumber.length && phoneKind.length == idPhone.length) {
			for (int i=0; i<phoneKind.length; i++) {
				if (phoneKind[i] != "" && phoneNumber[i] != "") {
					PhoneNumber ph;
					if (Integer.parseInt(idPhone[i]) != 0) {
						ph = phoneService.getPhoneNumber(Integer.parseInt(idPhone[i]));
						ph.setPhoneKind(phoneKind[i]);
						ph.setPhoneNumber(phoneNumber[i]);
					} else {
						ph = new PhoneNumber(phoneKind[i], phoneNumber[i]);
					}
					phones.add(ph);
				}
			}
		}
		
		Set<Group> contactGroups = new HashSet<Group>();
		if (groups != null) {
			for (String group : groups) {
				try {
					int idGroup = Integer.parseInt(group);
					Group g = groupService.getGroup(idGroup);
					contactGroups.add(g);
				} catch (Exception e) { }
			}
		}
		
		Contact contact = contactService.getContact(id);

		if (name != null && numSiret != null) {
			((Company) contact).setName(name);
			((Company) contact).setNumSiret(numSiret);
		}
		
		contact.setFirstName(firstName);
		contact.setLastName(lastName);
		contact.setEmail(email);
		
		Adresse adresse = adresseService.getAdresse(idA);
		adresse.setStreet(street);
		adresse.setCity(city);
		adresse.setZip(zip);
		adresse.setCountry(country);
		
		contact.setAdresse(adresse);
		contact.setPhoneNumbers(phones);
		contact.setGroups(contactGroups);
		
		try {
			contactService.merge(contact);
			return pMapping.findForward("success");
		} catch (Exception e) {
			e.printStackTrace();
			return pMapping.findForward("error");
		}
	}
	
}