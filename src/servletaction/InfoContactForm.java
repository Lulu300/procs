package servletaction;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import domain.Entreprise;
import domain.EntrepriseDAO;
import domain.Group;
import domain.GroupDAO;

public class InfoContactForm extends Action 
{
	public ActionForward execute(final ActionMapping pMapping, ActionForm pForm, final HttpServletRequest pRequest, final HttpServletResponse pResponse)
	{
		
		HttpSession session = pRequest.getSession();
        if(session.getAttribute("user") == null) {
            return pMapping.findForward("connection");
        }
		
		/* final EntrepriseDAO lEntrepriseDAO = new EntrepriseDAO();
		List<Entreprise> entreprises = lEntrepriseDAO.getAllEntreprises();
		pRequest.setAttribute("entreprises", entreprises);
		
		final GroupDAO lGroupDAO = new GroupDAO();
		List<Group> listGroups = lGroupDAO.getAllGroups();
		pRequest.setAttribute("listGroups", listGroups); */
		
		return pMapping.findForward("addContact");
	}
}
