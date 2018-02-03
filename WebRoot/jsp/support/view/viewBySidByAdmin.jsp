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
		var sid = document.getElementById("sid").value;
		var sstime = document.getElementById("sstime").value;
		var setime = document.getElementById("setime").value;
		var dname = document.getElementById("dname").value;
		var sreqname = document.getElementById("sreqname").value;
		var sprojectnumber = document.getElementById("sprojectnumber").value;
		var sprojectname = document.getElementById("sprojectname").value;
		var skind = document.getElementById("skind").value;
		var squestion = document.getElementById("squestion").value;
		var sresolve = document.getElementById("sresolve").value;
		var senergy = document.getElementById("senergy").value;
		var stime = document.getElementById("stime").value;
		var status = document.getElementById("status").value;
		var sremark = document.getElementById("sremark").value;
		var sresname = document.getElementById("sresname").value;
		var standardcharge = document.getElementById("standardcharge").value;
		var srealitycharge = document.getElementById("srealitycharge").value;
		var soverstandardcharge = document.getElementById("soverstandardcharge").value;
		var srealityovercharge = document.getElementById("srealityovercharge").value;
		var sisclosecharge = document.getElementById("sisclosecharge").value;
		if (sstime.length == 0 || sreqname.length == 0
				|| sprojectnumber.length == 0 || sprojectname.length == 0
				|| standardcharge.length == 0 || soverstandardcharge.length == 0 
				|| srealityovercharge.length == 0 || sisclosecharge.length == 0) {
			alert("请把信息填写完整");
			return false;
		}
		var patrn = /^[0-9a-zA-Z]+$/;
		if (!patrn.test(sprojectnumber)) {
			alert("项目编码只能是数字或者英文");
			return false;
		}
		window.location.href = "/ProManaPlatForm/support_updateByManager.action?sstime="
				+ sstime + "&setime=" + setime + "&dname=" + dname
				+ "&sreqname=" + sreqname + "&sprojectnumber=" + sprojectnumber
				+ "&sprojectname=" + sprojectname + "&skind=" + skind
				+ "&squestion=" + squestion + "&sresolve=" + sresolve
				+ "&senergy=" + senergy + "&stime=" + stime + "&status="
				+ status + "&sremark=" + sremark + "&sresname=" + sresname
				+ "&sid=" + sid + "&standardcharge=" + standardcharge
				+ "&srealitycharge=" + srealitycharge + "&soverstandardcharge="
				+ soverstandardcharge + "&srealityovercharge=" + srealityovercharge
				+ "&sisclosecharge=" + sisclosecharge;
	}
</script>
<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
</HEAD>
<BODY>
	<FORM id=form1 name=form1 action="" method=post>
		<input type="hidden" name="sid" id="sid" value="${support.sid }" />
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
								<TD class=manageHead>当前位置：支援信息 &gt; 支援信息</TD>
							</TR>
							<TR>
								<TD height=2></TD>
							</TR>
						</TABLE>

						<TABLE cellSpacing=0 cellPadding=5 border=0>
							<TR>
								<td>*发起时间：</td>
								<td><INPUT type="date" style="WIDTH: 180px" maxLength=50
									name="sstime" id="sstime" value="${support.sstime }"
									readonly="readonly" />
								</td>
								<td>结束时间：</td>
								<td><INPUT type="date" style="WIDTH: 180px" maxLength=50
									name="setime" id="setime" value="${support.setime }"
									readonly="readonly" />
								</td>
								<td>需求部门：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=50
									name="dname" id="dname" value="${support.sdepartmentname}"
									readonly="readonly" />
								</td>
								<td>*需求人：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=50
									name="sreqname" id="sreqname" value="${support.sreqname }"
									readonly="readonly" />
								</td>
							</TR>
							<tr>
								<td>*项目编码：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=50
									name="sprojectnumber" id="sprojectnumber"
									value="${support.sprojectnumber }" readonly="readonly" />
								</td>
								<td>*项目名称：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=50
									name="sprojectname" id="sprojectname"
									value="${support.sprojectname }" readonly="readonly" />
								</td>
								<td>支援类型：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=50
									name="skind" id="skind" value="${support.skind }"
									readonly="readonly" /></td>
								<td>问题：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=50
									name="squestion" id="squestion" value="${support.squestion }"
									readonly="readonly" />
								</td>
							</tr>
							<tr>
								<td>解决问题：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=50
									name="sresolve" id="sresolve" value="${support.sresolve }"
									readonly="readonly" />
								</td>
								<td>周期精力投入：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=100
									name="senergy" id="senergy" value="${support.senergy }"
									readonly="readonly" />
								</td>
								<td>支援工时：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=100
									name="stime" id="stime" value="${support.stime }"
									readonly="readonly" />
								</td>
								<td>状态：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=100
									name="status" id="status" value="${support.status }"
									readonly="readonly" /></td>
							</tr>
							<tr>
								<td>支援时间说明：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=50
									name="sremark" id="sremark" value="${support.sremark }"
									readonly="readonly" />
								</td>
								<td>*支援人：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=50
									name="sresname" id="sresname" readonly="readonly"
									value="${support.sresname }" />
								</td>
								<td>*收费标准：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=50
									name="standardcharge" id="standardcharge"
									value="${support.standardcharge }" /></td>
								<td>*实际收费：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=50
									name="srealitycharge" id="srealitycharge" readonly="readonly"
									value="${support.srealitycharge }" /></td>
							</tr>
							<tr>
								<td>*超时收费标准：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=50
									name="soverstandardcharge" id="soverstandardcharge"
									value="${support.soverstandardcharge }" /></td>
								<td>*实际超时收费：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=50
									name="srealityovercharge" id="srealityovercharge"
									value="${support.srealityovercharge }" /></td>
								<td>*费用是否结算：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=50
									name="sisclosecharge" id="sisclosecharge"
									value="${support.sisclosecharge }" /></td>
							</tr>
							<tr>
								<td rowspan=2><INPUT id=sButton2 type=button value=" 更新  "
									name=sButton2 onClick="check()"></td>
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
