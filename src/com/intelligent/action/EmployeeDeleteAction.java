package com.intelligent.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.intelligent.pojo.Employee;
import com.intelligent.pojo.EmployeeDelete;
import com.intelligent.pojo.PageBean;
import com.intelligent.service.EmployeeDeleteService;
import com.intelligent.service.EmployeeService;
import com.intelligent.service.GroupService;
import com.intelligent.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("all")
public class EmployeeDeleteAction extends ActionSupport implements ModelDriven<EmployeeDelete>{
	private EmployeeDelete employeeDelete = new EmployeeDelete();
	private EmployeeService employeeService;
	private EmployeeDeleteService employeeDeleteService;
	private UserService userService;
	private GroupService groupService;
	private Integer currentPage;
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public void setGroupService(GroupService groupService) {
		this.groupService = groupService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public void setEmployeeDeleteService(EmployeeDeleteService employeeDeleteService) {
		this.employeeDeleteService = employeeDeleteService;
	}
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	@Override
	public EmployeeDelete getModel() {
		return employeeDelete;
	}
	
	public String list() {
		try {
			PageBean pageBean = employeeDeleteService.list(currentPage);
			ServletActionContext.getRequest().setAttribute("pageBean", pageBean);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "list";
	}
	
	public String viewByEnumber() {
		try {
			String ednumber = ServletActionContext.getRequest().getParameter("ednumber");
			employeeDelete = employeeDeleteService.findByEdnumber(ednumber);
			ServletActionContext.getRequest().setAttribute("employeeDelete", employeeDelete);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "viewByEnumber";
	}
	
	public String deleteByEnumber() {
		try {
			String ednumber = ServletActionContext.getRequest().getParameter("ednumber");
			employeeDelete = employeeDeleteService.findByEdnumber(ednumber);
			employeeDelete.setGroup(null);
			employeeDeleteService.deleteByEnumber(employeeDelete);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "deleteByEnumber";
	}
	
	public String restore() {
		try {
			String ednumber = ServletActionContext.getRequest().getParameter("ednumber");
			employeeDelete = employeeDeleteService.findByEdnumber(ednumber);
			Employee employee = new Employee();
			employee.setEmail(employeeDelete.getEdmail());
			employee.setEmana(employeeDelete.getEdmana());
			employee.setEname(employeeDelete.getEdname());
			employee.setEnumber(employeeDelete.getEdnumber());
			employee.setEphone1(employeeDelete.getEdphone1());
			employee.setEphone2(employeeDelete.getEdphone2());
			employee.setEposition(employeeDelete.getEdposition());
			employee.setEpwd(employeeDelete.getEdpwd());
			employee.setEremark(employeeDelete.getEdremark());
			employee.setEsex(employeeDelete.getEdsex());
			employee.setEworkplace(employeeDelete.getEdworkplace());
			employee.setGroup(employeeDelete.getGroup());
			employeeDeleteService.deleteByEnumber(employeeDelete);
			employeeService.add(employee);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "restore";
	}
	
	public String delete() {
		try {
			List<EmployeeDelete> employeeDeletes = employeeDeleteService.all();
			for (EmployeeDelete employeeDelete : employeeDeletes) {
				employeeDelete.setGroup(null);
			}
			employeeDeleteService.delete(employeeDeletes);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "delete";
	}

}
