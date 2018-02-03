<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<TITLE>修改个人密码</TITLE>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath }/css/Style.css"
	type=text/css rel=stylesheet>
<LINK href="${pageContext.request.contextPath }/css/Manage.css"
	type=text/css rel=stylesheet>

<script type="text/javascript">
	function check() {
		var unumber = document.getElementById("unumber").value;
		var username = document.getElementById("username").value;
		var urole = document.getElementById("urole").value;
		var upwd = document.getElementById("upwd").value;
		var patrn = /^[0-9a-zA-Z]+$/;
		if (upwd.length == 0 || username.length == 0) {
			alert("信息不能为空");
			return false;
		}
		if (!patrn.test(upwd)) {
			alert("密码只能是数字或者英文");
			return false;
		}
		window.location.href = "/ProManaPlatForm/user_update.action?unumber="
				+ unumber + "&upwd=" + upwd + "&urole=" + urole + "&username=" + username;
	}
</script>
<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
</HEAD>
<BODY>
	<FORM id=form1 name=form1 action="" method=post>

		<input type="hidden" name="unumber" id="unumber"
			value="${user.unumber }" /> <input type="hidden" name="urole"
			id="urole" value="${user.urole }" />
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
								<TD class=manageHead>当前位置：个人中心 &gt; 修改个人信息</TD>
							</TR>
							<TR>
								<TD height=2></TD>
							</TR>
						</TABLE>

						<TABLE cellSpacing=0 cellPadding=5 border=0>
						<TR>
								<td>姓名：</td>
								<td><INPUT class=textbox id="username" style="WIDTH: 180px"
									maxLength=50 name="username" value=${user.username } /></td>
							</TR>
							<TR>
								<td>密码：</td>
								<td><INPUT class=textbox id="upwd" style="WIDTH: 180px"
									maxLength=50 name="upwd" value=${user.upwd } /></td>
							</TR>
							<tr>
								<td rowspan=2><INPUT id=sButton2 type=button value=" 保存 "
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
