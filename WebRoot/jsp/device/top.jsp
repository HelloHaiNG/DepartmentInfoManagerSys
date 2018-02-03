<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<HTML xmlns="http://www.w3.org/1999/xhtml">
<HEAD id=Head1>
<TITLE>顶部</TITLE>
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
	FONT-SIZE: 12px;
	COLOR: #003366;
	FONT-FAMILY: Verdana, Arial, Helvetica, sans-serif
}

TD {
	FONT-SIZE: 12px;
	COLOR: #003366;
	FONT-FAMILY: Verdana, Arial, Helvetica, sans-serif
}

DIV {
	FONT-SIZE: 12px;
	COLOR: #003366;
	FONT-FAMILY: Verdana, Arial, Helvetica, sans-serif
}

P {
	FONT-SIZE: 12px;
	COLOR: #003366;
	FONT-FAMILY: Verdana, Arial, Helvetica, sans-serif
}

a:link,a:visited{
 text-decoration:none;  /*超链接无下划线*/
}
a:hover{
 text-decoration:underline;  /*鼠标放上去有下划线*/
}
</STYLE>
<script type="text/javascript">
	window.onload = function() {
		setInterval("listNotice()", 5000);
	}
	function listNotice() {
		var xmlhttp;
		if (window.XMLHttpRequest) {
			xmlhttp = new XMLHttpRequest();
		} else {
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4) {
				if (xmlhttp.status == 200) {
					ncontent.innerHTML = xmlhttp.responseText;
				}
			}
		}
		xmlhttp.open("post", "notice_onTime.action?timeStamp="
				+ new Date().getTime(), true);
		xmlhttp.setRequestHeader("Content-type",
				"application/x-www-form-urlencoded");
		xmlhttp.send(null);
	}
</script>
<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
</HEAD>
<BODY>
	<FORM id=form1 name=form1 action="" method=post>
		<marquee onMouseOut="this.start()" onMouseOver="this.stop()">
			<font color="black" size="3"><span id="ncontent"></span></font>
		</marquee>
		<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
			<TBODY>
				<TR>
					<TD width=10><IMG src="/ProManaPlatForm/images/new_001.jpg"
						border=0>
					</TD>
					<TD background=/ProManaPlatForm/images/new_002.jpg><FONT
						size=5><B>项目信息管理系统</B>
					</FONT>
					</TD>
					<TD background=/ProManaPlatForm/images/new_002.jpg>
						<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
							<TBODY>
								<TR>
									<TD height=35 align="right">当前用户：${unumber }
										${user.username } <a href="../../login.jsp" target="_top">退出</a>&nbsp;&nbsp;&nbsp;&nbsp;</TD>
								</TR>
							</TBODY>
						</TABLE></TD>
					<TD width=10><IMG src="/ProManaPlatForm/images/new_003.jpg"
						border=0>
					</TD>
				</TR>
			</TBODY>
		</TABLE>
	</FORM>
</BODY>
</HTML>
