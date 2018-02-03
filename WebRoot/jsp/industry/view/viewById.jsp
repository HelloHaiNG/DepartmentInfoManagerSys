<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<TITLE>支援信息</TITLE>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath }/css/Style.css"
	type=text/css rel=stylesheet>
<LINK href="${pageContext.request.contextPath }/css/Manage.css"
	type=text/css rel=stylesheet>

<script type="text/javascript">
	function check() {
		var istime = document.getElementById("istime").value;
		var ietime = document.getElementById("ietime").value;
		var idname = document.getElementById("idname").value;
		var ireqname = document.getElementById("ireqname").value;
		var ipnumber = document.getElementById("ipnumber").value;
		var ipname = document.getElementById("ipname").value;
		var iask = document.getElementById("iask").value;
		var iresname = document.getElementById("iresname").value;
		var ikind = document.getElementById("ikind").value;
		var itime = document.getElementById("itime").value;
		var imark = document.getElementById("imark").value;
		var istatus = document.getElementById("istatus").value;
		var iremark = document.getElementById("iremark").value;
		var id = document.getElementById("id").value;
		if (ireqname.length == 0 || ipnumber.length == 0 || ipname.length == 0
				|| iresname.length == 0 || imark.length == 0) {
			alert("请把信息填写完整");
			return false;
		}
		var patrn = /^[0-9a-zA-Z]+$/;
		if (!patrn.test(ipnumber)) {
			alert("项目编号只能是数字或者英文");
			return false;
		}
		window.location.href = "/ProManaPlatForm/industry_update.action?istime="
				+ istime
				+ "&ietime="
				+ ietime
				+ "&idname="
				+ idname
				+ "&ireqname="
				+ ireqname
				+ "&ipnumber="
				+ ipnumber
				+ "&ipname="
				+ ipname
				+ "&iask="
				+ iask
				+ "&iresname="
				+ iresname
				+ "&ikind="
				+ ikind
				+ "&itime="
				+ itime
				+ "&imark="
				+ imark
				+ "&istatus="
				+ istatus
				+ "&iremark="
				+ iremark
				+ "&id=" + id;
	}
</script>
<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
</HEAD>
<BODY>
	<FORM id=form1 name=form1 action="" method=post>
		<input type="hidden" name="id" id="id" value="${industry.id }" />
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG
						src="${pageContext.request.contextPath }/images/new_019.jpg"
						border=0></TD>
					<TD width="100%"
						background="${pageContext.request.contextPath }/images/new_020.jpg"
						height=20></TD>
					<TD width=15><IMG
						src="${pageContext.request.contextPath }/images/new_021.jpg"
						border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15 background=${pageContext.request.contextPath }
						/images/new_022.jpg><IMG
						src="${pageContext.request.contextPath }/images/new_022.jpg"
						border=0></TD>
					<TD vAlign=top width="100%" bgColor=#ffffff>
						<TABLE cellSpacing=0 cellPadding=5 width="100%" border=0>
							<TR>
								<TD class=manageHead>当前位置：工业中心 &gt; 添加信息</TD>
							</TR>
							<TR>
								<TD height=2></TD>
							</TR>
						</TABLE>

						<TABLE cellSpacing=0 cellPadding=5 border=0>
							<TR>
								<td>*发起时间：</td>
								<td><INPUT type="date" style="WIDTH: 180px" maxLength=50
									name="istime" id="istime" value="${industry.istime }" />
								</td>
								<td>结束时间：</td>
								<td><INPUT type="date" style="WIDTH: 180px" maxLength=50
									name="ietime" id="ietime" value="${industry.ietime }" />
								</td>
								<td>需求部门：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=50
									name="idname" id="idname" value="${industry.idname }" />
								</td>
								<td>*需求人：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=50
									name="ireqname" id="ireqname" value="${industry.ireqname }" />
								</td>
							</TR>
							<tr>
								<td>*项目编码：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=50
									name="ipnumber" id="ipnumber" value="${industry.ipnumber }" />
								</td>
								<td>*项目名称：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=50
									name="ipname" id="ipname" value="${industry.ipname }" />
								</td>
								<td>PI设计特殊要求：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=50
									name="iask" id="iask" value="${industry.iask }" />
								</td>
								<td>*设计人员：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=50
									name="iresname" id="iresname" value="${industry.iresname }" />
								</td>
							</tr>
							<tr>
								<td>设计类别：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=50
									name="ikind" id="ikind" value="${industry.ikind }" />
								</td>
								<td>支援工时：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=50
									name="itime" id="itime" value="${industry.itime }" /></td>
								<td>*测量权分：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=100
									name="imark" id="imark" value="${industry.imark }" />
								</td>
								<td>状态：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=100
									name="istatus" id="istatus" value="${industry.istatus }" />
								</td>
							</tr>
							<tr>
								<td>备注：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=50
									name="iremark" id="iremark" value="${industry.iremark }" />
								</td>
							</tr>
							<tr>
								<td rowspan=2><INPUT id=sButton2 type=button value=" 更新 "
									name=sButton2 onClick="check()">
								</td>
							</tr>
						</TABLE>
					</TD>
					<TD width=15
						background="${pageContext.request.contextPath }/images/new_023.jpg">
						<IMG src="${pageContext.request.contextPath }/images/new_023.jpg"
						border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG
						src="${pageContext.request.contextPath }/images/new_024.jpg"
						border=0></TD>
					<TD align=middle width="100%"
						background="${pageContext.request.contextPath }/images/new_025.jpg"
						height=15></TD>
					<TD width=15><IMG
						src="${pageContext.request.contextPath }/images/new_026.jpg"
						border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
	</FORM>
</BODY>
</HTML>
