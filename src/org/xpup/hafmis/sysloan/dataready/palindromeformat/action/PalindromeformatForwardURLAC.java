package org.xpup.hafmis.sysloan.dataready.palindromeformat.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
/**
 * 
 * @author yuqf
 *2007-12-20
 */
public class PalindromeformatForwardURLAC extends Action{

  public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    // TODO Auto-generated method stub
    request.getSession().setAttribute(PalindromeformatShowAC.PAGINATION_KEY, null);
    return mapping.findForward("to_palindromeformatShowAC");
  }
}
