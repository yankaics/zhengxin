<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/WEB-INF/taglib/struts-html.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/taglib/struts-html.tld" prefix="logic" %>
<%@ page import="org.xpup.hafmis.sysloan.specialbiz.bailenrol.dto.*" %>
<%@ include file="/checkUrl.jsp"%>
<%
   String path=request.getContextPath();
   String url = (String) request.getAttribute("URL");
	if (url == null) {
		url = "bailenRolTaShowAC.do";
	}
 %>
<html>
  <head>
  <script src="<%=path%>/js/common.js">
</script>
  </head>
  <script type="text/javascript">
	function load(){
	loginReg();
	document.forms(0).Cell1.openfile("<%=path%>/sysloan/specialbiz/report/bailenrolta.cll","");
	<%
    		BailenRolTaPrintDTO bailenRolTaPrintDTO=(BailenRolTaPrintDTO)request.getAttribute("bailenRolTaPrintDTO");
    		String m=bailenRolTaPrintDTO.getOccurMoney().toString();
	%>
		
		var sumPay = <%=bailenRolTaPrintDTO.getOccurMoney()%>;
		var chiao="0";
		var fin="0";
		sumPay=""+sumPay;
		var count=sumPay.indexOf(".",0);
		var length;
		len=sumPay.length;
		if(count==-1){
			length=len;
		}else{
			length=count;
		}
		for(var i=0;i<length;i++){//从后向前插入（从元起）
			var temp=sumPay.substring((length-i-1),length-i);
			document.forms(0).Cell1.S((15-i),10,0,temp);
		}
		if(count!=-1){//计算小数后面
			if((len-count)>2)//两位
			{
				chiao=sumPay.substring(count+1,sumPay.length-1);
				fin=sumPay.substring(count+2,sumPay.length);
				
				document.forms(0).Cell1.S(16,10,0,chiao);
				document.forms(0).Cell1.S(17,10,0,fin);
			}
			else{//只有一位
				chiao=sumPay.substring(count+1,sumPay.length)
				document.forms(0).Cell1.S(16,10,0,chiao);
				document.forms(0).Cell1.S(17,10,0,"0");
				}	
		}else{
			document.forms(0).Cell1.S(16,10,0,chiao);
			document.forms(0).Cell1.S(17,10,0,fin);
		}
		
		sumPay=ChangeToBig(sumPay);
		document.forms(0).Cell1.S(8,4,0,"<%=bailenRolTaPrintDTO.getDocNum() %>");
		document.forms(0).Cell1.S(14,4,0,"<%=bailenRolTaPrintDTO.getNoteNum() %>");
		document.forms(0).Cell1.S(3,5,0,"<%=bailenRolTaPrintDTO.getContractId() %>");
		document.forms(0).Cell1.S(8,5,0,"<%=bailenRolTaPrintDTO.getBorrowerName()%>");
		document.forms(0).Cell1.S(3,6,0,"<%=bailenRolTaPrintDTO.getCardKind()%>");
		document.forms(0).Cell1.S(8,6,0,"<%=bailenRolTaPrintDTO.getCardNum()%>");
		document.forms(0).Cell1.S(3,7,0,"<%=bailenRolTaPrintDTO.getLoanBankName()%>");
		document.forms(0).Cell1.S(8,7,0,"<%=bailenRolTaPrintDTO.getLoanKouAcc()%>");
		document.forms(0).Cell1.S(3,8,0,"<%=bailenRolTaPrintDTO.getBizDate()%>");
		document.forms(0).Cell1.S(3,9,0,sumPay);
		document.forms(0).Cell1.S(2,16,0,"<%=bailenRolTaPrintDTO.getUserName()%>");
		document.forms(0).Cell1.S(3,4,0,"<%=bailenRolTaPrintDTO.getUserBizDate()%>");
		
					
				document.forms(0).Cell1.AllowExtend=false;
				document.forms(0).Cell1.AllowDragdrop=false;
				document.forms(0).Cell1.WorkbookReadonly=true;	
}
function printPreview(){
		var k=document.forms(0).Cell1.GetCurSheet();//显示打印预览那个页面
		document.forms(0).Cell1.printPreviewEx(1,k,false);
	}
	function Button1_onclick()
	{
		document.forms(0).Cell1.SaveFile();
	}
	function Button2_onclick()
	{
		document.forms(0).Cell1.ExportPdfFile("d:\\aa",-1,1,1);
	}
	function Button3_onclick()
	{
		document.forms(0).Cell1.PrintPageSetup();
	}
	function Button4_onclick()
	{
		document.forms(0).Cell1.FindDialogEx( 0,"");
	}
		function Button5_onclick()
	{
		document.forms(0).Cell1.ImportExcelDlg();
	}
	
	function printsheet(){//真正的打印
		var k=document.forms(0).Cell1.GetCurSheet();//显示打印预览那个页面--固定
		document.forms(0).Cell1.PrintSheet(1,k);//固定...
	}		
</script>

<script language="JScript.Encode">
eval(unescape('function%20LoginRegister%28%29//%u6CE8%u518CCELL%0D%0A%20%7B%20%0D%0A%20document.forms%280%29.Cell1.Login%28%22%u6C88%u9633%u91D1%u8F6F%u79D1%u6280%u6709%u9650%u516C%u53F8%22%2C%22%22%2C%2213100104509%22%2C%220740-1662-7775-3003%22%29%3B%20%20%20%20%0D%0A%20%7D'))
</script>	
  <body onload = "load();"> 
    <form action="">
    <table align="center">
<tr><OBJECT id=Cell1 style= "LEFT:0px;WIDTH:700px;  TOP:0px;HEIGHT:400px" codeBase="http://192.168.1.44:8088/hafmis/CellWeb5.CAB#version=5,3,7,321" classid=clsid:3F166327-8030-4881-8BD2-EA25350E574A VIEWASTEXT><PARAM NAME="_Version" VALUE="65536"><PARAM NAME="_ExtentX" VALUE="10266"><PARAM NAME="_ExtentY" VALUE="7011"><PARAM NAME="_StockProps" VALUE= "0"></OBJECT></tr> 
<tr>
<td><input type="button" name="print" value = "打印预览" onclick = "printPreview();"/></td>
<td><INPUT id="Button1" onclick="printsheet()" type="button" value=" 打印 " name="Button1"></td>
<td><INPUT id="Button1" onclick="Button1_onclick()" type="button" value="另存为Excel" name="Button1"></td>
<td><INPUT id="Button1" onclick="Button2_onclick()" type="button" value="另存为pdf" name="Button1"></td>
<td><INPUT id="Button3" style="WIDTH: 100px" onclick="Button3_onclick()" type="button" value="页面设置"></td>
<td><INPUT id="Button3" style="WIDTH: 100px" onclick="Button4_onclick()" type="button" value="查找对话框"></td>
<td><INPUT id="Button3" style="WIDTH: 100px" onclick="Button5_onclick()" type="button" value="excel导入"></td>
<td><INPUT id="Button3" onclick="location.href='<%=url%>'" type="button" value=" 返回 "></td>	
</table>
</form>
  </body>
</html>
