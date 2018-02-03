<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<TITLE>设备信息</TITLE>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath }/css/Style.css"
	type=text/css rel=stylesheet>
<LINK href="${pageContext.request.contextPath }/css/Manage.css"
	type=text/css rel=stylesheet>

<script type="text/javascript">
	function check() {
		var did = document.getElementById("did").value;
		var dmoney = document.getElementById("dmoney").value;
		var dname1 = document.getElementById("dname1").value;
		var dname2 = document.getElementById("dname2").value;
		var dversion = document.getElementById("dversion").value;
		var dbuytime = document.getElementById("dbuytime").value;
		var dposition = document.getElementById("dposition").value;
		var duser = document.getElementById("duser").value;
		var dstatus = document.getElementById("dstatus").value;
		var dcode = document.getElementById("dcode").value;
		var dborrow = document.getElementById("dborrow").value;
		var dback = document.getElementById("dback").value;
		var ddname = document.getElementById("ddname").value;
		var dborrowname = document.getElementById("dborrowname").value;
		var dremark = document.getElementById("dremark").value;
		var dlab = document.getElementById("dlab").value;
		if (dmoney.length == 0 || dname1.length == 0 || dname2.length == 0
				|| dversion.length == 0 || dposition.length == 0
				|| duser.length == 0 || dcode.length == 0
				|| dbuytime.length == 0) {
			alert("请把信息填写完整");
			return false;
		}
		var patrn = /^[0-9]+$/;
		if (!patrn.test(dmoney)) {
			alert("财务编号只能是数字");
			return false;
		}
		window.location.href = "/ProManaPlatForm/device_update.action?dmoney="
				+ dmoney + "&dname1=" + dname1 + "&dname2=" + dname2
				+ "&dversion=" + dversion + "&dbuytime=" + dbuytime
				+ "&dposition=" + dposition + "&duser=" + duser + "&dstatus="
				+ dstatus + "&dcode=" + dcode + "&dborrow=" + dborrow
				+ "&dback=" + dback + "&ddname=" + ddname + "&dborrowname="
				+ dborrowname + "&dremark=" + dremark + "&dlab=" + dlab
				+ "&did=" + did;
	}
</script>
<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
</HEAD>
<BODY>
	<FORM id=form1 name=form1 action="" method=post>
		<input type="hidden" name="did" id="did" value="${device.did }" />
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
								<TD class=manageHead>当前位置：设备中心 &gt; 更新信息</TD>
							</TR>
							<TR>
								<TD height=2></TD>
							</TR>
						</TABLE>

						<TABLE cellSpacing=0 cellPadding=5 border=0>
							<TR>
								<td>*财务编号：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=11
									name="dmoney" id="dmoney" value="${device.dmoney }" /></td>
								<td>*资产名称：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=50
									name="dname1" id="dname1" value="${device.dname1 }" /></td>
								<td>*品牌：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=50
									name="dname2" id="dname2" value="${device.dname2 }" /></td>
								<td>*规格型号：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=50
									name="dversion" id="dversion" value="${device.dversion }" /></td>
							</TR>
							<tr>
								<td>*购进时间：</td>
								<td><INPUT type="date" style="WIDTH: 180px" maxLength=50
									name="dbuytime" id="dbuytime" value="${device.dbuytime }" /></td>
								<td>*存放位置：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=50
									name="dposition" id="dposition" value="${device.dposition }" />
								</td>
								<td>*使用者：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=50
									name="duser" id="duser" value="${device.duser }" /></td>
								<td>资产状态：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=50
									name="dstatus" id="dstatus" value="${device.dstatus }" /></td>
							</tr>
							<tr>
								<td>*条形编码：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=50
									name="dcode" id="dcode" value="${device.dcode }" /></td>
								</td>
								<td>借用时间：</td>
								<td><INPUT type="date" style="WIDTH: 180px" maxLength=50
									name="dborrow" id="dborrow" value="${device.dborrow }" />
								</td>
								<td>归还时间：</td>
								<td><input type="date" style="WIDTH: 180px" maxLength=50
									name="dback" id="dback" value="${device.dback }" /></td>
								<td>借用部门：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=50
									name="ddname" id="ddname" value="${device.ddname }" /></td>
							</tr>
							<tr>
								<td>借用人：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=50
									name="dborrowname" id="dborrowname"
									value="${device.dborrowname }" /></td>
								<td>备注：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=50
									name="dremark" id="dremark" value="${device.dremark }" /></td>
								<td>实验室编号：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=50
									name="dlab" id="dlab" readonly="readonly"
									value="${device.dlab }" /></td>
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
