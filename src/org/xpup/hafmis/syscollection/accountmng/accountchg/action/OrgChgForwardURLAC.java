package org.xpup.hafmis.syscollection.accountmng.accountchg.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.xpup.common.util.Pagination;
public class OrgChgForwardURLAC  extends Action {


    public static final String PAGINATION_KEY = "org.xpup.hafmis.syscollection.accountmng.accountchg.action.OrgChgShowListAC";

    public ActionForward execute(ActionMapping mapping, ActionForm form,
        HttpServletRequest request, HttpServletResponse response)
    throws Exception {
      HttpSession session = request.getSession();
      session.setAttribute(PAGINATION_KEY, null);
      //  判断是否为条件查询如果不是则确定为接点进入清空session
      Pagination pagination = (Pagination) request.getSession().getAttribute(
          OrgChgShowListAC.PAGINATION_KEY);
      if (pagination != null) {
        session.removeAttribute(OrgChgShowListAC.PAGINATION_KEY);
      }
      return mapping.findForward("to_orgchg_list");
      
    }

  }

