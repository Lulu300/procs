package servletaction;

import java.util.List;
import java.util.Set;

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
import models.Group;
import models.PhoneNumber;
import service.ContactService;
import service.GroupService;

public class InfoContactEditionForm extends Action {
	
	public ActionForward execute(final ActionMapping pMapping, ActionForm pForm, final HttpServletRequest pRequest, final HttpServletResponse pResponse) {
		
		HttpSession session = pRequest.getSession();
        if(session.getAttribute("user") == null) {
            return pMapping.findForward("connection");
        }
        
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        final ContactService contactService = (ContactService) context.getBean("contactService");
        final GroupService groupService = (GroupService) context.getBean("groupService");
        
		String cid = (String) pRequest.getParameter("cid");
		try {
			int id = Integer.parseInt(cid);
			Contact contact = contactService.getContact(id);
			
			List<Group> listGroups = groupService.getAllGroups();
			
			Set<PhoneNumber> phones = contact.getPhoneNumbers();
			for (PhoneNumber p: phones) {
				System.out.println(p);
			}
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
			
			pRequest.setAttribute("listGroups", listGroups);
			pRequest.setAttribute("phoneNumbers", phones);
			pRequest.setAttribute("contact", contact);
			
			return pMapping.findForward("editContact");
		}
		catch(Exception e) {
			e.printStackTrace();
			return pMapping.findForward("error");
		}
	}
	
}
