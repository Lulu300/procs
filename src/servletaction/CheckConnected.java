package servletaction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


public class CheckConnected extends Action
{
	public ActionForward execute(final ActionMapping pMapping, ActionForm pForm, final HttpServletRequest pRequest, final HttpServletResponse pResponse)
	{
		HttpSession session = pRequest.getSession();
        if(session.getAttribute("user") == null) {
            return pMapping.findForward("connection");
        }
		return pMapping.findForward("connected");
	}
}
