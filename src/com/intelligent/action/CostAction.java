package com.intelligent.action;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.intelligent.pojo.Cost;
import com.intelligent.pojo.PageBean;
import com.intelligent.service.CostService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("all")
public class CostAction extends ActionSupport implements ModelDriven<Cost>{
	private Cost cost = new Cost();
	private CostService costService;
	private Integer currentPage;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");// 设置日期格式

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public void setCostService(CostService costService) {
		this.costService = costService;
	}

	@Override
	public Cost getModel() {
		return cost;
	}
	
	public String toAddPage() {
		return "toAddPage";
	}
	
	public String add() {
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			String ctime = request.getParameter("ctime");
			String cgive = request.getParameter("cgive");
			cgive = new String(cgive.getBytes("ISO-8859-1"), "utf-8");
			String cmonth = request.getParameter("cmonth");
			cmonth = new String(cmonth.getBytes("ISO-8859-1"), "utf-8");
			String cname = request.getParameter("cname");
			cname = new String(cname.getBytes("ISO-8859-1"), "utf-8");
			String cdname = request.getParameter("cdname");
			cdname = new String(cdname.getBytes("ISO-8859-1"), "utf-8");
			String cpnumber = request.getParameter("cpnumber");
			cpnumber = new String(cpnumber.getBytes("ISO-8859-1"), "utf-8");
			String cbank = request.getParameter("cbank");
			cbank = new String(cbank.getBytes("ISO-8859-1"), "utf-8");
			String cfood = request.getParameter("cfood");
			String cfes = request.getParameter("cfes");
			String chouse = request.getParameter("chouse");
			String cwaelc = request.getParameter("cwaelc");
			String cdorm = request.getParameter("cdorm");
			String crecruit = request.getParameter("crecruit");
			String ctrain = request.getParameter("ctrain");
			String crepair1 = request.getParameter("crepair1");
			String cdec = request.getParameter("cdec");
			String ctravel = request.getParameter("ctravel");
			String cbuy = request.getParameter("cbuy");
			String cprint = request.getParameter("cprint");
			String crent = request.getParameter("crent");
			String communic = request.getParameter("communic");
			String crepair2 = request.getParameter("crepair2");
			String cbuild = request.getParameter("cbuild");
			String cserve = request.getParameter("cserve");
			String cseek = request.getParameter("cseek");
			String cstuff = request.getParameter("cstuff");
			String cvise = request.getParameter("cvise");
			String cair = request.getParameter("cair");
			String cpcar = request.getParameter("cpcar");
			String coil = request.getParameter("coil");
			String croad = request.getParameter("croad");
			String cstwacar = request.getParameter("cstwacar");
			String ctraffic = request.getParameter("ctraffic");
			String coutwork = request.getParameter("coutwork");
			String cstay = request.getParameter("cstay");
			String cothers = request.getParameter("cothers");
			String ctotal = request.getParameter("ctotal");
			String cstime = request.getParameter("cstime");
			String cetime = request.getParameter("cetime");
			String creason = request.getParameter("creason");
			creason = new String(creason.getBytes("ISO-8859-1"), "utf-8");
			String cremark = request.getParameter("cremark");
			cremark = new String(cremark.getBytes("ISO-8859-1"), "utf-8");
			cost.setCair(cair);
			cost.setCbank(cbank);
			cost.setCbuild(cbuild);
			cost.setCbuy(cbuy);
			cost.setCdec(cdec);
			cost.setCdname(cdname);
			cost.setCdorm(cdorm);
			cost.setCetime(sdf.parse(cetime));
			cost.setCfes(cfes);
			cost.setCfood(cfood);
			cost.setCgive(cgive);
			cost.setChouse(chouse);
			cost.setCmonth(cmonth);
			cost.setCname(cname);
			cost.setCoil(coil);
			cost.setCommunic(communic);
			cost.setCothers(cothers);
			cost.setCoutwork(coutwork);
			cost.setCpcar(cpcar);
			cost.setCpnumber(cpnumber);
			cost.setCprint(cprint);
			cost.setCreason(creason);
			cost.setCrecruit(crecruit);
			cost.setCremark(cremark);
			cost.setCrepair1(crepair1);
			cost.setCrent(crent);
			cost.setCrepair2(crepair2);
			cost.setCroad(croad);
			cost.setCseek(cseek);
			cost.setCserve(cserve);
			cost.setCstay(cstay);
			cost.setCstime(sdf.parse(cstime));
			cost.setCstuff(cstuff);
			cost.setCstwacar(cstwacar);
			cost.setCtime(sdf.parse(ctime));
			cost.setCtotal(ctotal);
			cost.setCtraffic(ctraffic);
			cost.setCtrain(ctrain);
			cost.setCtravel(ctravel);
			cost.setCvise(cvise);
			cost.setCwaelc(cwaelc);
			costService.add(cost);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "add";
	}
	
	public String list() {
		try {
			PageBean pageBean = costService.list(currentPage);
			ServletActionContext.getRequest().setAttribute("pageBean", pageBean);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "list";
	}

	public String viewByCid() {
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			String cid = request.getParameter("cid");
			cost = costService.findByCid(Integer.parseInt(cid));
			request.setAttribute("cost", cost);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "viewByCid";
	}
	
	public String update() {
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			String ctime = request.getParameter("ctime");
			String cgive = request.getParameter("cgive");
			cgive = new String(cgive.getBytes("ISO-8859-1"), "utf-8");
			String cmonth = request.getParameter("cmonth");
			cmonth = new String(cmonth.getBytes("ISO-8859-1"), "utf-8");
			String cname = request.getParameter("cname");
			cname = new String(cname.getBytes("ISO-8859-1"), "utf-8");
			String cdname = request.getParameter("cdname");
			cdname = new String(cdname.getBytes("ISO-8859-1"), "utf-8");
			String cpnumber = request.getParameter("cpnumber");
			cpnumber = new String(cpnumber.getBytes("ISO-8859-1"), "utf-8");
			String cbank = request.getParameter("cbank");
			cbank = new String(cbank.getBytes("ISO-8859-1"), "utf-8");
			String cfood = request.getParameter("cfood");
			String cfes = request.getParameter("cfes");
			String chouse = request.getParameter("chouse");
			String cwaelc = request.getParameter("cwaelc");
			String cdorm = request.getParameter("cdorm");
			String crecruit = request.getParameter("crecruit");
			String ctrain = request.getParameter("ctrain");
			String crepair1 = request.getParameter("crepair1");
			String cdec = request.getParameter("cdec");
			String ctravel = request.getParameter("ctravel");
			String cbuy = request.getParameter("cbuy");
			String cprint = request.getParameter("cprint");
			String crent = request.getParameter("crent");
			String communic = request.getParameter("communic");
			String crepair2 = request.getParameter("crepair2");
			String cbuild = request.getParameter("cbuild");
			String cserve = request.getParameter("cserve");
			String cseek = request.getParameter("cseek");
			String cstuff = request.getParameter("cstuff");
			String cvise = request.getParameter("cvise");
			String cair = request.getParameter("cair");
			String cpcar = request.getParameter("cpcar");
			String coil = request.getParameter("coil");
			String croad = request.getParameter("croad");
			String cstwacar = request.getParameter("cstwacar");
			String ctraffic = request.getParameter("ctraffic");
			String coutwork = request.getParameter("coutwork");
			String cstay = request.getParameter("cstay");
			String cothers = request.getParameter("cothers");
			String ctotal = request.getParameter("ctotal");
			String cstime = request.getParameter("cstime");
			String cetime = request.getParameter("cetime");
			String creason = request.getParameter("creason");
			creason = new String(creason.getBytes("ISO-8859-1"), "utf-8");
			String cremark = request.getParameter("cremark");
			cremark = new String(cremark.getBytes("ISO-8859-1"), "utf-8");
			String cid = request.getParameter("cid");
			cost.setCid(Integer.parseInt(cid));
			cost.setCair(cair);
			cost.setCbank(cbank);
			cost.setCbuild(cbuild);
			cost.setCbuy(cbuy);
			cost.setCdec(cdec);
			cost.setCdname(cdname);
			cost.setCdorm(cdorm);
			cost.setCetime(sdf.parse(cetime));
			cost.setCfes(cfes);
			cost.setCfood(cfood);
			cost.setCgive(cgive);
			cost.setChouse(chouse);
			cost.setCmonth(cmonth);
			cost.setCname(cname);
			cost.setCoil(coil);
			cost.setCommunic(communic);
			cost.setCothers(cothers);
			cost.setCoutwork(coutwork);
			cost.setCpcar(cpcar);
			cost.setCpnumber(cpnumber);
			cost.setCprint(cprint);
			cost.setCreason(creason);
			cost.setCrecruit(crecruit);
			cost.setCremark(cremark);
			cost.setCrepair1(crepair1);
			cost.setCrent(crent);
			cost.setCrepair2(crepair2);
			cost.setCroad(croad);
			cost.setCseek(cseek);
			cost.setCserve(cserve);
			cost.setCstay(cstay);
			cost.setCstime(sdf.parse(cstime));
			cost.setCstuff(cstuff);
			cost.setCstwacar(cstwacar);
			cost.setCtime(sdf.parse(ctime));
			cost.setCtotal(ctotal);
			cost.setCtraffic(ctraffic);
			cost.setCtrain(ctrain);
			cost.setCtravel(ctravel);
			cost.setCvise(cvise);
			cost.setCwaelc(cwaelc);
			costService.update(cost);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "update";
	}
	
	public String deleteByCid() {
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			String cid = request.getParameter("cid");
			cost = costService.findByCid(Integer.parseInt(cid));
			if(cost != null) {
				costService.deleteByCid(cost);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "deleteByCid";
	}
	
	public String delete() {
		try {
			List<Cost> costs = costService.all();
			if(costs.size() > 0) {
				for (Cost cost : costs) {
					costService.deleteByCid(cost);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "delete";
	}
}
