package com.intelligent.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.intelligent.pojo.Employee;
import com.intelligent.pojo.EmployeeDelete;
import com.intelligent.pojo.Group;
import com.intelligent.pojo.PageBean;
import com.intelligent.service.EmployeeDeleteService;
import com.intelligent.service.EmployeeService;
import com.intelligent.service.GroupService;
import com.intelligent.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("all")
public class EmployeeAction extends ActionSupport implements
		ModelDriven<Employee> {
	private Employee employee = new Employee();
	private EmployeeService employeeService;
	private UserService userService;
	private EmployeeDeleteService employeeDeleteService;
	private GroupService groupService;
	private Integer currentPage;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");// 设置日期格式

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public void setGroupService(GroupService groupService) {
		this.groupService = groupService;
	}

	public void setEmployeeDeleteService(
			EmployeeDeleteService employeeDeleteService) {
		this.employeeDeleteService = employeeDeleteService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@Override
	public Employee getModel() {
		return employee;
	}

	public String toAddPage() {
		try {
			List<Group> groups = groupService.list();
			ServletActionContext.getRequest().setAttribute("group", groups);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "toAddPage";
	}

	/**
	 * @return
	 */
	public String judgeEnumber() {
		try {
			String enumber = ServletActionContext.getRequest().getParameter(
					"enumber");
			employee = employeeService.findByEnumber(enumber);
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/plain;charset=UTF-8");
			if (employee == null) {
				response.getWriter().write("该工号可用");
				response.getWriter().close();
				
			} else {
				response.getWriter().write("该工号不可用");
				response.getWriter().close();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return NONE;
	}

	public String add() {
		try {
			String enumber = ServletActionContext.getRequest().getParameter(
					"enumber");
			String ename = ServletActionContext.getRequest().getParameter(
					"ename");
			ename = new String(ename.getBytes("ISO-8859-1"), "utf-8");
			String esex = ServletActionContext.getRequest()
					.getParameter("esex");
			esex = new String(esex.getBytes("ISO-8859-1"), "utf-8");
			String eposition = ServletActionContext.getRequest().getParameter(
					"eposition");
			eposition = new String(eposition.getBytes("ISO-8859-1"), "utf-8");
			String ephone1 = ServletActionContext.getRequest().getParameter(
					"ephone1");
			ephone1 = new String(ephone1.getBytes("ISO-8859-1"), "utf-8");
			String ephone2 = ServletActionContext.getRequest().getParameter(
					"ephone2");
			ephone2 = new String(ephone2.getBytes("ISO-8859-1"), "utf-8");
			String gname = ServletActionContext.getRequest().getParameter(
					"gname");
			gname = new String(gname.getBytes("ISO-8859-1"), "utf-8");
			String emana = ServletActionContext.getRequest().getParameter(
					"emana");
			emana = new String(emana.getBytes("ISO-8859-1"), "utf-8");
			String eworkplace = ServletActionContext.getRequest().getParameter(
					"eworkplace");
			eworkplace = new String(eworkplace.getBytes("ISO-8859-1"), "utf-8");
			String email = ServletActionContext.getRequest().getParameter(
					"email");
			email = new String(email.getBytes("ISO-8859-1"), "utf-8");
			String eremark = ServletActionContext.getRequest().getParameter(
					"eremark");
			eremark = new String(eremark.getBytes("ISO-8859-1"), "utf-8");
			String epwd = ServletActionContext.getRequest()
					.getParameter("epwd");
			epwd = new String(epwd.getBytes("ISO-8859-1"), "utf-8");
			String edate = ServletActionContext.getRequest().getParameter(
					"edate");
			edate = new String(edate.getBytes("ISO-8859-1"), "utf-8");
			String eschool = ServletActionContext.getRequest().getParameter(
					"eschool");
			eschool = new String(eschool.getBytes("ISO-8859-1"), "utf-8");
			String educ = ServletActionContext.getRequest().getParameter(
					"educ");
			educ = new String(educ.getBytes("ISO-8859-1"), "utf-8");
			String eids = ServletActionContext.getRequest().getParameter(
					"eids");
			eids = new String(eids.getBytes("ISO-8859-1"), "utf-8");
			employee.setEmail(email);
			employee.setEname(ename);
			employee.setEnumber(enumber);
			employee.setEphone1(ephone1);
			employee.setEphone2(ephone2);
			employee.setEposition(eposition);
			employee.setEsex(esex);
			employee.setEremark(eremark);
			employee.setEworkplace(eworkplace);
			employee.setEpwd(epwd);
			employee.setEmana(emana);
			employee.setEids(eids);
            employee.setEschool(eschool);
            employee.setEduc(educ);
            employee.setEdate(sdf.parse(edate));
			employee.setGroup(groupService.findByGname(gname));
			employeeService.add(employee);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "add";
	}

	public String list() {
		try {
			PageBean pageBean = employeeService.list(currentPage);
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
			PageBean pageBean = employeeService.list(currentPage);
			ServletActionContext.getRequest()
					.setAttribute("pageBean", pageBean);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "listByOthers";
	}

	public String viewByEnumber() {
		try {
			String enumber = ServletActionContext.getRequest().getParameter(
					"enumber");
			employee = employeeService.findByEnumber(enumber);
			if (employee != null) {
				ServletActionContext.getRequest().setAttribute("employee",
						employee);
				List<Group> groups = groupService.list();
				Group group2 = groupService.listByGname(employee.getGroup()
						.getGname());
				List<Group> group3 = new ArrayList<Group>();
				if (groups != null && group2 != null) {
					for (Group group : groups) {
						if (!group.equals(group2)) {
							group3.add(group);
						}
					}
				}
				ServletActionContext.getRequest().setAttribute("group", group3);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "viewByEnumber";
	}
	
	public String viewByEnumberByOthers() {
		try {
			String enumber = ServletActionContext.getRequest().getParameter(
					"enumber");
			employee = employeeService.findByEnumber(enumber);
			if (employee != null) {
				ServletActionContext.getRequest().setAttribute("employee",
						employee);
				List<Group> groups = groupService.list();
				Group group2 = groupService.listByGname(employee.getGroup()
						.getGname());
				List<Group> group3 = new ArrayList<Group>();
				if (groups != null && group2 != null) {
					for (Group group : groups) {
						if (!group.equals(group2)) {
							group3.add(group);
						}
					}
				}
				ServletActionContext.getRequest().setAttribute("group", group3);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "viewByEnumberByOthers";
	}

	public String update() {
		try {
			String enumber = ServletActionContext.getRequest().getParameter(
					"enumber");
			String ename = ServletActionContext.getRequest().getParameter(
					"ename");
			ename = new String(ename.getBytes("ISO-8859-1"), "utf-8");
			String esex = ServletActionContext.getRequest()
					.getParameter("esex");
			esex = new String(esex.getBytes("ISO-8859-1"), "utf-8");
			String eposition = ServletActionContext.getRequest().getParameter(
					"eposition");
			eposition = new String(eposition.getBytes("ISO-8859-1"), "utf-8");
			String ephone1 = ServletActionContext.getRequest().getParameter(
					"ephone1");
			ephone1 = new String(ephone1.getBytes("ISO-8859-1"), "utf-8");
			String ephone2 = ServletActionContext.getRequest().getParameter(
					"ephone2");
			ephone2 = new String(ephone2.getBytes("ISO-8859-1"), "utf-8");
			String gname = ServletActionContext.getRequest().getParameter(
					"gname");
			gname = new String(gname.getBytes("ISO-8859-1"), "utf-8");
			String emana = ServletActionContext.getRequest().getParameter(
					"emana");
			emana = new String(emana.getBytes("ISO-8859-1"), "utf-8");
			String eworkplace = ServletActionContext.getRequest().getParameter(
					"eworkplace");
			eworkplace = new String(eworkplace.getBytes("ISO-8859-1"), "utf-8");
			String email = ServletActionContext.getRequest().getParameter(
					"email");
			email = new String(email.getBytes("ISO-8859-1"), "utf-8");
			String eremark = ServletActionContext.getRequest().getParameter(
					"eremark");
			eremark = new String(eremark.getBytes("ISO-8859-1"), "utf-8");
			String epwd = ServletActionContext.getRequest()
					.getParameter("epwd");
			epwd = new String(epwd.getBytes("ISO-8859-1"), "utf-8");
			String edate = ServletActionContext.getRequest().getParameter(
					"edate");
			edate = new String(edate.getBytes("ISO-8859-1"), "utf-8");
			String eschool = ServletActionContext.getRequest().getParameter(
					"eschool");
			eschool = new String(eschool.getBytes("ISO-8859-1"), "utf-8");
			String educ = ServletActionContext.getRequest().getParameter(
					"educ");
			educ = new String(educ.getBytes("ISO-8859-1"), "utf-8");
			String eids = ServletActionContext.getRequest().getParameter(
					"eids");
			eids = new String(eids.getBytes("ISO-8859-1"), "utf-8");
			employee.setEmail(email);
			employee.setEname(ename);
			employee.setEnumber(enumber);
			employee.setEphone1(ephone1);
			employee.setEphone2(ephone2);
			employee.setEposition(eposition);
			employee.setEsex(esex);
			employee.setEremark(eremark);
			employee.setEworkplace(eworkplace);
			employee.setEpwd(epwd);
			employee.setEmana(emana);
			employee.setGroup(groupService.findByGname(gname));
			employee.setEids(eids);
            employee.setEschool(eschool);
            employee.setEduc(educ);
            employee.setEdate(sdf.parse(edate));
			employeeService.update(employee);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "update";
	}

	public String deleteByEnumber() {
		try {
			String enumber = ServletActionContext.getRequest().getParameter(
					"enumber");
			employee = employeeService.findByEnumber(enumber);
			if (employee != null) {
				EmployeeDelete employeeDelete = new EmployeeDelete();
				employeeDelete.setEdmail(employee.getEmail());
				employeeDelete.setEdname(employee.getEname());
				employeeDelete.setEdnumber(employee.getEnumber());
				employeeDelete.setEdphone1(employee.getEphone1());
				employeeDelete.setEdphone2(employee.getEphone2());
				employeeDelete.setEdposition(employee.getEposition());
				employeeDelete.setEdsex(employee.getEsex());
				employeeDelete.setEdremark(employee.getEremark());
				employeeDelete.setEdworkplace(employee.getEworkplace());
				employeeDelete.setEdpwd(employee.getEpwd());
				employeeDelete.setEdmana(employee.getEmana());
				employeeDelete.setGroup(employee.getGroup());
				employeeDeleteService.add(employeeDelete);
				employee.setGroup(null);
				employeeService.deleteByEmployee(employee);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "deleteByEnumber";
	}

	public String delete() {
		try {
			List<Employee> employees = employeeService.all();
			for (Employee employee : employees) {
				EmployeeDelete employeeDelete = new EmployeeDelete();
				employeeDelete.setEdmail(employee.getEmail());
				employeeDelete.setEdname(employee.getEname());
				employeeDelete.setEdnumber(employee.getEnumber());
				employeeDelete.setEdphone1(employee.getEphone1());
				employeeDelete.setEdphone2(employee.getEphone2());
				employeeDelete.setEdposition(employee.getEposition());
				employeeDelete.setEdsex(employee.getEsex());
				employeeDelete.setEdremark(employee.getEremark());
				employeeDelete.setEdworkplace(employee.getEworkplace());
				employeeDelete.setEdpwd(employee.getEpwd());
				employeeDelete.setEdmana(employee.getEmana());
				employeeDelete.setGroup(employee.getGroup());
				employeeDeleteService.add(employeeDelete);
				employee.setGroup(null);
			}
			employeeService.delete(employees);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "delete";
	}

	public String selfInfo() {
		try {
			String enumber = ServletActionContext.getRequest().getSession().getAttribute("enumber").toString();
			employee = employeeService.findByEnumber(enumber);
			if (employee != null) {
				ServletActionContext.getRequest().setAttribute("employee",
						employee);
				List<Group> groups = groupService.list();
				Group group2 = groupService.listByGname(employee.getGroup()
						.getGname());
				List<Group> group3 = new ArrayList<Group>();
				if (groups != null && group2 != null) {
					for (Group group : groups) {
						if (!group.equals(group2)) {
							group3.add(group);
						}
					}
				}
				ServletActionContext.getRequest().setAttribute("group", group3);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "selfInfo";
	}

}
