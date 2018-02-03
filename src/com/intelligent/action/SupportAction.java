package com.intelligent.action;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.intelligent.pojo.Department;
import com.intelligent.pojo.Employee;
import com.intelligent.pojo.PageBean;
import com.intelligent.pojo.Support;
import com.intelligent.service.DepartmentService;
import com.intelligent.service.EmployeeService;
import com.intelligent.service.ProjectService;
import com.intelligent.service.SupportService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("all")
public class SupportAction extends ActionSupport implements
		ModelDriven<Support> {
	private Support support = new Support();
	private ProjectService projectService;
	private SupportService supportService;
	private DepartmentService departmentService;
	private EmployeeService employeeService;
	private Integer currentPage;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");// 设置日期格式

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public void setSupportService(SupportService supportService) {
		this.supportService = supportService;
	}

	public void setProjectService(ProjectService projectService) {
		this.projectService = projectService;
	}

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	@Override
	public Support getModel() {
		return support;
	}

	public String toAddPage() {
		try {
			List<Department> departments = departmentService.list();
			ServletActionContext.getRequest().setAttribute("departments",
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
			String snumber = request.getSession().getAttribute("enumber")
					.toString();
			String sresname = employeeService.findByEnumber(snumber).getEname();
			String sstime = request.getParameter("sstime");
			String setime = request.getParameter("setime");
			String dname = request.getParameter("dname");
			dname = new String(dname.getBytes("ISO-8859-1"), "utf-8");
			String sreqname = request.getParameter("sreqname");
			sreqname = new String(sreqname.getBytes("ISO-8859-1"), "utf-8");
			String sprojectnumber = request.getParameter("sprojectnumber");
			sprojectnumber = new String(sprojectnumber.getBytes("ISO-8859-1"),
					"utf-8");
			String sprojectname = request.getParameter("sprojectname");
			sprojectname = new String(sprojectname.getBytes("ISO-8859-1"),
					"utf-8");
			String skind = request.getParameter("skind");
			skind = new String(skind.getBytes("ISO-8859-1"), "utf-8");
			String squestion = request.getParameter("squestion");
			squestion = new String(squestion.getBytes("ISO-8859-1"), "utf-8");
			String sresolve = request.getParameter("sresolve");
			sresolve = new String(sresolve.getBytes("ISO-8859-1"), "utf-8");
			String senergy = request.getParameter("senergy");
			senergy = new String(senergy.getBytes("ISO-8859-1"), "utf-8");
			String stime = request.getParameter("stime");
			stime = new String(stime.getBytes("ISO-8859-1"), "utf-8");
			String status = request.getParameter("status");
			status = new String(status.getBytes("ISO-8859-1"), "utf-8");
			String sremark = request.getParameter("sremark");
			sremark = new String(sremark.getBytes("ISO-8859-1"), "utf-8");
			support.setSenergy(senergy);
			support.setStandardcharge("");
			support.setSrealitycharge("");
			support.setSoverstandardcharge("");
			support.setSrealityovercharge("");
			if (setime.length() > 0) {
				support.setSetime(sdf.parse(setime));
			}
			support.setSkind(skind);
			support.setSprojectname(sprojectname);
			support.setSprojectnumber(sprojectnumber);
			support.setSquestion(squestion);
			support.setSremark(sremark);
			support.setSreqname(sreqname);
			support.setSresname(sresname);
			support.setSresolve(sresolve);
			support.setSstime(sdf.parse(sstime));
			support.setSdepartmentname(dname);
			support.setSisclosecharge("");
			supportService.add(support);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "add";
	}

	public String listByEmployee() {
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			String snumber = request.getSession().getAttribute("enumber")
					.toString();
			Employee employee = employeeService.findByEnumber(snumber);
			if (employee != null) {
				PageBean pageBean = supportService.listByEmployee(currentPage,
						employee.getEname());
				ServletActionContext.getRequest().setAttribute("pageBean",
						pageBean);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "listByEmployee";
	}

	public String viewBySid() {
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			String sid = request.getParameter("sid");
			support = supportService.findBySid(sid);
			request.setAttribute("support", support);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "viewBySid";
	}

	public String viewBySidByAdmin() {
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			String sid = request.getParameter("sid");
			support = supportService.findBySid(sid);
			request.setAttribute("support", support);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "viewBySidByAdmin";
	}

	public String viewBySidByOthers() {
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			String sid = request.getParameter("sid");
			support = supportService.findBySid(sid);
			request.setAttribute("support", support);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "viewBySidByOthers";
	}

	private String deleteBySid() {
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			String sid = request.getParameter("sid");
			support = supportService.findBySid(sid);
			supportService.deleteBySid(support);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "deleteBySid";
	}

	public String delete() {
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			String snumber = request.getSession().getAttribute("enumber")
					.toString();
			Employee employee = employeeService.findByEnumber(snumber);
			if (employee != null) {
				List<Support> supports = supportService.listBySname(employee
						.getEname());
				for (Support support : supports) {
					supportService.deleteBySid(support);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "delete";
	}

	public String list() {
		try {
			PageBean pageBean = supportService.list(currentPage);
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
			PageBean pageBean = supportService.list(currentPage);
			ServletActionContext.getRequest()
					.setAttribute("pageBean", pageBean);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "listByOthers";
	}

	public String update() {
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			String snumber = request.getSession().getAttribute("enumber")
					.toString();
			String sresname = request.getParameter("sresname");
			sresname = new String(sresname.getBytes("ISO-8859-1"), "utf-8");
			String sstime = request.getParameter("sstime");
			sstime = new String(sstime.getBytes("ISO-8859-1"), "utf-8");
			String setime = request.getParameter("setime");
			setime = new String(setime.getBytes("ISO-8859-1"), "utf-8");
			String dname = request.getParameter("dname");
			dname = new String(dname.getBytes("ISO-8859-1"), "utf-8");
			String sreqname = request.getParameter("sreqname");
			sreqname = new String(sreqname.getBytes("ISO-8859-1"), "utf-8");
			String sprojectnumber = request.getParameter("sprojectnumber");
			sprojectnumber = new String(sprojectnumber.getBytes("ISO-8859-1"),
					"utf-8");
			String sprojectname = request.getParameter("sprojectname");
			sprojectname = new String(sprojectname.getBytes("ISO-8859-1"),
					"utf-8");
			String skind = request.getParameter("skind");
			skind = new String(skind.getBytes("ISO-8859-1"), "utf-8");
			String squestion = request.getParameter("squestion");
			squestion = new String(squestion.getBytes("ISO-8859-1"), "utf-8");
			String sresolve = request.getParameter("sresolve");
			sresolve = new String(sresolve.getBytes("ISO-8859-1"), "utf-8");
			String senergy = request.getParameter("senergy");
			senergy = new String(senergy.getBytes("ISO-8859-1"), "utf-8");
			String stime = request.getParameter("stime");
			stime = new String(stime.getBytes("ISO-8859-1"), "utf-8");
			String status = request.getParameter("status");
			status = new String(status.getBytes("ISO-8859-1"), "utf-8");
			String sremark = request.getParameter("sremark");
			sremark = new String(sremark.getBytes("ISO-8859-1"), "utf-8");
			String sid = request.getParameter("sid");
			String standardcharge = request.getParameter("standardcharge");
			standardcharge = new String(standardcharge.getBytes("ISO-8859-1"),
					"utf-8");
			String srealitycharge = request.getParameter("srealitycharge");
			srealitycharge = new String(srealitycharge.getBytes("ISO-8859-1"),
					"utf-8");
			String soverstandardcharge = request
					.getParameter("soverstandardcharge");
			soverstandardcharge = new String(
					soverstandardcharge.getBytes("ISO-8859-1"), "utf-8");
			String srealityovercharge = request
					.getParameter("srealityovercharge");
			srealityovercharge = new String(
					srealityovercharge.getBytes("ISO-8859-1"), "utf-8");
			String sisclosecharge = request.getParameter("sisclosecharge");
			sisclosecharge = new String(sisclosecharge.getBytes("ISO-8859-1"),
					"utf-8");
			support.setSenergy(senergy);
			if (setime.length() > 0) {
				support.setSetime(sdf.parse(setime));
			}
			Pattern pattern = Pattern.compile("[0-9]*");
			if (!standardcharge.trim().equals("")) {
				boolean flag = pattern.matcher(standardcharge).matches();
				if (flag) {
					java.text.DecimalFormat df = new java.text.DecimalFormat(
							"#.00");
					srealitycharge = String.valueOf(df.format((Float
							.parseFloat(stime))
							/ 8
							* Float.parseFloat(standardcharge)));
					support.setSrealitycharge(srealitycharge);
				} else {
					support.setSrealitycharge("");
				}
			}
			support.setStandardcharge(standardcharge);
			support.setSoverstandardcharge(soverstandardcharge);
			support.setSrealityovercharge(srealityovercharge);
			support.setSkind(skind);
			support.setSprojectname(sprojectname);
			support.setSprojectnumber(sprojectnumber);
			support.setSquestion(squestion);
			support.setSremark(sremark);
			support.setSreqname(sreqname);
			support.setSresname(sresname);
			support.setSresolve(sresolve);
			support.setSstime(sdf.parse(sstime));
			support.setSdepartmentname(dname);
			support.setSisclosecharge(sisclosecharge);
			supportService.update(support);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "update";
	}

	public String updateByManager() {
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			String sresname = request.getParameter("sresname");
			sresname = new String(sresname.getBytes("ISO-8859-1"), "utf-8");
			String sstime = request.getParameter("sstime");
			sstime = new String(sstime.getBytes("ISO-8859-1"), "utf-8");
			String setime = request.getParameter("setime");
			setime = new String(setime.getBytes("ISO-8859-1"), "utf-8");
			String dname = request.getParameter("dname");
			dname = new String(dname.getBytes("ISO-8859-1"), "utf-8");
			String sreqname = request.getParameter("sreqname");
			sreqname = new String(sreqname.getBytes("ISO-8859-1"), "utf-8");
			String sprojectnumber = request.getParameter("sprojectnumber");
			sprojectnumber = new String(sprojectnumber.getBytes("ISO-8859-1"),
					"utf-8");
			String sprojectname = request.getParameter("sprojectname");
			sprojectname = new String(sprojectname.getBytes("ISO-8859-1"),
					"utf-8");
			String skind = request.getParameter("skind");
			skind = new String(skind.getBytes("ISO-8859-1"), "utf-8");
			String squestion = request.getParameter("squestion");
			squestion = new String(squestion.getBytes("ISO-8859-1"), "utf-8");
			String sresolve = request.getParameter("sresolve");
			sresolve = new String(sresolve.getBytes("ISO-8859-1"), "utf-8");
			String senergy = request.getParameter("senergy");
			senergy = new String(senergy.getBytes("ISO-8859-1"), "utf-8");
			String stime = request.getParameter("stime");
			stime = new String(stime.getBytes("ISO-8859-1"), "utf-8");
			String status = request.getParameter("status");
			status = new String(status.getBytes("ISO-8859-1"), "utf-8");
			String sremark = request.getParameter("sremark");
			sremark = new String(sremark.getBytes("ISO-8859-1"), "utf-8");
			String sid = request.getParameter("sid");
			String standardcharge = request.getParameter("standardcharge");
			standardcharge = new String(standardcharge.getBytes("ISO-8859-1"),
					"utf-8");
			String srealitycharge = request.getParameter("srealitycharge");
			srealitycharge = new String(srealitycharge.getBytes("ISO-8859-1"),
					"utf-8");
			String soverstandardcharge = request
					.getParameter("soverstandardcharge");
			soverstandardcharge = new String(
					soverstandardcharge.getBytes("ISO-8859-1"), "utf-8");
			String srealityovercharge = request
					.getParameter("srealityovercharge");
			srealityovercharge = new String(
					srealityovercharge.getBytes("ISO-8859-1"), "utf-8");
			String sisclosecharge = request.getParameter("sisclosecharge");
			sisclosecharge = new String(sisclosecharge.getBytes("ISO-8859-1"),
					"utf-8");
			support.setSenergy(senergy);
			if (setime.length() > 0) {
				support.setSetime(sdf.parse(setime));
			}
			Pattern pattern = Pattern.compile("[0-9]*");
			if (!standardcharge.trim().equals("")) {
				boolean flag = pattern.matcher(standardcharge).matches();
				if (flag) {
					java.text.DecimalFormat df = new java.text.DecimalFormat(
							"#.00");
					srealitycharge = String.valueOf(df.format((Float
							.parseFloat(stime))
							/ 8
							* Float.parseFloat(standardcharge)));
					support.setSrealitycharge(srealitycharge);
				} else {
					support.setSrealitycharge("");
				}
			}
			support.setStandardcharge(standardcharge);
			support.setSoverstandardcharge(soverstandardcharge);
			support.setSrealityovercharge(srealityovercharge);
			support.setSkind(skind);
			support.setSprojectname(sprojectname);
			support.setSprojectnumber(sprojectnumber);
			support.setSquestion(squestion);
			support.setSremark(sremark);
			support.setSreqname(sreqname);
			support.setSresname(sresname);
			support.setSresolve(sresolve);
			support.setSstime(sdf.parse(sstime));
			support.setSdepartmentname(dname);
			support.setSisclosecharge(sisclosecharge);
			supportService.update(support);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "updateByManager";
	}

	public String all() {
		try {
			List<Support> supports = supportService.all();
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "all";
	}

}
