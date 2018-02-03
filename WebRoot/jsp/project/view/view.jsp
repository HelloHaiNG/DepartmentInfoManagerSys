<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<TITLE>项目信息</TITLE>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath }/css/Style.css"
	type=text/css rel=stylesheet>
<LINK href="${pageContext.request.contextPath }/css/Manage.css"
	type=text/css rel=stylesheet>

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
								<TD class=manageHead>当前位置：项目信息 &gt; 查看项目信息</TD>
							</TR>
							<TR>
								<TD height=2></TD>
							</TR>
						</TABLE>

						<TABLE cellSpacing=0 cellPadding=5 border=0>
							<TR>
								<td>项目编号：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=50
									name="pnumber" id="pnumber" readonly="readonly"
									value="${project.pnumber }" readonly="readonly" /></td>
								<td>项目名称：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=50
									name="pname" id="pname" value="${project.pname }"
									readonly="readonly" /></td>
								<td>图纸号：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=50
									name="pmapnumber" id="pmapnumber"
									value="${project.pmapnumber }" readonly="readonly" />
								</td>
								<td>项目负责人：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=50
									name="pdutyname" id="pdutyname" value="${project.pdutyname }"
									readonly="readonly" />
								</td>
							</TR>
							<tr>
								<td>项目时间：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=50
									name="ptime" id="ptime" readonly="readonly"
									value=${project.ptime } />
								</td>
								<td>ME：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=50
									name="pME" id="pME" value="${project.pME }" readonly="readonly" />
								</td>
								<td>EE：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=50
									name="pEE" id="pEE" value="${project.pEE }" readonly="readonly" />
								</td>
								<td>SW：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=50
									name="pSW" id="pSW" value="${project.pSW }" readonly="readonly" />
								</td>
							</tr>
							<tr>
								<td>项目状态：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=50
									name="pstatus" id="pstatus" value=${project.pstatus }
									readonly="readonly" /></td>
								<td>备注：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=100
									name="premark" id="premark" value="${project.premark }"
									readonly="readonly" /></td>
								<td>录入人编号：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=100
									name="unumber" id="unumber" readonly="readonly"
									value="${project.user.unumber }" readonly="readonly" /></td>
								<td>成品编码：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=100
									name="pmothercode" id="pmothercode"
									value="${project.pmothercode }" readonly="readonly" />
								</td>
							</tr>
							<tr>
								<td>出货时间：</td>
								<td><INPUT type="date" style="WIDTH: 180px" maxLength=100
									name="pfinishtime" id="pfinishtime"
									value=${project.pfinishtime } readonly="readonly" /></td>
								<td>出货地点：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=100
									name="place" id="place" value="${project.place }"
									readonly="readonly" /></td>
								<td>数量：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=100
									name="pnum" id="pnum" value="${project.pnum }"
									readonly="readonly" /></td>
								<td>PO：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=100
									name="po" id="po" value="${project.po }" readonly="readonly" />
								</td>
							</tr>
							<tr>
								<td>阶段：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=100
									name="period" id="period" value="${project.period }"
									readonly="readonly" /></td>
								<td>APN：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=100
									name="papn" id="papn" value="${project.papn }"
									readonly="readonly" /></td>
								<td>出货SN：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=100
									name=psn id="psn" value="${project.psn }" readonly="readonly" />
								</td>
								<td>铭牌刻字：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=100
									name="pwords" id="pwords" value="${project.pwords }"
									readonly="readonly" /></td>
							</tr>
							<tr>
								<td>产品类别：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=100
									name="producekind" id="producekind"
									value=${project.producekind } readonly="readonly" />
								</td>
								<td>项目内部简称：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=100
									name="pshortname" id="pshortname"
									value="${project.pshortname }" readonly="readonly" /></td>
								<td>PCB料号：</td>
								<td><select name="pcbnumber" id="pcbnumber">
										<c:forEach items="${pcbs }" var="pcbs">
											<option value="${pcbs.pcbnumber }">${pcbs.pcbnumber}</option>
										</c:forEach>
								</select>
								</td>
								<td>PCB名称：</td>
								<td><select name="pcbname" id="pcbname">
										<c:forEach items="${pcbs }" var="pcbs">
											<option value="${pcbs.pcbname }">${pcbs.pcbname}</option>
										</c:forEach>
								</select>
								</td>
							</tr>
							<tr>
								<td>PCB版本：</td>
								<td><select name="pcbversion" id="pcbversion">
										<c:forEach items="${pcbs }" var="pcbs">
											<option value="${pcbs.pcbversion }">${pcbs.pcbversion}</option>
										</c:forEach>
								</select>
								</td>
								<td>PCB备注：</td>
								<td><select name="pcbremark" id="pcbremark">
										<c:forEach items="${pcbs }" var="pcbs">
											<option value="${pcbs.pcbremark }">${pcbs.pcbremark}</option>
										</c:forEach>
								</select>
								</td>
								<td>机械BOM：</td>
								<td><select name="mnumber" id="mnumber">
										<c:forEach items="${machines }" var="machines">
											<option value="${machines.mnumber }">${machines.mnumber}</option>
										</c:forEach>
								</select>
								</td>
								<td>机械版本：</td>
								<td><select name="mversion" id="mversion">
										<c:forEach items="${machines }" var="machines">
											<option value="${machines.mversion }">${machines.mversion}</option>
										</c:forEach>
								</select>
								</td>
							</tr>
							<tr>
								<td>机械备注：</td>
								<td><select name="mremark" id="mremark">
										<c:forEach items="${machines }" var="machines">
											<option value="${machines.mremark }">${machines.mremark}</option>
										</c:forEach>
								</select>
								</td>
								<td>软件编号：</td>
								<td><select name="snumber" id="snumber">
										<c:forEach items="${softs }" var="softs">
											<option value="${softs.snumber }">${softs.snumber}</option>
										</c:forEach>
								</select>
								</td>
								<td>软件版本：</td>
								<td><select name="sversion" id="sversion">
										<c:forEach items="${softs }" var="softs">
											<option value="${softs.sversion }">${softs.sversion}</option>
										</c:forEach>
								</select>
								</td>
								<td>软件备注：</td>
								<td><select name="sremark" id="sremark">
										<c:forEach items="${softs }" var="softs">
											<option value="${softs.sremark }">${softs.sremark}</option>
										</c:forEach>
								</select>
								</td>
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
