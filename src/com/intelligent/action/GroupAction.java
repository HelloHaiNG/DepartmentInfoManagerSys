package com.intelligent.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.intelligent.pojo.Employee;
import com.intelligent.pojo.EmployeeDelete;
import com.intelligent.pojo.Group;
import com.intelligent.service.EmployeeDeleteService;
import com.intelligent.service.EmployeeService;
import com.intelligent.service.GroupService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("all")
public class GroupAction extends ActionSupport implements ModelDriven<Group> {
	private Group group = new Group();
	private GroupService groupService;
	private EmployeeService employeeService;
	private EmployeeDeleteService employeeDeleteService;

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public void setEmployeeDeleteService(
			EmployeeDeleteService employeeDeleteService) {
		this.employeeDeleteService = employeeDeleteService;
	}

	public void setGroupService(GroupService groupService) {
		this.groupService = groupService;
	}

	@Override
	public Group getModel() {
		return group;
	}

	public String toAddPage() {
		return "toAddPage";
	}

	public String judgeGname() {
		try {
			String gname = ServletActionContext.getRequest().getParameter(
					"gname");
			gname = new String(gname.getBytes("ISO-8859-1"), "utf-8");
			group = groupService.findByGname(gname);
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/plain;charset=UTF-8");
			if (group == null) {
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
			String gname = ServletActionContext.getRequest().getParameter(
					"gname");
			gname = new String(gname.getBytes("ISO-8859-1"), "utf-8");
			group.setGname(gname);
			groupService.add(group);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "add";
	}

	public String list() {
		try {
			List<Group> groups = groupService.list();
			ServletActionContext.getRequest().setAttribute("group", groups);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "list";
	}

	public String delete() {
		try {
			String gname = ServletActionContext.getRequest().getParameter(
					"gname");
			gname = new String(gname.getBytes("ISO-8859-1"), "utf-8");
			group = groupService.findByGname(gname);
			List<Group> groups = new ArrayList<Group>();
			groups.add(group);
			List<Employee> employees = employeeService.findByGroup(group
					.getGname());
			List<EmployeeDelete> employeeDeletes = employeeDeleteService
					.findByGroup(group.getGname());
			for (EmployeeDelete employeeDelete : employeeDeletes) {
				employeeDelete.setGroup(null);
			}for (Employee employee : employees) {
				employee.setGroup(null);
			}
			groupService.delete(groups);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "delete";
	}

}
