package com.intelligent.action;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.intelligent.pojo.Department;
import com.intelligent.pojo.Industry;
import com.intelligent.pojo.PageBean;
import com.intelligent.service.DepartmentService;
import com.intelligent.service.IndustryService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("all")
public class IndustryAction extends ActionSupport implements
		ModelDriven<Industry> {
	private Industry industry = new Industry();
	private IndustryService industryService;
	private DepartmentService departmentService;
	private Integer currentPage;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");// 设置日期格式

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public void setIndustryService(IndustryService industryService) {
		this.industryService = industryService;
	}

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	@Override
	public Industry getModel() {
		return industry;
	}

	public String toAddPage() {
		try {
			List<Department> departments = departmentService.list();
			ServletActionContext.getRequest().setAttribute("department",
					departments);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "toAddPage";
	}

	public String add() {
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			String istime = request.getParameter("istime");
			String ietime = request.getParameter("ietime");
			String idname = request.getParameter("idname");
			idname = new String(idname.getBytes("ISO-8859-1"), "utf-8");
			String ireqname = request.getParameter("ireqname");
			ireqname = new String(ireqname.getBytes("ISO-8859-1"), "utf-8");
			String ipnumber = request.getParameter("ipnumber");
			ipnumber = new String(ipnumber.getBytes("ISO-8859-1"), "utf-8");
			String ipname = request.getParameter("ipname");
			ipname = new String(ipname.getBytes("ISO-8859-1"), "utf-8");
			String iask = request.getParameter("iask");
			iask = new String(iask.getBytes("ISO-8859-1"), "utf-8");
			String iresname = request.getParameter("iresname");
			iresname = new String(iresname.getBytes("ISO-8859-1"), "utf-8");
			String ikind = request.getParameter("ikind");
			ikind = new String(ikind.getBytes("ISO-8859-1"), "utf-8");
			String itime = request.getParameter("itime");
			itime = new String(itime.getBytes("ISO-8859-1"), "utf-8");
			String imark = request.getParameter("imark");
			imark = new String(imark.getBytes("ISO-8859-1"), "utf-8");
			String istatus = request.getParameter("istatus");
			istatus = new String(istatus.getBytes("ISO-8859-1"), "utf-8");
			String iremark = request.getParameter("iremark");
			iremark = new String(iremark.getBytes("ISO-8859-1"), "utf-8");
			industry.setIask(iask);
			industry.setIdname(idname);
			if (ietime.length() > 0) {
				industry.setIetime(sdf.parse(ietime));
			}
			industry.setIkind(ikind);
			industry.setImark(imark);
			industry.setIpname(ipname);
			industry.setIpnumber(ipnumber);
			industry.setIremark(iremark);
			industry.setIreqname(ireqname);
			industry.setIresname(iresname);
			industry.setIstatus(istatus);
			industry.setIstime(sdf.parse(istime));
			industry.setItime(itime);
			industryService.add(industry);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "add";
	}

	public String list() {
		try {
			PageBean pageBean = industryService.list(currentPage);
			ServletActionContext.getRequest()
					.setAttribute("pageBean", pageBean);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "list";
	}
	
	public String listByOthers() {
		try {
			PageBean pageBean = industryService.list(currentPage);
			ServletActionContext.getRequest()
					.setAttribute("pageBean", pageBean);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "listByOthers";
	}

	public String viewById() {
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			String id = request.getParameter("id");
			industry = industryService.findById(Integer.parseInt(id));
			ServletActionContext.getRequest()
					.setAttribute("industry", industry);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "viewById";
	}
	
	public String viewByIdByOthers() {
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			String id = request.getParameter("id");
			industry = industryService.findById(Integer.parseInt(id));
			ServletActionContext.getRequest()
					.setAttribute("industry", industry);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "viewByIdByOthers";
	}

	public String update() {
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			String istime = request.getParameter("istime");
			String ietime = request.getParameter("ietime");
			String idname = request.getParameter("idname");
			idname = new String(idname.getBytes("ISO-8859-1"), "utf-8");
			String ireqname = request.getParameter("ireqname");
			ireqname = new String(ireqname.getBytes("ISO-8859-1"), "utf-8");
			String ipnumber = request.getParameter("ipnumber");
			ipnumber = new String(ipnumber.getBytes("ISO-8859-1"), "utf-8");
			String ipname = request.getParameter("ipname");
			ipname = new String(ipname.getBytes("ISO-8859-1"), "utf-8");
			String iask = request.getParameter("iask");
			iask = new String(iask.getBytes("ISO-8859-1"), "utf-8");
			String iresname = request.getParameter("iresname");
			iresname = new String(iresname.getBytes("ISO-8859-1"), "utf-8");
			String ikind = request.getParameter("ikind");
			ikind = new String(ikind.getBytes("ISO-8859-1"), "utf-8");
			String itime = request.getParameter("itime");
			itime = new String(itime.getBytes("ISO-8859-1"), "utf-8");
			String imark = request.getParameter("imark");
			imark = new String(imark.getBytes("ISO-8859-1"), "utf-8");
			String istatus = request.getParameter("istatus");
			istatus = new String(istatus.getBytes("ISO-8859-1"), "utf-8");
			String iremark = request.getParameter("iremark");
			iremark = new String(iremark.getBytes("ISO-8859-1"), "utf-8");
			String id = request.getParameter("id");
			industry.setIask(iask);
			industry.setIdname(idname);
			if (ietime.length() > 0) {
				industry.setIetime(sdf.parse(ietime));
			}
			industry.setIkind(ikind);
			industry.setImark(imark);
			industry.setIpname(ipname);
			industry.setIpnumber(ipnumber);
			industry.setIremark(iremark);
			industry.setIreqname(ireqname);
			industry.setIresname(iresname);
			industry.setIstatus(istatus);
			industry.setIstime(sdf.parse(istime));
			industry.setItime(itime);
			industry.setId(Integer.parseInt(id));
			industryService.update(industry);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "update";
	}

	public String deleteById() {
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			String id = request.getParameter("id");
			industry = industryService.findById(Integer.parseInt(id));
			if (industry != null) {
				industryService.deleteById(industry);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "deleteById";
	}

}
