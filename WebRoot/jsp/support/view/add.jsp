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
		if (sstime.length == 0 || sreqname.length == 0
				|| sprojectnumber.length == 0 || sprojectname.length == 0) {
			alert("请把信息填写完整");
			return false;
		}
		var patrn = /^[0-9a-zA-Z]+$/;
		if (!patrn.test(sprojectnumber)) {
			alert("项目编码只能是数字或者英文");
			return false;
		}
		var patrn = /^[0-9]+$/;
		if (!patrn.test(stime)) {
			alert("支援工时只能是数字");
			return false;
		}
		window.location.href = "/ProManaPlatForm/support_add.action?sstime="
				+ sstime + "&setime=" + setime + "&dname=" + dname
				+ "&sreqname=" + sreqname + "&sprojectnumber=" + sprojectnumber
				+ "&sprojectname=" + sprojectname + "&skind=" + skind
				+ "&squestion=" + squestion + "&sresolve=" + sresolve
				+ "&senergy=" + senergy + "&stime=" + stime + "&status="
				+ status + "&sremark=" + sremark;
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
								<TD class=manageHead>当前位置：支援信息 &gt; 添加支援</TD>
							</TR>
							<TR>
								<TD height=2></TD>
							</TR>
						</TABLE>

						<TABLE cellSpacing=0 cellPadding=5 border=0>
							<TR>
								<td>*发起时间：</td>
								<td><INPUT type="date" style="WIDTH: 180px" maxLength=50
									name="sstime" id="sstime" />
								</td>
								<td>结束时间：</td>
								<td><INPUT type="date" style="WIDTH: 180px" maxLength=50
									name="setime" id="setime" />
								</td>
								<td>需求部门：</td>
								<td><select id="dname" name="dname">
										<c:forEach items="${departments }" var="department">
											<option value="${department.dname }">${department.dname}</option>
										</c:forEach>
								</select>
								</td>
								<td>*需求人：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=50
									name="sreqname" id="sreqname" />
								</td>
							</TR>
							<tr>
								<td>*项目编码：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=50
									name="sprojectnumber" id="sprojectnumber" />
								</td>
								<td>*项目名称：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=50
									name="sprojectname" id="sprojectname" />
								</td>
								<td>支援类型：</td>
								<td><select name="skind" id="skind">
										<option value="机械技术支援">机械技术支援</option>
										<option value="电子技术支援">电子技术支援</option>
										<option value="模块板卡">模块板卡</option>
										<option value="自动化软件支援">自动化软件支援</option>
										<option value="自动化电气硬件支援">自动化电气硬件支援</option>
										<option value="光学支援">光学支援</option>
										<option value="外观设计">外观设计</option>
										<option value="钣金设计">钣金设计</option>
										<option value="方案设计参与">方案设计参与</option>
										<option value="顾问专家">顾问专家</option>
										<option value="其他备注说明">其他备注说明</option>
								</select>
								</td>
								<td>问题：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=50
									name="squestion" id="squestion" />
								</td>
							</tr>
							<tr>
								<td>解决问题：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=50
									name="sresolve" id="sresolve" />
								</td>
								<td>周期精力投入：</td>
								<td><select name="senergy" id="senergy">
										<option value="20">20%</option>
										<option value="40">40%</option>
										<option value="60">60%</option>
										<option value="80">80%</option>
										<option value="100">100%</option>
								</select>
								</td>
								<td>支援工时：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=100
									name="stime" id="stime" />
								</td>
								<td>状态：</td>
								<td><select name="status" id="status">
										<option value="ongoing">ongoing</option>
										<option value="closed">closed</option>
								</select>
								</td>
							</tr>
							<tr>
								<td>支援时间说明：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=50
									name="sremark" id="sremark" />
								</td>
							</tr>
							<tr>
								<td rowspan=2><INPUT id=sButton2 type=button value=" 添加 "
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
