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
import domain.ContactDAO;
import models.Adresse;
import models.Contact;
import models.PhoneNumber;
import service.AdresseService;
import service.ContactService;
import service.PhoneService;
import util.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class EditContactAction extends Action {
	public ActionForward execute(final ActionMapping pMapping, ActionForm pForm, final HttpServletRequest pRequest, final HttpServletResponse pResponse) {
		HttpSession session = pRequest.getSession();
        if(session.getAttribute("user") == null) {
            return pMapping.findForward("connection");
        }
		
        ContactService contactService = new ContactService();
        PhoneService phoneService = new PhoneService();
        final AdresseService adresseService = new AdresseService();
		final EditContactActionForm lForm = (EditContactActionForm) pForm;
		
		/* Contact */
		final String firstName = lForm.getFirstName();
		final String lastName = lForm.getLastName();
		final String email = lForm.getEmail();
		final int id = Integer.parseInt(lForm.getId());
		
		final String street = lForm.getStreet();
		final String city = lForm.getCity();
		final String zip = lForm.getZip();
		final String country = lForm.getCountry();
		final int idA = Integer.parseInt(lForm.getId());
		
		final String[] idPhone = lForm.getIdPhone();
		final String[] phoneKind = lForm.getPhoneKind();
		final String[] phoneNumber = lForm.getPhoneNumber();
		
		
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
		
		Contact contact = contactService.getContact(id);
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
		
		try {
			contactService.merge(contact);
			return pMapping.findForward("success");
		} catch (Exception e) {
			System.out.println(e);
			return pMapping.findForward("error");
		}
	}
}