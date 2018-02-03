<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<TITLE>添加管理员信息</TITLE>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath }/css/Style.css"
	type=text/css rel=stylesheet>
<LINK href="${pageContext.request.contextPath }/css/Manage.css"
	type=text/css rel=stylesheet>

<script type="text/javascript">
function loseOnBlur() {
		var patrn = /^[0-9a-zA-Z]+$/;
		var unumber = document.getElementById("unumber").value;
		if (!patrn.test(unumber)) {
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
		xmlhttp.open("post", "user_judgeUnumber.action?timeStamp="
				+ new Date().getTime(), true);
		xmlhttp.setRequestHeader("Content-type",
				"application/x-www-form-urlencoded");
		xmlhttp.send("unumber=" + unumber);
	}
	function check() {
		var unumber = document.getElementById("unumber").value;
		var upwd = document.getElementById("upwd").value;
		var username = document.getElementById("username").value;
		var urole = document.getElementById("urole").value;
		if (unumber.length == 0 || username.length == 0) {
			alert("请信息填写完整");
			return false;
		}
		var patrn = /^[0-9a-zA-Z]+$/;
		if (!patrn.test(unumber)) {
			alert("工号只能是数字或者英文");
			return false;
		}
		window.location.href = "/ProManaPlatForm/user_add.action?unumber="
				+ unumber + "&upwd=" + upwd + "&username=" + username
				+ "&urole=" + urole;
	}
</script>
<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
</HEAD>
<BODY>
	<FORM id=form1 name=form1
		action="${pageContext.request.contextPath }/user_add.action"
		method=post>

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
								<TD class=manageHead>当前位置：管理员中心 &gt; 添加管理员</TD>
							</TR>
							<TR>
								<TD height=2></TD>
							</TR>
						</TABLE>

						<TABLE cellSpacing=0 cellPadding=5 border=0>
							<TR>
								<td>管理员工号：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=50
									name="unumber" id="unumber" onblur="loseOnBlur()"/></td>
								<td>姓名：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=50
									name="username" id="username" /></td>
								<td>密码：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=50
									name="upwd" id="upwd" value="123456" readonly="readonly" /></td>
								<td>级别：</td>
								<td><select name="urole" id="urole">
										<option value="部门管理员">部门管理员</option>
										<option value="项目管理员">项目管理员</option>
										<option value="设备管理员">设备管理员</option>
										<option value="工业管理员">工业管理员</option>
								</select></td>
							</TR>
							<tr>
								<td rowspan=2><INPUT id=sButton2 type=button value=" 添加 "
									name=sButton2 onClick="check()" disabled="disabled"></td>
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
