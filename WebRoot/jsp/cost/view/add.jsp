<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<TITLE>费用中心</TITLE>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath }/css/Style.css"
	type=text/css rel=stylesheet>
<LINK href="${pageContext.request.contextPath }/css/Manage.css"
	type=text/css rel=stylesheet>

<script type="text/javascript">
	function check() {
		var ctime = document.getElementById("ctime").value;
		var cgive = document.getElementById("cgive").value;
		var cmonth = document.getElementById("cmonth").value;
		var cname = document.getElementById("cname").value;
		var cdname = document.getElementById("cdname").value;
		var cpnumber = document.getElementById("cpnumber").value;
		var cbank = document.getElementById("cbank").value;
		var cfood = document.getElementById("cfood").value;
		var cfes = document.getElementById("cfes").value;
		var chouse = document.getElementById("chouse").value;
		var cwaelc = document.getElementById("cwaelc").value;
		var cdorm = document.getElementById("cdorm").value;
		var crecruit = document.getElementById("crecruit").value;
		var ctrain = document.getElementById("ctrain").value;
		var crepair1 = document.getElementById("crepair1").value;
		var cdec = document.getElementById("cdec").value;
		var ctravel = document.getElementById("ctravel").value;
		var cbuy = document.getElementById("cbuy").value;
		var cprint = document.getElementById("cprint").value;
		var crent = document.getElementById("crent").value;
		var communic = document.getElementById("communic").value;
		var crepair2 = document.getElementById("crepair2").value;
		var cbuild = document.getElementById("cbuild").value;
		var cserve = document.getElementById("cserve").value;
		var cseek = document.getElementById("cseek").value;
		var cstuff = document.getElementById("cstuff").value;
		var cvise = document.getElementById("cvise").value;
		var cair = document.getElementById("cair").value;
		var cpcar = document.getElementById("cpcar").value;
		var coil = document.getElementById("coil").value;
		var croad = document.getElementById("croad").value;
		var cstwacar = document.getElementById("cstwacar").value;
		var ctraffic = document.getElementById("ctraffic").value;
		var coutwork = document.getElementById("coutwork").value;
		var cstay = document.getElementById("cstay").value;
		var cothers = document.getElementById("cothers").value;
		var ctotal = document.getElementById("ctotal").value;
		var cstime = document.getElementById("cstime").value;
		var cetime = document.getElementById("cetime").value;
		var creason = document.getElementById("creason").value;
		var cremark = document.getElementById("cremark").value;
		if (cname.length == 0 || cdname.length == 0 || cbank.length == 0
				|| cpnumber.length == 0 || creason.length == 0
				|| ctotal.length == 0) {
			alert("请把信息填写完整");
			return false;
		}
		if (cbank.length == 0) {
			cbank = 0;
		}
		if (cfood.length == 0) {
			cfood = 0;
		}
		if (cfes.length == 0) {
			cfes = 0;
		}
		if (chouse.length == 0) {
			chouse = 0;
		}
		if (cwaelc.length == 0) {
			cwaelc = 0;
		}
		if (cdorm.length == 0) {
			cdorm = 0;
		}
		if (crecruit.length == 0) {
			crecruit = 0;
		}
		if (ctrain.length == 0) {
			ctrain = 0;
		}
		if (crepair1.length == 0) {
			crepair1 = 0;
		}
		if (cdec.length == 0) {
			cdec = 0;
		}
		if (ctravel.length == 0) {
			ctravel = 0;
		}
		if (cbuy.length == 0) {
			cbuy = 0;
		}
		if (cprint.length == 0) {
			cprint = 0;
		}
		if (crent.length == 0) {
			crent = 0;
		}
		if (communic.length == 0) {
			communic = 0;
		}
		if (crepair2.length == 0) {
			crepair2 = 0;
		}
		if (cbuild.length == 0) {
			cbuild = 0;
		}
		if (cserve.length == 0) {
			cserve = 0;
		}
		if (cseek.length == 0) {
			cseek = 0;
		}
		if (cstuff.length == 0) {
			cstuff = 0;
		}
		if (cvise.length == 0) {
			cvise = 0;
		}
		if (cair.length == 0) {
			cair = 0;
		}
		if (cpcar.length == 0) {
			cpcar = 0;
		}
		if (coil.length == 0) {
			coil = 0;
		}
		if (croad.length == 0) {
			croad = 0;
		}
		if (cstwacar.length == 0) {
			cstwacar = 0;
		}
		if (ctraffic.length == 0) {
			ctraffic = 0;
		}
		if (coutwork.length == 0) {
			coutwork = 0;
		}
		if (cstay.length == 0) {
			cstay = 0;
		}
		if (cothers.length == 0) {
			cothers = 0;
		}
		if (cpnumber.length == 0) {
			cpnumber = 0;
		}
		var patrn = /^[0-9]+$/;
		if (!patrn.test(cfood) || !patrn.test(cbank) || !patrn.test(cfes)
				|| !patrn.test(chouse) || !patrn.test(cwaelc)
				|| !patrn.test(cdorm) || !patrn.test(crecruit)
				|| !patrn.test(ctrain) || !patrn.test(crepair1)
				|| !patrn.test(cdec) || !patrn.test(ctravel)
				|| !patrn.test(cbuy) || !patrn.test(cprint)
				|| !patrn.test(crent) || !patrn.test(communic)
				|| !patrn.test(crepair2) || !patrn.test(cbuild)
				|| !patrn.test(cserve) || !patrn.test(cseek)
				|| !patrn.test(cstuff) || !patrn.test(cvise)
				|| !patrn.test(cair) || !patrn.test(cpcar) || !patrn.test(coil)
				|| !patrn.test(croad) || !patrn.test(cstwacar)
				|| !patrn.test(ctraffic) || !patrn.test(coutwork)
				|| !patrn.test(cstay) || !patrn.test(cothers)
				|| !patrn.test(cpnumber) || !patrn.test(ctotal)) {
			alert("费用和身份证以及项目编号只能是数字");
			return false;
		}
		window.location.href = "/ProManaPlatForm/cost_add.action?ctime="
				+ ctime + "&cgive=" + cgive + "&cmonth=" + cmonth + "&cname="
				+ cname + "&cdname=" + cdname + "&cpnumber=" + cpnumber
				+ "&cbank=" + cbank + "&cfood=" + cfood + "&cfes=" + cfes
				+ "&chouse=" + chouse + "&cwaelc=" + cwaelc + "&cdorm=" + cdorm
				+ "&crecruit=" + crecruit + "&ctrain=" + ctrain + "&crepair1="
				+ crepair1 + "&cdec=" + cdec + "&ctravel=" + ctravel + "&cbuy="
				+ cbuy + "&cprint=" + cprint + "&crent=" + crent + "&communic="
				+ communic + "&crepair2=" + crepair2 + "&cbuild=" + cbuild
				+ "&cserve=" + cserve + "&cseek=" + cseek + "&cstuff=" + cstuff
				+ "&cvise=" + cvise + "&cair=" + cair + "&cpcar=" + cpcar
				+ "&coil=" + coil + "&croad=" + croad + "&cstwacar=" + cstwacar
				+ "&ctraffic=" + ctraffic + "&coutwork=" + coutwork + "&cstay="
				+ cstay + "&cothers=" + cothers + "&ctotal=" + ctotal
				+ "&cstime=" + cstime + "&cetime=" + cetime + "&creason="
				+ creason + "&cremark=" + cremark;
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
								<TD class=manageHead>当前位置：费用中心 &gt; 添加信息</TD>
							</TR>
							<TR>
								<TD height=2></TD>
							</TR>
						</TABLE>

						<TABLE cellSpacing=0 cellPadding=5 border=0>
							<TR>
								<td>*报销日期：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=50
									name="ctime" id="ctime" type="date" />
								</td>
								<td>谁给的：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=50
									name="cgive" id="cgive" />
								</td>
								<td>月份：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=100
									name="cmonth" id="cmonth" />
								</td>
								</td>
								<td>*报销人：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=50
									name="cname" id="cname" />
								</td>
							</TR>
							<tr>
								<td>*报销单位：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=50
									name="cdname" id="cdname" />
								</td>
								<td>*项目编号：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=50
									name="cpnumber" id="cpnumber" />
								</td>
								<td>*银行卡号：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=100
									name="cbank" id="cbank" />
								</td>
								</td>
								<td>餐费：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=50
									name="cfood" id="cfood" />
								</td>
							</tr>
							<tr>
								<td>过节费：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=50
									name="cfes" id="cfes" />
								</td>
								<td>厂房租金：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=100
									name="chouse" id="chouse" />
								</td>
								</td>
								<td>水电费：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=100
									name="cwaelc" id="cwaelc" />
								</td>
								<td>外租宿舍费：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=100
									name="cdorm" id="cdorm" />
								</td>
								</td>
							</tr>
							<tr>
								<td>招聘：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=50
									name="crecruit" id="crecruit" />
								</td>
								<td>培训：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=100
									name="ctrain" id="ctrain" />
								</td>
								<td>维修费（人事）：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=100
									name="crepair1" id="crepair1" />
								</td>
								<td>报关费：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=100
									name="cdec" id="cdec" />
								</td>
							</tr>
							<tr>
								<td>运输费：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=50
									name="ctravel" id="ctravel" />
								</td>
								<td>其他采购费：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=100
									name="cbuy" id="cbuy" />
								</td>
								<td>打印机：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=100
									name="cprint" id="cprint" />
								</td>
								<td>租赁电脑：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=100
									name="crent" id="crent" />
								</td>
							</tr>
							<tr>
								<td>通信费：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=50
									name="communic" id="communic" />
								</td>
								<td>维修费（办公）：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=100
									name="crepair2" id="crepair2" />
								</td>
								<td>团建费：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=100
									name="cbuild" id="cbuild" />
								</td>
								<td>业务招待费：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=100
									name="cserve" id="cserve" />
								</td>
							</tr>
							<tr>
								<td>顾问咨询费：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=50
									name="cseek" id="cseek" />
								</td>
								<td>材料费：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=100
									name="cstuff" id="cstuff" />
								</td>
								<td>签证费：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=100
									name="cvise" id="cvise" />
								</td>
								<td>机票费：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=100
									name="cair" id="cair" />
								</td>
							</tr>
							<tr>
								<td>请车费：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=50
									name="cpcar" id="cpcar" />
								</td>
								<td>油费：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=100
									name="coil" id="coil" />
								</td>
								<td>过路费：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=100
									name="croad" id="croad" />
								</td>
								<td>停车洗车费：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=100
									name="cstwacar" id="cstwacar" />
								</td>
							</tr>
							<tr>
								<td>交通费：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=50
									name="ctraffic" id="ctraffic" />
								</td>
								<td>出差补助费：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=100
									name="coutwork" id="coutwork" />
								</td>
								<td>住宿费：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=100
									name="cstay" id="cstay" />
								</td>
								<td>其他费用：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=100
									name="cothers" id="cothers" />
								</td>
							</tr>
							<tr>
								<td>*合计：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=50
									name="ctotal" id="ctotal" />
								</td>
								<td>*开始日期：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=100
									name="cstime" id="cstime" type="date" />
								</td>
								<td>*结束日期：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=100
									name="cetime" id="cetime" type="date" />
								</td>
								<td>*报销事由：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=100
									name="creason" id="creason" />
								</td>
							</tr>
							<tr>
								<td>备注：</td>
								<td><INPUT class=textbox style="WIDTH: 180px" maxLength=50
									name="cremark" id="cremark" />
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
