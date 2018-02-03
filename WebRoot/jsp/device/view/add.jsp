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
		var doldnumber = document.getElementById("doldnumber").value;
		if (dmoney.length == 0 || dname1.length == 0 || dname2.length == 0
				|| dversion.length == 0 || dposition.length == 0
				|| duser.length == 0 || dcode.length == 0 || dbuytime.length == 0) {
			alert("请把信息填写完整");
			return false;
		}
		var patrn = /^[0-9]+$/;
		if (!patrn.test(dmoney)) {
			alert("财务编号只能是数字");
			return false;
		}
		window.location.href = "/ProManaPlatForm/device_add.action?dmoney="
				+ dmoney + "&dname1=" + dname1 + "&dname2=" + dname2
				+ "&dversion=" + dversion + "&dbuytime=" + dbuytime
				+ "&dposition=" + dposition + "&duser=" + duser + "&dstatus="
				+ dstatus + "&dcode=" + dcode + "&dborrow=" + dborrow + "&dback="
				+ dback + "&ddname=" + ddname + "&dborrowname=" + dborrowname
				+ "&dremark=" + dremark + "&doldnumber=" + doldnumber;
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
								<TD class=manageHead>当前位置：设备中心 &gt; 添加信息</TD>
							</TR>
							<TR>
								<TD height=2></TD>
							</TR>
						</TABLE>

						<TABLE cellSpacing=0 cellPadding=5 border=0>
							<TR>
								<td>*财务编号：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=11
									name="dmoney" id="dmoney" /></td>
								<td>*资产名称：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=50
									name="dname1" id="dname1" /></td>
								<td>*品牌：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=50
									name="dname2" id="dname2" /></td>
								<td>*规格型号：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=50
									name="dversion" id="dversion" /></td>
							</TR>
							<tr>
								<td>*购进时间：</td>
								<td><INPUT type="date" style="WIDTH: 180px" maxLength=50
									name="dbuytime" id="dbuytime" /></td>
								<td>*存放位置：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=50
									name="dposition" id="dposition" /></td>
								<td>*使用者：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=50
									name="duser" id="duser" /></td>
								<td>资产状态：</td>
								<td><select name="dstatus" id="dstatus">
										<option value="正常">正常</option>
										<option value="借用">借用</option>
										<option value="故障">故障</option>
										<option value="故障送修">故障送修</option>
										<option value="外借">外借</option>
										<option value="使用中">使用中</option>
										<option value="不外借">不外借</option>
										<option value="返厂">返厂</option>
										<option value="报废">报废</option>
										<option value="其他备注说明">其他备注说明</option>
								</select></td>
							</tr>
							<tr>
								<td>*条形编码：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=50
									name="dcode" id="dcode" /></td></td>
								<td>借用时间：</td>
								<td><INPUT type="date" style="WIDTH: 180px" maxLength=50
									name="dborrow" id="dborrow" />
								</td>
								<td>归还时间：</td>
								<td><input type="date" style="WIDTH: 180px" maxLength=50
									name="dback" id="dback" /></td>
								<td>借用部门：</td>
								<td><select name="ddname" id="ddname">
										<c:forEach items="${department }" var="department">
											<option value="${department.dname }">${department.dname}</option>
										</c:forEach>
								</select></td>
							</tr>
							<tr>
								<td>借用人：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=50
									name="dborrowname" id="dborrowname" /></td>
								<td>备注：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=50
									name="dremark" id="dremark" /></td>
								<td>旧编码：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=50
									name="doldnumber" id="doldnumber" /></td>
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
