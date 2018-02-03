package com.intelligent.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.intelligent.pojo.Department;
import com.intelligent.service.DepartmentService;
import com.intelligent.service.SupportService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("all")
public class DepartmentAction extends ActionSupport implements ModelDriven<Department> {
	private Department department = new Department();
    private DepartmentService departmentService;
    private SupportService supportService;
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	public void setSupportService(SupportService supportService) {
		this.supportService = supportService;
	}
	@Override
	public Department getModel() {
		return department;
	}
	
	public String toAddPage() {
		return "toAddPage";
	}
	public String judgeDname() {
		try {
			String dname = ServletActionContext.getRequest().getParameter(
					"dname");
			dname = new String(dname.getBytes("ISO-8859-1"), "utf-8");
			department = departmentService.findByDename(dname);
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/plain;charset=UTF-8");
			if (department == null) {
				response.getWriter().write("该名称可用");
				
			} else {
				response.getWriter().write("该名称不可用");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return NONE;
	}
	
	public String add() {
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			String dname = request.getParameter("dname");
			dname = new String(dname.getBytes("ISO-8859-1"), "utf-8");
			String dfname = request.getParameter("dfname");
			dfname = new String(dfname.getBytes("ISO-8859-1"), "utf-8");
			department.setDname(dname);
			department.setDfname(dfname);
			departmentService.add(department);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "add";
	}
	
	public String list() {
		try {
			List<Department> departments = departmentService.list();
			ServletActionContext.getRequest().setAttribute("department", departments);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "list";
	}
	
	public String deleteByDname() {
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			String dname = request.getParameter("dname");
			dname = new String(dname.getBytes("ISO-8859-1"), "utf-8");
			department = departmentService.findByDename(dname);
			if (department != null) {
				departmentService.deleteByDname(department);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "deleteByDname";
	}
	
	

}
