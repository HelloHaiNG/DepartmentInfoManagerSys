<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<TITLE>添加项目信息</TITLE>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath }/css/Style.css"
	type=text/css rel=stylesheet>
<LINK href="${pageContext.request.contextPath }/css/Manage.css"
	type=text/css rel=stylesheet>

<script type="text/javascript">
	function check() {
		var pname = document.getElementById("pname").value;
		var ptime = document.getElementById("ptime").value;
		var pdutyname = document.getElementById("pdutyname").value;
		var pmapnumber = document.getElementById("pmapnumber").value;
		var pME = document.getElementById("pME").value;
		var pEE = document.getElementById("pEE").value;
		var pSW = document.getElementById("pSW").value;
		var premark = document.getElementById("premark").value;
		var pstatus = document.getElementById("pstatus").value;
		var unumber = document.getElementById("unumber").value;
		var producekind = document.getElementById("producekind").value;
		var pmothercode = document.getElementById("pmothercode").value;
		var pshortname = document.getElementById("pshortname").value;
		var place = document.getElementById("place").value;
		var pnum = document.getElementById("pnum").value;
		var po = document.getElementById("po").value;
		var period = document.getElementById("period").value;
		var pfinishtime = document.getElementById("pfinishtime").value;
		var papn = document.getElementById("papn").value;
		var psn = document.getElementById("psn").value;
		var pwords = document.getElementById("pwords").value;
		var pcbnumber = document.getElementById("pcbnumber").value;
		var pcbname = document.getElementById("pcbname").value;
		var pcbversion = document.getElementById("pcbversion").value;
		var pcbremark = document.getElementById("pcbremark").value;
		var mnumber = document.getElementById("mnumber").value;
		var mversion = document.getElementById("mversion").value;
		var mremark = document.getElementById("mremark").value;
		var snumber = document.getElementById("snumber").value;
		var sversion = document.getElementById("sversion").value;
		var sremark = document.getElementById("sremark").value;
		if (pname.length == 0 || pME.length == 0 || pSW.length == 0 || pEE.length == 0				
				|| pdutyname.length == 0 || ptime.length == 0) {
			alert("请把信息填写完整");
			return false;
		}
		window.location.href = "/ProManaPlatForm/project_add.action?pname="
				+ pname + "&pmapnumber=" + pmapnumber + "&pME=" + pME + "&pEE="
				+ pEE + "&pSW=" + pSW + "&pdutyname=" + pdutyname + "&premark="
				+ premark + "&pstatus=" + pstatus + "&unumber=" + unumber
				+ "&producekind=" + producekind + "&pmothercode=" + pmothercode
				+ "&pshortname=" + pshortname + "&place=" + place + "&pnum="
				+ pnum + "&po=" + po + "&period=" + period + "&pfinishtime="
				+ pfinishtime + "&papn=" + papn + "&psn=" + psn + "&pwords="
				+ pwords + "&pcbnumber=" + pcbnumber + "&pcbname=" + pcbname
				+ "&pcbversion=" + pcbversion + "&pcbremark=" + pcbremark
				+ "&mnumber=" + mnumber + "&mversion=" + mversion + "&mremark="
				+ mremark + "&snumber=" + snumber + "&sversion=" + sversion
				+ "&sremark=" + sremark + "&ptime=" + ptime;
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
								<TD class=manageHead>当前位置：项目信息 &gt; 添加项目</TD>
							</TR>
							<TR>
								<TD height=2></TD>
							</TR>
						</TABLE>

						<TABLE cellSpacing=0 cellPadding=5 border=0>
							<TR>
								<td>*项目名称：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=50
									name="pname" id="pname" /></td>
								<td>图纸号：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=50
									name="pmapnumber" id="pmapnumber" /></td>
								<td>*项目负责人：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=50
									name="pdutyname" id="pdutyname" />
								<td>*ME：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=50
									name="pME" id="pME" /></td>
							</TR>
							<tr>
								<td>*EE：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=50
									name="pEE" id="pEE" /></td>
								<td>*SW：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=50
									name="pSW" id="pSW" /></td>
								<td>项目状态：</td>
								<td><select name="pstatus" id="pstatus">
										<option value="ongoing">ongoing</option>
										<option value="closed">closed</option>
								</select></td>
								<td>备注：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=100
									name="premark" id="premark" />
								</td>
							</tr>
							<tr>
								<td>*录入人编号：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=100
									name="unumber" id="unumber" readonly="readonly"
									value=${user.unumber } />
								</td>
								<td>成品编码：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=100
									name="pmothercode" id="pmothercode" />
								</td>
								<td>项目内部简称：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=100
									name="pshortname" id="pshortname" />
								</td>
								<td>出货时间：</td>
								<td><INPUT type="date" style="WIDTH: 180px" maxLength=100
									name="pfinishtime" id="pfinishtime"/>
								</td>
							</tr>
							<tr>
								<td>出货地点：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=100
									name="place" id="place" />
								</td>
								<td>数量：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=100
									name="pnum" id="pnum" />
								</td>
								<td>PO：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=100
									name="po" id="po" />
								</td>
								<td>阶段：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=100
									name="period" id="period" />
								</td>
							</tr>
							<tr>
								<td>APN：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=100
									name="papn" id="papn" />
								</td>
								<td>出货SN：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=100
									name=psn id="psn" />
								</td>
								<td>铭牌刻字：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=100
									name="pwords" id="pwords" />
								</td>
								<td>产品类别：</td>
								<td><select name="producekind" id="producekind">
										<option value="测试设备类A">测试设备类A</option>
										<option value="自动化设备类B">自动化设备类B</option>
										<option value="自动化类配件C">自动化类配件C</option>
										<option value="测试类配件C">测试类配件C</option>
										<option value="N/A-D">N/A-D</option>
								</select></td>
							</tr>
							<tr>
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
								<td>PCB备注：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=100
									name="pcbremark" id="pcbremark" />
								</td>
							</tr>
							<tr>
								<td>机械BOM：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=100
									name="mnumber" id="mnumber" />
								</td>
								<td>机械版本：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=100
									name=mversion id="mversion" />
								</td>
								<td>机械备注：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=100
									name="mremark" id="mremark" />
								</td>
								<td>软件编号：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=100
									name="snumber" id="snumber" />
								</td>
							</tr>
							<tr>
								<td>软件版本：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=100
									name="sversion" id="sversion" />
								</td>
								<td>软件备注：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=100
									name="sremark" id="sremark" />
								</td>
								<td>*项目时间：</td>
								<td><INPUT type="date" style="WIDTH: 180px" maxLength=50
									name="ptime" id="ptime" />
								</td>
							</tr>
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
