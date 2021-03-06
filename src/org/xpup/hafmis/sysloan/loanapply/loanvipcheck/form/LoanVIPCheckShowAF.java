package org.xpup.hafmis.sysloan.loanapply.loanvipcheck.form;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts.action.ActionForm;

/**
 * @author 王野 2007-09-27
 */
public class LoanVIPCheckShowAF extends ActionForm {

  private static final long serialVersionUID = -7005677950157431557L;

  private List list = null;

  private List allList = null;

  private String id = null;

  private String officeCode = null;

  private String contractId = null;

  private String borrowerName = null;

  private String cardNum = null;

  private List loanBankNameList = new ArrayList();

  private Map houseTypeMap = new HashMap();

  private String beginBizDate = null;// 起始操作时间

  private String endBizDate = null;// 终止操作时间

  private String begindate = null;// 审批时间

  private String enddate = null;// 审批时间

  private Map contractStMap = new HashMap();// 合同状态下拉框

  private String contractStFind = null;// 合同状态查询条件

  private String orgName = null;

  private String loanBankName = null;// 放款银行

  private String houseType = null;// 购房类型

  private String contractSt = null;

  private Integer count = new Integer(0);

  private BigDecimal loanTotleMoney = new BigDecimal(0.00);// 借款金额-总额

  private String totalArea = null;

  private BigDecimal totalHousePrice = new BigDecimal(0.00);// 贷款总额

  public String getBeginBizDate() {
    return beginBizDate;
  }

  public void setBeginBizDate(String beginBizDate) {
    this.beginBizDate = beginBizDate;
  }

  public String getContractStFind() {
    return contractStFind;
  }

  public void setContractStFind(String contractStFind) {
    this.contractStFind = contractStFind;
  }

  public Map getContractStMap() {
    return contractStMap;
  }

  public void setContractStMap(Map contractStMap) {
    this.contractStMap = contractStMap;
  }

  public String getEndBizDate() {
    return endBizDate;
  }

  public void setEndBizDate(String endBizDate) {
    this.endBizDate = endBizDate;
  }

  public String getBorrowerName() {
    return borrowerName;
  }

  public void setBorrowerName(String borrowerName) {
    this.borrowerName = borrowerName;
  }

  public String getCardNum() {
    return cardNum;
  }

  public void setCardNum(String cardNum) {
    this.cardNum = cardNum;
  }

  public String getContractId() {
    return contractId;
  }

  public void setContractId(String contractId) {
    this.contractId = contractId;
  }

  public Integer getCount() {
    return count;
  }

  public void setCount(Integer count) {
    this.count = count;
  }

  public String getHouseType() {
    return houseType;
  }

  public void setHouseType(String houseType) {
    this.houseType = houseType;
  }

  public Map getHouseTypeMap() {
    return houseTypeMap;
  }

  public void setHouseTypeMap(Map houseTypeMap) {
    this.houseTypeMap = houseTypeMap;
  }

  public List getList() {
    return list;
  }

  public List getLoanBankNameList() {
    return loanBankNameList;
  }

  public void setLoanBankNameList(List loanBankNameList) {
    this.loanBankNameList = loanBankNameList;
  }

  public void setList(List list) {
    this.list = list;
  }

  public String getLoanBankName() {
    return loanBankName;
  }

  public void setLoanBankName(String loanBankName) {
    this.loanBankName = loanBankName;
  }

  public BigDecimal getLoanTotleMoney() {
    return loanTotleMoney;
  }

  public void setLoanTotleMoney(BigDecimal loanTotleMoney) {
    this.loanTotleMoney = loanTotleMoney;
  }

  public String getOrgName() {
    return orgName;
  }

  public void setOrgName(String orgName) {
    this.orgName = orgName;
  }

  public String getContractSt() {
    return contractSt;
  }

  public void setContractSt(String contractSt) {
    this.contractSt = contractSt;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getOfficeCode() {
    return officeCode;
  }

  public void setOfficeCode(String officeCode) {
    this.officeCode = officeCode;
  }

  public String getTotalArea() {
    return totalArea;
  }

  public void setTotalArea(String totalArea) {
    this.totalArea = totalArea;
  }

  public BigDecimal getTotalHousePrice() {
    return totalHousePrice;
  }

  public void setTotalHousePrice(BigDecimal totalHousePrice) {
    this.totalHousePrice = totalHousePrice;
  }

  public List getAllList() {
    return allList;
  }

  public void setAllList(List allList) {
    this.allList = allList;
  }

  public String getBegindate() {
    return begindate;
  }

  public void setBegindate(String begindate) {
    this.begindate = begindate;
  }

  public String getEnddate() {
    return enddate;
  }

  public void setEnddate(String enddate) {
    this.enddate = enddate;
  }

}
