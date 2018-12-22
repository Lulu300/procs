package servletaction;

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
import service.AdresseService;
import service.ContactService;
import util.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;
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
		
		try {
			contactService.saveOrUpdate(contact);
			return pMapping.findForward("success");
		} catch (Exception e) {
			System.out.println(e);
			return pMapping.findForward("error");
		}
	}
}