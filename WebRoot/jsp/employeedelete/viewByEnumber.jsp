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
<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
</HEAD>
<BODY>
	<FORM id=form1 name=form1 action="" method=post>
         <input type="hidden" name="edpwd" id="edpwd" value="${employeeDelete.edpwd }"/>
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
								<TD class=manageHead>当前位置：离职通讯录 &gt; 通讯录列表</TD>
							</TR>
							<TR>
								<TD height=2></TD>
							</TR>
						</TABLE>

						<TABLE cellSpacing=0 cellPadding=5 border=0>
							<TR>
								<td>工号：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=50
									name="ednumber" id="ednumber" readonly="readonly"
									value="${employeeDelete.ednumber }" />
								</td>
								<td>姓名：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=50
									name="edname" id="edname" value="${employeeDelete.edname }" />
								</td>
								<td>性别：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=50
									name="edsex" id="edsex"
									value="${employeeDelete.edsex }" />
								</td>
								<td>职位：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=50
									name="edposition" id="edposition" value="${employeeDelete.edposition }" />
								</td>
							</TR>
							<tr>
								<td>电话1：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=50
									name="edphone1" id="edphone1" 
									value="${employeeDelete.edphone1 }" />
								</td>
								<td>电话2：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=50
									name="edphone2" id="edphone2" value="${employeeDelete.edphone2 }" />
								</td>
								<td>组别：</td>
								<td>
								<INPUT class=textbox style="WIDTH: 180px" maxLength=50
									name="gname" id="gname" value="${employeeDelete.group.gname }" />
								</td>
								<td>管培生：</td>
								<td>
								<INPUT class=textbox style="WIDTH: 180px" maxLength=50
									name="edmana" id="edmana" value="${employeeDelete.edmana }" />
								</td>
							</tr>
							<tr>
								<td>办公地点：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=50
									name="edworkplace" id="edworkplace" value="${employeeDelete.edworkplace }" />
								</td>
								<td>备注：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=100
									name="edremark" id="edremark" value="${employeeDelete.edremark }" />
								</td>
								<td>邮箱：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=100
									name="edmail" id="edmail" 
									value="${employeeDelete.edmail }" />
								</td>
								<td>入职日期：</td>
								<td><INPUT type="date" style="WIDTH: 180px" maxLength=100
									name="edmail" id="edmail" 
									value="${employeeDelete.eddate }" />
								</td>
							</tr>
							<tr>
								<td>院校：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=50
									name="edschool" id="edschool" value="${employeeDelete.edschool }" />
								</td>
								<td>学历：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=100
									name="edduc" id="edduc"  value="${employeeDelete.edduc }"/>
								</td>
								<td>*身份证：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=100
									name="edids" id="edids" value="${employeeDelete.edids }" />
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
