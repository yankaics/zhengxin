/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package org.xpup.hafmis.syscollection.querystatistics.inspection.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/** 
 * MyEclipse Struts
 * Creation date: 06-17-2008
 * 
 * XDoclet definition:
 * @struts.action validate="true"
 */
public class InspectionForwardAC extends Action {
  public static final String PAGINATION_KEY ="org.xpup.hafmis.syscollection.querystatistics.inspection.action.InspectionShowAC";

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
    HttpSession session = request.getSession();
    session.setAttribute(PAGINATION_KEY, null);
    return mapping.findForward("inspectionShowAC");
	}
}