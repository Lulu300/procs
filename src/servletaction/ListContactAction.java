package servletaction;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import domain.Contact;
import domain.ContactDAO;
import domain.Entreprise;
import service.ContactService;
import service.EntrepriseService;

public class ListContactAction extends Action {
	public ActionForward execute(final ActionMapping pMapping, ActionForm pForm, final HttpServletRequest pRequest, final HttpServletResponse pResponse) {
		
		HttpSession session = pRequest.getSession();
        if(session.getAttribute("user") == null) {
            return pMapping.findForward("connection");
        }
        
        final EntrepriseService entrepriseService = new EntrepriseService();
        List<Entreprise> entreprises = entrepriseService.getAllEntreprises();
		
		pRequest.setAttribute("contacts", entreprises);
		
		return pMapping.findForward("listContacts");
	}
}
