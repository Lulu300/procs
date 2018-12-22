package servletaction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import actionform.AddContactActionForm;
import models.Adresse;
import models.Contact;
import service.AdresseService;
import service.ContactService;

public class AddContactAction extends Action {
	public ActionForward execute(final ActionMapping pMapping, ActionForm pForm, final HttpServletRequest pRequest, final HttpServletResponse pResponse) {
		
		HttpSession session = pRequest.getSession();
        if(session.getAttribute("user") == null) {
            return pMapping.findForward("connection");
        }
        
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        final ContactService contactService = (ContactService) context.getBean("contactService");
        final AdresseService adresseService = (AdresseService) context.getBean("adresseService");
        		
		final AddContactActionForm lForm = (AddContactActionForm) pForm;
		
		/* Contact */
		final String firstName = lForm.getFirstName();
		final String lastName = lForm.getLastName();
		final String email = lForm.getEmail();
		
		final String street = lForm.getStreet();
		final String city = lForm.getCity();
		final String zip = lForm.getZip();
		final String country = lForm.getCountry();
		
		Adresse adresse = new Adresse(street, city, zip, country);
		adresseService.addAdresse(adresse);
		
		Contact contact = new Contact(lastName, firstName, email, adresse);

		String res = contactService.saveOrUpdate(contact);
		return pMapping.findForward("success");
	}
}
