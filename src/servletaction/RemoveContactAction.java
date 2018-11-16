package servletaction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import actionform.AddContactActionForm;
import domain.Address;
import domain.AdressDAO;
import domain.Contact;
import domain.ContactDAO;
import domain.ContactGroupDAO;
import domain.PhoneNumber;
import domain.PhoneNumberDAO;

public class RemoveContactAction extends Action 
{
	public ActionForward execute(final ActionMapping pMapping, ActionForm pForm, final HttpServletRequest pRequest, final HttpServletResponse pResponse)
	{
		
		HttpSession session = pRequest.getSession();
        if(session.getAttribute("user") == null) {
            return pMapping.findForward("connection");
        }
        
		int id = -1;
		try
		{
			id = Integer.parseInt(pRequest.getParameter("id"));
		}
		catch (Exception e) {}
		String lError;
		
		/* final ContactDAO lContactDAO = new ContactDAO();
		final Contact contact = lContactDAO.getContact(id);
		final PhoneNumber phoneNumber = new PhoneNumber(contact.phoneNumber.id);
		final Adress adress = new Adress(contact.adress.id);
		final ContactGroupDAO cgDAO = new ContactGroupDAO();
		final PhoneNumberDAO phoneNumberDAO = new PhoneNumberDAO();
		final AdressDAO adressDAO = new AdressDAO();
		
		lError = cgDAO.removeContactGroup(contact);
		lError = phoneNumberDAO.removePhoneNumber(contact.phoneNumber);
		lError = adressDAO.removeAdress(contact.adress);
		lError = lContactDAO.removeContact(contact);
		
		if (lError != null)
		{
			pRequest.setAttribute("error", "Error");
		}
		System.out.println("LOL"); */
		return pMapping.findForward("end");
	}
}
