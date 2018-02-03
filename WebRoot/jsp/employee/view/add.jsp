<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<TITLE>通讯录信息</TITLE>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath }/css/Style.css"
	type=text/css rel=stylesheet>
<LINK href="${pageContext.request.contextPath }/css/Manage.css"
	type=text/css rel=stylesheet>

<script type="text/javascript">
	function loseOnBlur() {
		var patrn = /^[0-9a-zA-Z]+$/;
		var enumber = document.getElementById("enumber").value;
		if (!patrn.test(enumber)) {
			alert("工号只能是数字或者英文");
			return false;
		}
		var xmlhttp;
		if (window.XMLHttpRequest) {
			xmlhttp = new XMLHttpRequest();
		} else {
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4) {
				if (xmlhttp.status == 200) {
					var string = xmlhttp.responseText;
					if (string === "该工号可用") {
						document.getElementById("sButton2").disabled = false;
					} else {
						document.getElementById("sButton2").disabled = true;
					}
				}
			}
		}
		xmlhttp.open("post", "employee_judgeEnumber.action?timeStamp="
				+ new Date().getTime(), true);
		xmlhttp.setRequestHeader("Content-type",
				"application/x-www-form-urlencoded");
		xmlhttp.send("enumber=" + enumber);
	}
	function check() {
		var enumber = document.getElementById("enumber").value;
		var epwd = document.getElementById("epwd").value;
		var ename = document.getElementById("ename").value;
		var esex = document.getElementById("esex").value;
		var eposition = document.getElementById("eposition").value;
		var ephone1 = document.getElementById("ephone1").value;
		var ephone2 = document.getElementById("ephone2").value;
		var gname = document.getElementById("gname").value;
		var emana = document.getElementById("emana").value;
		var eworkplace = document.getElementById("eworkplace").value;
		var email = document.getElementById("email").value;
		var eremark = document.getElementById("eremark").value;
		var edate = document.getElementById("edate").value;
		var eschool = document.getElementById("eschool").value;
		var educ = document.getElementById("educ").value;
		var eids = document.getElementById("eids").value;
		if (enumber.length == 0 || ename.length == 0 || ephone1.length == 0
				|| email.length == 0 || eids.length == 0 || edate.length == 0) {
			alert("请把信息填写完整");
			return false;
		}
		var patrn = /^[0-9a-zA-Z]+$/;
		if (!patrn.test(enumber)) {
			alert("工号只能是数字或者英文");
			return false;
		}
		var regex = /^([0-9A-Za-z\-_\.]+)@([0-9a-z]+\.[a-z]{2,3}(\.[a-z]{2})?)$/g;
		if (!regex.test(email)) {
			alert("邮箱格式有误");
			return false;
		}
		window.location.href = "/ProManaPlatForm/employee_add.action?enumber="
				+ enumber + "&ename=" + ename + "&emana=" + emana + "&ephone2="
				+ ephone2 + "&gname=" + gname + "&esex=" + esex + "&eposition="
				+ eposition + "&ephone1=" + ephone1 + "&eworkplace="
				+ eworkplace + "&email=" + email + "&eremark=" + eremark
				+ "&epwd=" + epwd + "&edate=" + edate + "&eschool=" + eschool
				+ "&educ=" + educ + "&eids=" + eids;
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
								<TD class=manageHead>当前位置：通讯录 &gt; 添加员工</TD>
							</TR>
							<TR>
								<TD height=2></TD>
							</TR>
						</TABLE>

						<TABLE cellSpacing=0 cellPadding=5 border=0>
							<TR>
								<td>*工号：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=50
									name="enumber" id="enumber" onblur="loseOnBlur()" />
								</td>
								<td>*姓名：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=50
									name="ename" id="ename" />
								</td>
								<td>性别：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=50
									name="esex" id="esex" />
								</td>
								<td>职位：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=50
									name="eposition" id="eposition" />
								</td>
							</TR>
							<tr>
								<td>*电话1：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=50
									name="ephone1" id="ephone1" />
								</td>
								<td>电话2：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=50
									name="ephone2" id="ephone2" />
								</td>
								<td>组别：</td>
								<td><select name="gname" id="gname">
										<c:forEach items="${group }" var="group">
											<option value="${group.gname }">${group.gname}</option>
										</c:forEach>
								</select>
								</td>
								<td>管培生：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=50
									name="emana" id="emana" />
								</td>
							</tr>
							<tr>
								<td>办公地点：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=50
									name="eworkplace" id="eworkplace" />
								</td>
								<td>备注：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=100
									name="eremark" id="eremark" />
								</td>
								<td>*邮箱：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=100
									name="email" id="email" />
								</td>
								<td>*入职日期：</td>
								<td><INPUT type="date" style="WIDTH: 180px" maxLength=100
									name="edate" id="edate" />
								</td>
							</tr>
							<tr>
								<td>院校：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=50
									name="eschool" id="eschool" />
								</td>
								<td>学历：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=100
									name="educ" id="educ" />
								</td>
								<td>*身份证：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=100
									name="eids" id="eids" />
								</td>
							</tr>
							<tr>
								<td rowspan=2><INPUT id=sButton2 type=button value=" 添加 "
									name=sButton2 onClick="check()" disabled="disabled">
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
