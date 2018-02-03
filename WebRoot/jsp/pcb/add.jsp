<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<TITLE>添加pcb信息</TITLE>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath }/css/Style.css"
	type=text/css rel=stylesheet>
<LINK href="${pageContext.request.contextPath }/css/Manage.css"
	type=text/css rel=stylesheet>

<script type="text/javascript">
	function check() {
		var pcbnumber = document.getElementById("pcbnumber").value;
		var pcbname = document.getElementById("pcbname").value;
		var pcbversion = document.getElementById("pcbversion").value;
		var pcbremark = document.getElementById("pcbremark").value;
		var pnumber = document.getElementById("pnumber").value;
		if (pcbname.length == 0 || pcbversion.length == 0
				|| pcbremark.length == 0 || pcbnumber.length == 0) {
			alert("请把信息填写完整");
			return false;
		}
		window.location.href = "/ProManaPlatForm/pcb_add.action?pcbnumber="
				+ pcbnumber + "&pcbname=" + pcbname + "&pcbversion="
				+ pcbversion + "&pcbremark=" + pcbremark + "&pnumber="
				+ pnumber;
	}
</script>
<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
</HEAD>
<BODY>
	<FORM id=form1 name=form1 action="" method=post>

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
								<TD class=manageHead>当前位置：项目信息 &gt; 添加PCB</TD>
							</TR>
							<TR>
								<TD height=2></TD>
							</TR>
						</TABLE>

						<TABLE cellSpacing=0 cellPadding=5 border=0>
							<TR>
								<td>PCB料号：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=100
									name="pcbnumber" id="pcbnumber" />
								</td>
								<td>PCB名称：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=100
									name=pcbname id="pcbname" />
								</td>
								<td>PCB版本：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=100
									name="pcbversion" id="pcbversion" />
								</td>
							</TR>
							<tr>
								<td>PCB备注：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=100
									name="pcbremark" id="pcbremark" />
								</td>
								<td>项目编号：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=100
									name="pnumber" id="pnumber" value="${project.pnumber }" />
								</td>
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
