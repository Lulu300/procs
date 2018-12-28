package servletaction;

import java.util.List;

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
import service.ContactService;
import service.GroupService;

public class PopulateAction extends Action 
{
	public ActionForward execute(final ActionMapping pMapping, ActionForm pForm, final HttpServletRequest pRequest, final HttpServletResponse pResponse)
	{
		
		HttpSession session = pRequest.getSession();
        if(session.getAttribute("user") == null) {
            return pMapping.findForward("connection");
        }
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");  
        final GroupService groupService = (GroupService) context.getBean("groupService");
        final ContactService contactService = (ContactService) context.getBean("contactService");
        
        Group work = (Group) context.getBean("FamilyGroup");
        Group family = (Group) context.getBean("WorkGroup");
        Group friends = (Group) context.getBean("FriendsGroup");
        
        groupService.addGroup(work);
        groupService.addGroup(family);
        groupService.addGroup(friends);
        
        Contact bob = (Contact) context.getBean("addContact1");
        Contact patrick = (Contact) context.getBean("addContact2");
        Contact sandy = (Contact) context.getBean("addContact3");
        contactService.save(bob); 
        contactService.save(patrick); 
        contactService.save(sandy); 
        
        List<Group> groups = groupService.getAllGroups();
        List<Contact> contacts = contactService.getAllContacts();
       
		pRequest.setAttribute("contacts", contacts);
        pRequest.setAttribute("listGroups", groups);
		return pMapping.findForward("listContacts");
	}
}
