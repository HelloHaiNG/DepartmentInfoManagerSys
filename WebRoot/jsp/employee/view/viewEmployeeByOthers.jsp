
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<TITLE>通讯录</TITLE>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath }/css/Style.css"
	type=text/css rel=stylesheet>
<LINK href="${pageContext.request.contextPath }/css/Manage.css"
	type=text/css rel=stylesheet>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-1.4.4.min.js"></script>

<script type="text/javascript">
	function check() {
		var xmlhttp;
		if (window.XMLHttpRequest) {
			//  IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
			xmlhttp = new XMLHttpRequest();
		} else {
			// IE6, IE5 浏览器执行代码
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		var input = document.getElementsByTagName("input");
		for ( var int = 0; int < input.length - 2; int++) {
			if (input[int].checked) {
				xmlhttp.onreadystatechange = function() {
					if (xmlhttp.readyState == 4) {
						if (xmlhttp.status == 200) {
						}
					}
				}
				xmlhttp.open("post", "report_addEmployee.action?timeStamp="
						+ new Date().getTime(), true);
				xmlhttp.setRequestHeader("Content-type",
						"application/x-www-form-urlencoded");
				xmlhttp.send("enumber=" + input[int].value);
			} else {
				xmlhttp.onreadystatechange = function() {
					if (xmlhttp.readyState == 4) {
						if (xmlhttp.status == 200) {
						}
					}
				}
				xmlhttp.open("post", "report_removeEmployee.action?timeStamp="
						+ new Date().getTime(), true);
				xmlhttp.setRequestHeader("Content-type",
						"application/x-www-form-urlencoded");
				xmlhttp.send("enumber=" + input[int].value);
			}
		}
	}
</script>
<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
</HEAD>
<BODY>
	<FORM id="customerForm" name="customerForm"
		action="${pageContext.request.contextPath }/report_reportEmployeeExcel.action"
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
								<TD class=manageHead>当前位置：通讯录 &gt; 通讯录列表</TD>
							</TR>
							<TR>
								<TD height=2></TD>
							</TR>
						</TABLE>
						<TABLE borderColor=#cccccc cellSpacing=0 cellPadding=0
							width="100%" align=center border=0>
							<TBODY>
								<TR>
									<TD>
										<TABLE id=grid
											style="BORDER-TOP-WIDTH: 0px; FONT-WEIGHT: normal; BORDER-LEFT-WIDTH: 0px; BORDER-LEFT-COLOR: #cccccc; BORDER-BOTTOM-WIDTH: 0px; BORDER-BOTTOM-COLOR: #cccccc; WIDTH: 100%; BORDER-TOP-COLOR: #cccccc; FONT-STYLE: normal; BACKGROUND-COLOR: #cccccc; BORDER-RIGHT-WIDTH: 0px; TEXT-DECORATION: none; BORDER-RIGHT-COLOR: #cccccc"
											cellSpacing=1 cellPadding=2 rules=all border=0>
											<TBODY>
												<TR
													style="FONT-WEIGHT: bold; FONT-STYLE: normal; BACKGROUND-COLOR: #eeeeee; TEXT-DECORATION: none">
													<TD>工号</TD>
													<TD>姓名</TD>
													<TD>电话1</TD>
													<TD>电话2</TD>
													<TD>邮箱</TD>
													<TD>查看</TD>
												</TR>
												<c:forEach items="${pageBean.listEmployees }" var="employee">
													<TR
														style="FONT-WEIGHT: normal; FONT-STYLE: normal; BACKGROUND-COLOR: white; TEXT-DECORATION: none">
														<TD>${employee.enumber }</TD>
														<TD>${employee.ename }</TD>
														<TD>${employee.ephone1 }</TD>
														<TD>${employee.ephone2 }</TD>
														<TD>${employee.email }</TD>
														<TD><A
															href="${pageContext.request.contextPath }/employee_viewByEnumberByOthers.action?enumber=${employee.enumber }">查看</A>
															
														</TD>
													</TR>
												</c:forEach>
											</TBODY>
										</TABLE></TD>
								</TR>
								<TR>
									<TD><SPAN id=pagelink>
											<DIV
												style="LINE-HEIGHT: 20px; HEIGHT: 20px; TEXT-ALIGN: right">
												<c:if test="${0!=pageBean.totalPage}">
												共[<B>${pageBean.totalCount}</B>]条记录,[<B>${pageBean.totalPage}</B>]页
												,当前第[<b>${pageBean.currentPage}</b>]页
												<c:if test="${pageBean.currentPage!=1}">
												  [<A
														href="${pageContext.request.contextPath }/employee_listByOthers.action?currentPage=${pageBean.currentPage-1 }">前一页</A>]
												</c:if>
												<c:if test="${pageBean.currentPage!=pageBean.totalPage}">
												  [<A
														href="${pageContext.request.contextPath }employee_listByOthers.action?currentPage=${pageBean.currentPage+1 }">后一页</A>]
												</c:if>
												</c:if>
												<input type="hidden" size="3" id="page" name="page" />

											</DIV> </SPAN>
									</TD>
								</TR>
								</TBODY>
						</TABLE></TD>
					<TD width=15
						background="${pageContext.request.contextPath }/images/new_023.jpg"><IMG
						src="${pageContext.request.contextPath }/images/new_023.jpg"
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
