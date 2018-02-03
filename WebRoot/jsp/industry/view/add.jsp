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
		window.location.href = "/ProManaPlatForm/industry_add.action?istime="
				+ istime + "&ietime=" + ietime + "&idname=" + idname
				+ "&ireqname=" + ireqname + "&ipnumber=" + ipnumber
				+ "&ipname=" + ipname + "&iask=" + iask + "&iresname="
				+ iresname + "&ikind=" + ikind + "&itime=" + itime + "&imark="
				+ imark + "&istatus=" + istatus + "&iremark=" + iremark;
	}
</script>
<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
</HEAD>
<BODY>
	<FORM id=form1 name=form1 action="" method=post>
		<input type="hidden" name="epwd" id="epwd" value="123456" />
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG
						src="${pageContext.request.contextPath }/images/new_019.jpg"
						border=0>
					</TD>
					<TD width="100%"
						background="${pageContext.request.contextPath }/images/new_020.jpg"
						height=20></TD>
					<TD width=15><IMG
						src="${pageContext.request.contextPath }/images/new_021.jpg"
						border=0>
					</TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15 background=${pageContext.request.contextPath }
						/images/new_022.jpg><IMG
						src="${pageContext.request.contextPath }/images/new_022.jpg"
						border=0>
					</TD>
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
								<td><INPUT style="WIDTH: 180px" maxLength=50 name="istime"
									id="istime" type="date" /></td>
								<td>结束时间：</td>
								<td><INPUT style="WIDTH: 180px" maxLength=50 name="ietime"
									id="ietime" type="date" /></td>
								<td>需求部门：</td>
								<td><select id="idname" name="idname">
										<c:forEach items="${department }" var="department">
											<option value="${department.dname }">${department.dname}</option>
										</c:forEach>
								</select></td>
								<td>*需求人：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=50
									name="ireqname" id="ireqname" /></td>
							</TR>
							<tr>
								<td>*项目编码：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=50
									name="ipnumber" id="ipnumber" /></td>
								<td>*项目名称：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=50
									name="ipname" id="ipname" /></td>
								<td>PI设计特殊要求：</td>
								<td><select name="iask" id="iask">
										<option value="外观设计">技术支持</option>
										<option value="钣金设计">项目跟进</option>
										<option value="项目跟进">PI设计</option>
										<option value="其他备注说明">其他备注说明</option>
								</select></td>
								<td>*设计人员：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=50
									name="iresname" id="iresname" /></td>
							</tr>
							<tr>
								<td>设计类别：</td>
								<td><select name="ikind" id="ikind">
										<option value="创新设计">创新设计</option>
										<option value="钣金设计">钣金设计</option>
										<option value="商务进攻">商务进攻</option>
										<option value="PI2.0应用设计">PI2.0应用设计</option>
										<option value="项目跟进">项目跟进</option>
										<option value="其他备注说明">其他备注说明</option>
								</select></td>
								<td>支援工时：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=50
									name="itime" id="itime" />
								</td>
								<td>*测量权分：</td>
								<td><select name="imark" id="imark">
										<option value="0.35">0.35</option>
										<option value="0.5">0.5</option>
										<option value="1">1</option>
										<option value="项目跟进不计分">项目跟进不计分</option>
										<option value="其他备注说明">其他备注说明</option>
								</select></td>
								<td>状态：</td>
								<td><select name="istatus" id="istatus">
										<option value="ongoing">ongoing</option>
										<option value="closed">closed</option>
								</select></td>
							</tr>
							<tr>
								<td>备注：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=50
									name="iremark" id="iremark" /></td>
							</tr>
							<tr>
								<td rowspan=2><INPUT id=sButton2 type=button value=" 添加 "
									name=sButton2 onClick="check()"></td>
							</tr>
						</TABLE></TD>
					<TD width=15
						background="${pageContext.request.contextPath }/images/new_023.jpg">
						<IMG src="${pageContext.request.contextPath }/images/new_023.jpg"
						border=0>
					</TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG
						src="${pageContext.request.contextPath }/images/new_024.jpg"
						border=0>
					</TD>
					<TD align=middle width="100%"
						background="${pageContext.request.contextPath }/images/new_025.jpg"
						height=15></TD>
					<TD width=15><IMG
						src="${pageContext.request.contextPath }/images/new_026.jpg"
						border=0>
					</TD>
				</TR>
			</TBODY>
		</TABLE>
	</FORM>
</BODY>
</HTML>
