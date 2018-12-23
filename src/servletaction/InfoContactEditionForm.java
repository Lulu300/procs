package servletaction;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import models.Contact;
import models.PhoneNumber;
import service.ContactService;

public class InfoContactEditionForm extends Action 
{
	public ActionForward execute(final ActionMapping pMapping, ActionForm pForm, final HttpServletRequest pRequest, final HttpServletResponse pResponse)
	{
		
		HttpSession session = pRequest.getSession();
        if(session.getAttribute("user") == null) {
            return pMapping.findForward("connection");
        }
        
		String s_id = (String) pRequest.getParameter("cid");
		System.out.println(s_id);
		try
		{
			int id = Integer.parseInt(s_id);
			final ContactService contactService = new ContactService();
			Contact contact = contactService.getContact(id);
			
			Set<PhoneNumber> phones = contact.getPhoneNumbers();
			if (phones.size() == 2) {
				phones.add(new PhoneNumber("", ""));
			} else if (phones.size() == 1) {
				phones.add(new PhoneNumber("", ""));
				phones.add(new PhoneNumber("", ""));
			} else if (phones.size() == 0) {
				phones.add(new PhoneNumber("", ""));
				phones.add(new PhoneNumber("", ""));
				phones.add(new PhoneNumber("", ""));
			}
			
			pRequest.setAttribute("phoneNumbers", phones);
			pRequest.setAttribute("contact", contact);
		}
		catch(Exception e) {
			e.printStackTrace();
			return pMapping.findForward("error");
		}
		
		return pMapping.findForward("editContact");
	}
}
