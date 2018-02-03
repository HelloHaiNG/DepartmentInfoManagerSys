<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/frameset.dtd">
<HTML xmlns="http://www.w3.org/1999/xhtml">
<HEAD>
<META http-equiv=Content-Type content="text/html; charset=utf-8">
<STYLE type=text/css>
BODY {
	FONT-SIZE: 12px;
	COLOR: #ffffff;
	FONT-FAMILY: 宋体
}

TD {
	FONT-SIZE: 12px;
	COLOR: #ffffff;
	FONT-FAMILY: 宋体
}
</STYLE>
<script type="text/javascript">
	function check() {
	    var unumber = document.getElementById("unumber").value;
		var upwd = document.getElementById("upwd").value;
		var role = document.getElementById("role").value;
		var unumberlength = unumber.length;
		var upwdlength = upwd.length;		
		if (unumberlength == 0) {
			unumberSpan.innerHTML = "用户名不能为空";
			document.getElementById("unumber").focus;
			return false;
		}
		if (upwdlength == 0) {
			upwdSpan.innerHTML = "密码不能为空";
			document.getElementById("upwd").focus;
			return false;
		}
		window.location.href = "/ProManaPlatForm/user_login.action?unumber="
				+ unumber + "&upwd=" + upwd + "&role=" + role;
	}
</script>
<META content="MSHTML 6.00.6000.16809" name=GENERATOR>
</HEAD>
<BODY>
	<FORM id=form1 name=form1 action="" method="post">

		<DIV id=UpdatePanel1>
			<DIV id=div1
				style="LEFT: 0px; POSITION: absolute; TOP: 0px; BACKGROUND-COLOR: #0066ff"></DIV>
			<DIV id=div2
				style="LEFT: 0px; POSITION: absolute; TOP: 0px; BACKGROUND-COLOR: #0066ff"></DIV>


			<DIV>&nbsp;&nbsp;</DIV>
			<DIV>
				<TABLE cellSpacing=0 cellPadding=0 width=900 align=center border=0>
					<TBODY>
						<TR>
							<TD style="HEIGHT: 105px"><IMG src="images/login_1.gif"
								border=0></TD>
						</TR>
						<TR>
							<TD background=images/login_2.jpg height=300>
								<TABLE height=300 cellPadding=0 width=900 border=0>
									<TBODY>
										<!-- <TR>
											<TD colSpan=2 height=35></TD>
										</TR> -->
										<TR>
											<TD width=360></TD>
											<TD>
												<TABLE cellSpacing=0 cellPadding=2 border=0>
													<TBODY>
														<TR>
															<TD style="HEIGHT: 28px" width=80>工号：</TD>
															<TD style="HEIGHT: 28px" width=150><INPUT
																id="unumber" style="WIDTH: 130px" name="unumber">
															</TD>
															<TD style="HEIGHT: 28px" width=370><font color="red">
															<font color="red"><span id="unumberSpan"></span> </font></TD>
														</TR>
														<TR>
															<TD style="HEIGHT: 28px">密码：</TD>
															<TD style="HEIGHT: 28px"><INPUT id="upwd" style="WIDTH: 130px" type=password name="upwd"></TD>															
															<TD style="HEIGHT: 28px"><font color="red"><span id="upwdSpan"></span> </font></TD>
														</TR>
														<TR>
															<TD style="HEIGHT: 28px">级别：</TD><td>
															<select name="role" id="role">
                                                                 <option selected="selected" value="管理员" >管理员</option>
                                                                 <option value="员工">员工</option>                                                           
                                                            </select> </td>
														</TR>
														<TR>
															<TD style="HEIGHT: 18px"></TD>
															<TD style="HEIGHT: 18px"></TD>
															<TD style="HEIGHT: 18px"></TD>
														</TR>
														<TR>
															<TD></TD>
															<TD><INPUT id=btn style="BORDER-TOP-WIDTH: 0px; BORDER-LEFT-WIDTH: 0px; BORDER-BOTTOM-WIDTH: 0px; BORDER-RIGHT-WIDTH: 0px" type=button value= "登陆" name=btn
																onClick="check()">
															</TD>
															<TD><INPUT id=btn style="BORDER-TOP-WIDTH: 0px; BORDER-LEFT-WIDTH: 0px; BORDER-BOTTOM-WIDTH: 0px; BORDER-RIGHT-WIDTH: 0px" type=reset value= "重置" name=btn>
															</TD>
														</TR>
													</TBODY>
												</TABLE></TD>
										</TR>
									</TBODY>
								</TABLE></TD>
						</TR>
						<TR>
							<TD><IMG src="images/login_3.jpg" border=0></TD>
						</TR>
					</TBODY>
				</TABLE>
			</DIV>
		</DIV>


	</FORM>
</BODY>
</HTML>
