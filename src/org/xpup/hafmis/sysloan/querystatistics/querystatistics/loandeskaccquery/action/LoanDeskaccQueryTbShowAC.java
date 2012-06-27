/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package org.xpup.hafmis.sysloan.querystatistics.querystatistics.loandeskaccquery.action;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.xpup.common.util.BSUtils;
import org.xpup.common.util.Pagination;
import org.xpup.common.util.PaginationUtils;
import org.xpup.hafmis.common.util.BusiConst;
import org.xpup.hafmis.common.util.BusiTools;
import org.xpup.hafmis.orgstrct.dto.SecurityInfo;
import org.xpup.hafmis.sysloan.loancallback.loancallback.bsinterface.ILoancallbackBS;
import org.xpup.hafmis.sysloan.loancallback.loancallback.form.LoancallbackTaAF;
import org.xpup.hafmis.sysloan.querystatistics.querystatistics.loandeskaccquery.bsinterface.ILoandeskaccqueryBS;
import org.xpup.hafmis.sysloan.querystatistics.querystatistics.loandeskaccquery.form.LoanDeskaccQueryTbAF;
import org.xpup.hafmis.sysloan.loancallback.loancallback.dto.ShouldBackListDTO;

/**
 * MyEclipse Struts Creation date: 10-22-2007 XDoclet definition:
 * 
 * @struts.action validate="true"
 */
public class LoanDeskaccQueryTbShowAC extends Action {
  /*
   * Generated Methods
   */

  /**
   * Method execute
   * 
   * @param mapping
   * @param form
   * @param request
   * @param response
   * @return ActionForward
   */
  public static final String PAGINATION_KEY = "org.xpup.hafmis.sysloan.querystatistics.querystatistics.loandeskaccquery.action.LoanDeskaccQueryTbShowAC";

  public ActionForward execute(ActionMapping mapping, ActionForm form,
      HttpServletRequest request, HttpServletResponse response) {
    Pagination pagination = getPagination(PAGINATION_KEY, request);
    PaginationUtils.updatePagination(pagination, request);
    ILoandeskaccqueryBS loandeskaccqueryBS = (ILoandeskaccqueryBS) BSUtils
        .getBusinessService("loandeskaccqueryBS", this, mapping
            .getModuleConfig());
    SecurityInfo securityInfo = (SecurityInfo) request.getSession()
        .getAttribute("SecurityInfo");
    ILoancallbackBS loancallbackBS = (ILoancallbackBS) BSUtils
        .getBusinessService("loancallbackBS", this, mapping.getModuleConfig());
    LoanDeskaccQueryTbAF loanDeskaccQueryTbAF = new LoanDeskaccQueryTbAF();
    String contractIdHl = (String) request.getAttribute("contractIdHl");
    String contractIdHl1 = "";
    if (contractIdHl != null) {
      request.getSession().setAttribute("contractIdHldesk", contractIdHl);
      contractIdHl1 = contractIdHl;
    } else {
      contractIdHl1 = (String) request.getSession().getAttribute(
          "contractIdHldesk");
    }
    try {
      loanDeskaccQueryTbAF = loandeskaccqueryBS.showIndividualFlow(
          contractIdHl1, pagination, securityInfo);
      pagination.getQueryCriterions().put("contractId",
          loanDeskaccQueryTbAF.getContractid());
      LoancallbackTaAF loancallbackTaAF = loancallbackBS.getLoancallbackTaAF(
          pagination, securityInfo);
      List ll = loancallbackTaAF.getShouldBackList();
      BigDecimal punishinterest = new BigDecimal(0.00);
      for (int j = 0; j < ll.size(); j++) {
        ShouldBackListDTO dto = (ShouldBackListDTO) ll.get(j);
        BigDecimal pi = dto.getPunishInterest();
        punishinterest = punishinterest.add(pi);
      }
      loanDeskaccQueryTbAF.setOwepunishinterest(punishinterest.toString());
      loanDeskaccQueryTbAF.setBiztypeMap(BusiTools
          .listBusiProperty(BusiConst.PLBUSINESSTYPE));
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    request.setAttribute("loanDeskaccQueryTbAF", loanDeskaccQueryTbAF);
    request.getSession().setAttribute("loanDeskaccQueryTbAFAlllist",
        loanDeskaccQueryTbAF);
    return mapping.findForward("loandeskaccquerytb_show");
  }

  private Pagination getPagination(String paginationKey,
      HttpServletRequest request) {
    Pagination pagination = (Pagination) request.getSession().getAttribute(
        paginationKey);
    if (pagination == null) {
      pagination = new Pagination(0, 10, 1, " p202.biz_date,p203.year_month ", "ASC",
          new HashMap(0));
      request.getSession().setAttribute(paginationKey, pagination);
    }
    return pagination;
  }
}