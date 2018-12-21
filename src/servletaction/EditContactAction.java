package servletaction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import actionform.EditContactActionForm;
import domain.Contact;
import domain.ContactDAO;
import service.ContactService;
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
		final EditContactActionForm lForm = (EditContactActionForm) pForm;
		
		/* Contact */
		final String firstName = lForm.getFirstName();
		final String lastName = lForm.getLastName();
		final String email = lForm.getEmail();
		final int id = Integer.parseInt(lForm.getId());
		
		
		Contact contact = contactService.getContact(id);
		contact.setFirstName(firstName);
		contact.setLastName(lastName);
		contact.setEmail(email);
		
		try {
			/*
			Session s = HibernateUtil.getSessionFactory().getCurrentSession();
			Transaction tx = s.beginTransaction();
			s.saveOrUpdate(contact);
			tx.commit(); */
			contactService.saveOrUpdate(contact);
			return pMapping.findForward("success");
		} catch (Exception e) {
			System.out.println(e);
			return pMapping.findForward("error");
		}
	}
}