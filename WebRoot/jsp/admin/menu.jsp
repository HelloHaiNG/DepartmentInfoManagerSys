<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<HTML xmlns="http://www.w3.org/1999/xhtml">
<HEAD id=Head1>
<TITLE>导航</TITLE>
<META http-equiv=Content-Type content="text/html; charset=utf-8">
<STYLE type=text/css>
BODY {
	PADDING-RIGHT: 0px;
	PADDING-LEFT: 0px;
	PADDING-BOTTOM: 0px;
	MARGIN: 0px;
	PADDING-TOP: 0px;
	BACKGROUND-COLOR: #2a8dc8
}

BODY {
	FONT-SIZE: 11px;
	COLOR: #003366;
	FONT-FAMILY: Verdana
}

TD {
	FONT-SIZE: 11px;
	COLOR: #003366;
	FONT-FAMILY: Verdana
}

DIV {
	FONT-SIZE: 11px;
	COLOR: #003366;
	FONT-FAMILY: Verdana
}

P {
	FONT-SIZE: 11px;
	COLOR: #003366;
	FONT-FAMILY: Verdana
}

.mainMenu {
	FONT-WEIGHT: bold;
	FONT-SIZE: 14px;
	cursor: pointer;
	COLOR: #000000
}

A.style2:link {
	PADDING-LEFT: 4px;
	COLOR: #0055bb;
	TEXT-DECORATION: none
}

A.style2:visited {
	PADDING-LEFT: 4px;
	COLOR: #0055bb;
	TEXT-DECORATION: none
}

A.style2:hover {
	PADDING-LEFT: 4px;
	COLOR: #ff0000;
	TEXT-DECORATION: none
}

A.active {
	PADDING-LEFT: 4px;
	COLOR: #ff0000;
	TEXT-DECORATION: none
}

.span {
	COLOR: #ff0000;
}
</STYLE>

<SCRIPT language=javascript>
	function MenuDisplay(obj_id) {
		for ( var i = 1; i <= 9; i++) {
			var obj = document.getElementById('table_' + i);
			if (obj) {
				document.getElementById('table_' + i).style.display = 'none';
				document.getElementById('table_' + i + 'Span').innerText = '＋';
			}

		}
		var obj = document.getElementById(obj_id);
		if (obj) {
			if (obj.style.display == 'none') {
				obj.style.display = 'block';
				document.getElementById(obj_id + 'Span').innerText = '－';
			} else {
				obj.style.display = 'none';
				document.getElementById(obj_id + 'Span').innerText = '＋';
			}
		}

	}
</SCRIPT>

<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
</HEAD>
<BODY>
	<FORM id=form1 name=form1 action=YHMenu.aspx method=post>
		<TABLE cellSpacing=0 cellPadding=0 width=210 align=center border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG src="/ProManaPlatForm/images/new_005.jpg"
						border=0>
					</TD>
					<TD align=middle width=180
						background=/ProManaPlatForm/images/new_006.jpg height=35><B>项目信息管理系统
							－功能菜单</B>
					</TD>
					<TD width=15><IMG src="/ProManaPlatForm/images/new_007.jpg"
						border=0>
					</TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width=210 align=center border=0>
			<TBODY>
				<TR>
					<TD width=15 background=/ProManaPlatForm/images/new_008.jpg></TD>
					<TD vAlign=top width=180 bgColor=#ffffff>
						<TABLE cellSpacing=0 cellPadding=3 width=165 align=center border=0>
							<TBODY>
								<TR>
									<TD background=/ProManaPlatForm/images/new_027.jpg height=1></TD>
								</TR>
								<TR>
									<TD class=mainMenu onClick="MenuDisplay('table_1');"><SPAN
										class=span id=table_1Span>＋</SPAN>个人中心</TD>
								</TR>
								<TR>
									<TD>
										<TABLE id=table_1 style="DISPLAY: none" cellSpacing=0
											cellPadding=2 width=155 align=center border=0>
											<TBODY>
												<TR>
													<TD class=menuSmall><A class=style2
														href="${pageContext.request.contextPath }/user_selfInfo.action"
														target=main>－个人信息</A>
													</TD>
												</TR>
												<TR>
													<TD class=menuSmall><A class=style2
														href="${pageContext.request.contextPath }/user_toUpdateInfoPage.action"
														target=main>－修改个人信息</A>
													</TD>
												</TR>
												<%-- <TR>
													<TD class=menuSmall><A class=style2
														href="${pageContext.request.contextPath }/user_exit.action"
														target=main>－退出登陆</A>
													</TD>
												</TR> --%>
											</TBODY>
										</TABLE></TD>
								</TR>
								<TR>
									<TD background=/ProManaPlatForm/images/new_027.jpg height=1></TD>
								</TR>
								<TR>
									<TD class=mainMenu onClick="MenuDisplay('table_2');"><SPAN
										class=span id=table_2Span>＋</SPAN>项目信息</TD>
								</TR>
								<TR>
									<TD>
										<TABLE id=table_2 style="DISPLAY: none" cellSpacing=0
											cellPadding=2 width=155 align=center border=0>
											<TBODY>
												<TR>
													<TD class=menuSmall><A class=style2
														href="${pageContext.request.contextPath }/project_list.action?currentPage=1"
														target=main>－ 项目列表</A>
													</TD>
												</TR>
												<TR>
													<TD class=menuSmall><A class=style2
														href="${pageContext.request.contextPath }/report_projectList.action"
														target=main>－导出报表</A>
													</TD>
												</TR>
											</TBODY>
										</TABLE></TD>
								</TR>
								<TR>
									<TD background=/ProManaPlatForm/images/new_027.jpg height=1></TD>
								</TR>
								<TR>
									<TD class=mainMenu onClick="MenuDisplay('table_3');"><SPAN
										class=span id=table_3Span>＋</SPAN>通讯录</TD>
								</TR>
								<TR>
									<TD>
										<TABLE id=table_3 style="DISPLAY: none" cellSpacing=0
											cellPadding=2 width=155 align=center border=0>
											<TBODY>
												<TR>
													<TD class=menuSmall><A class=style2
														href="${pageContext.request.contextPath }/employee_list.action?currentPage=1"
														target=main>－ 在职通讯录</A></TD>
												</TR>
												<TR>
													<TD class=menuSmall><A class=style2
														href="${pageContext.request.contextPath }/employeeDelete_list.action?currentPage=1"
														target=main>－ 离职通讯录</A></TD>
												</TR>
											</TBODY>
										</TABLE>
									</TD>
								</TR>
								<TR>
									<TD background=/ProManaPlatForm/images/new_027.jpg height=1></TD>
								</TR>
								<TR>
									<TD class=mainMenu onClick="MenuDisplay('table_4');"><SPAN
										class=span id=table_4Span>＋</SPAN>支援中心</TD>
								</TR>
								<TR>
									<TD>
										<TABLE id=table_4 style="DISPLAY: none" cellSpacing=0
											cellPadding=2 width=155 align=center border=0>
											<TBODY>
												<TR>
													<TD class=menuSmall><A class=style2
														href="${pageContext.request.contextPath }/support_list.action?currentPage=1"
														target=main>－支援列表</A>
													</TD>
												</TR>
												<TR>
													<TD class=menuSmall><A class=style2
														href="${pageContext.request.contextPath }/report_listSupportExcel.action"
														target=main>－导出列表</A></TD>
												</TR>
											</TBODY>
										</TABLE>
									</TD>
								</TR>
								<TR>
									<TD background=/ProManaPlatForm/images/new_027.jpg height=1></TD>
								</TR>
								<TR>
									<TD class=mainMenu onClick="MenuDisplay('table_5');"><SPAN
										class=span id=table_5Span>＋</SPAN>费用中心</TD>
								</TR>
								<TR>
									<TD>
										<TABLE id=table_5 style="DISPLAY: none" cellSpacing=0
											cellPadding=2 width=155 align=center border=0>
											<TBODY>
												<TR>
													<TD class=menuSmall><A class=style2
														href="${pageContext.request.contextPath }/cost_list.action?currentPage=1"
														target=main>－费用列表</A>
													</TD>
												</TR>
												<TR>
													<TD class=menuSmall><A class=style2
														href="${pageContext.request.contextPath }/report_listCostExcel.action"
														target=main>－导出报表</A>
													</TD>
												</TR>
											</TBODY>
										</TABLE>
									</TD>
								</TR>
								<TR>
									<TD background=/ProManaPlatForm/images/new_027.jpg height=1></TD>
								</TR>
								<TR>
									<TD class=mainMenu onClick="MenuDisplay('table_6');"><SPAN
										class=span id=table_6Span>＋</SPAN>工业中心</TD>
								</TR>
								<TR>
									<TD>
										<TABLE id=table_6 style="DISPLAY: none" cellSpacing=0
											cellPadding=2 width=155 align=center border=0>
											<TBODY>
												<TR>
													<TD class=menuSmall><A class=style2
														href="${pageContext.request.contextPath }/industry_list.action?currentPage=1"
														target=main>－ 工业列表</A></TD>
												</TR>
												<TR>
													<TD class=menuSmall><A class=style2
														href="${pageContext.request.contextPath }/report_listExcel.action"
														target=main>－ 导出报表</A></TD>
												</TR>
											</TBODY>
										</TABLE></TD>
								</TR>
								<TR>
									<TD background=/ProManaPlatForm/images/new_027.jpg height=1></TD>
								</TR>
								<TR>
									<TD class=mainMenu onClick="MenuDisplay('table_7');"><SPAN
										class=span id=table_7Span>＋</SPAN>设备中心</TD>
								</TR>
								<TR>
									<TD>
										<TABLE id=table_7 style="DISPLAY: none" cellSpacing=0
											cellPadding=2 width=155 align=center border=0>
											<TBODY>
												<TR>
													<TD class=menuSmall><A class=style2
														href="${pageContext.request.contextPath }/device_list.action?currentPage=1"
														target=main>－ 设备列表</A>
													</TD>
												</TR>
												<TR>
													<TD class=menuSmall><A class=style2
														href="${pageContext.request.contextPath }/report_listDeviceExcel.action"
														target=main>－ 导出报表</A>
													</TD>
												</TR>
											</TBODY>
										</TABLE></TD>
								</TR>
								<TR>
									<TD background=/ProManaPlatForm/images/new_027.jpg height=1></TD>
								</TR>
								<TR>
									<TD class=mainMenu onClick="MenuDisplay('table_8');"><SPAN
										class=span id=table_8Span>＋</SPAN>管理员中心</TD>
								</TR>
								<TR>
									<TD>
										<TABLE id=table_8 style="DISPLAY: none" cellSpacing=0
											cellPadding=2 width=155 align=center border=0>
											<TBODY>
												<TR>
													<TD class=menuSmall><A class=style2
														href="${pageContext.request.contextPath }/user_toAddPage.action"
														target=main>－ 添加管理员</A>
													</TD>
												</TR>
												<TR>
													<TD class=menuSmall><A class=style2
														href="${pageContext.request.contextPath }/user_list.action"
														target=main>－ 管理员列表</A>
													</TD>
												</TR>
												<TR>
													<TD class=menuSmall><A class=style2
														href="${pageContext.request.contextPath }/user_delete.action"
														target=main>－ 一键删除</A>
													</TD>
												</TR>
											</TBODY>
										</TABLE></TD>
								</TR>
								<TR>
									<TD background=/ProManaPlatForm/images/new_027.jpg height=1></TD>
								</TR>
								<TR>
									<TD class=mainMenu onClick="MenuDisplay('table_9');"><SPAN
										class=span id=table_9Span>＋</SPAN>公告中心</TD>
								</TR>
								<TR>
									<TD>
										<TABLE id=table_9 style="DISPLAY: none" cellSpacing=0
											cellPadding=2 width=155 align=center border=0>
											<TBODY>
												<TR>
													<TD class=menuSmall><A class=style2
														href="${pageContext.request.contextPath }/notice_toAddPage.action"
														target=main>－ 添加公告</A>
													</TD>
												</TR>
												<TR>
													<TD class=menuSmall><A class=style2
														href="${pageContext.request.contextPath }/notice_all.action?currentPage=1"
														target=main>－ 公告列表</A>
													</TD>
												</TR>
												<TR>
													<TD class=menuSmall><A class=style2
														href="${pageContext.request.contextPath }/notice_delete.action"
														target=main>－ 一键删除</A>
													</TD>
												</TR>
											</TBODY>
										</TABLE></TD>
								</TR>
							</TBODY>
						</TABLE>
						<TABLE cellSpacing=0 cellPadding=0 width=210 align=center border=0>
							<TBODY>
								<TR>
									<TD width=15><IMG
										src="/ProManaPlatForm/images/new_010.jpg" border=0>
									</TD>
									<TD align=middle width=180 background=images/new_011.jpg
										height=15></TD>
									<TD width=15><IMG
										src="/ProManaPlatForm/images/new_012.jpg" border=0>
									</TD>
								</TR>
							</TBODY>
						</TABLE>
	</FORM>
</BODY>
</HTML>
