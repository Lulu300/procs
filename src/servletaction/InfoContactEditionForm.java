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

import models.Contact;
import service.ContactService;

public class InfoContactEditionForm extends Action {
	public ActionForward execute(final ActionMapping pMapping, ActionForm pForm, final HttpServletRequest pRequest, final HttpServletResponse pResponse) {
		
		HttpSession session = pRequest.getSession();
        if(session.getAttribute("user") == null) {
            return pMapping.findForward("connection");
        }
        
		String s_id = (String) pRequest.getParameter("cid");
		System.out.println(s_id);
		try {
			int id = Integer.parseInt(s_id);
			ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	        final ContactService contactService = (ContactService) context.getBean("contactService");
			Contact contact = contactService.getContact(id);
			pRequest.setAttribute("contact", contact);
		}
		catch(Exception e) {
			e.printStackTrace();
			return pMapping.findForward("error");
		}
		
		return pMapping.findForward("editContact");
	}
}
