package servletaction;

import java.io.Console;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import actionform.AddContactActionForm;
import models.Adresse;
import models.Contact;
import models.PhoneNumber;
import service.AdresseService;
import service.ContactService;
import service.PhoneService;

public class AddContactAction extends Action {
	public ActionForward execute(final ActionMapping pMapping, ActionForm pForm, final HttpServletRequest pRequest, final HttpServletResponse pResponse) {
		
		HttpSession session = pRequest.getSession();
        if(session.getAttribute("user") == null) {
            return pMapping.findForward("connection");
        }
        
        final ContactService contactService = new ContactService();
        final AdresseService adresseService = new AdresseService();
        		
		final AddContactActionForm lForm = (AddContactActionForm) pForm;
		
		/* Contact */
		final String firstName = lForm.getFirstName();
		final String lastName = lForm.getLastName();
		final String email = lForm.getEmail();
		
		final String street = lForm.getStreet();
		final String city = lForm.getCity();
		final String zip = lForm.getZip();
		final String country = lForm.getCountry();
		
		final String phoneKind1 = lForm.getPhoneKind1();
		final String phoneNumber1 = lForm.getPhoneNumber1();
		final String phoneKind2 = lForm.getPhoneKind2();
		final String phoneNumber2 = lForm.getPhoneNumber2();
		final String phoneKind3 = lForm.getPhoneKind3();
		final String phoneNumber3 = lForm.getPhoneNumber3();
		
		Set<PhoneNumber> phones = new HashSet<>();
		
		if (phoneKind1 != "" && phoneNumber1 != "") {
			PhoneNumber phone1 = new PhoneNumber(phoneKind1, phoneNumber1);
			phones.add(phone1);
		}
		
		if (phoneKind2 != "" && phoneNumber2 != "") {
			PhoneNumber phone2 = new PhoneNumber(phoneKind2, phoneNumber2);
			phones.add(phone2);
		}
		
		if (phoneKind3 != "" && phoneNumber3 != "") {
			PhoneNumber phone3 = new PhoneNumber(phoneKind3, phoneNumber3);
			phones.add(phone3);
		}
		
		Adresse adresse = new Adresse(street, city, zip, country);
		adresseService.addAdresse(adresse);
		
		Contact contact = new Contact(lastName, firstName, email, adresse, phones);

		contactService.saveOrUpdate(contact);
		return pMapping.findForward("success");
	}
}
