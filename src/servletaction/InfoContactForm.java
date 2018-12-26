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

import models.Group;
import service.GroupService;

public class InfoContactForm extends Action 
{
	public ActionForward execute(final ActionMapping pMapping, ActionForm pForm, final HttpServletRequest pRequest, final HttpServletResponse pResponse)
	{
		
		HttpSession session = pRequest.getSession();
        if(session.getAttribute("user") == null) {
            return pMapping.findForward("connection");
        }
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");  
        final GroupService groupService = (GroupService) context.getBean("groupService");
        List<Group> groups = groupService.getAllGroups();

        pRequest.setAttribute("listGroups", groups);
		
		return pMapping.findForward("addContact");
	}
}
