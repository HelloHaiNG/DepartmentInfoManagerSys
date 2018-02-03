package com.intelligent.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.intelligent.pojo.Employee;
import com.intelligent.pojo.User;
import com.intelligent.service.EmployeeService;
import com.intelligent.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("all")
public class UserAction extends ActionSupport implements ModelDriven<User> {
	private User user = new User();
	private UserService userService;
	private EmployeeService employeeService;
	private HttpServletRequest request = ServletActionContext.getRequest();

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	public User getModel() {
		return user;
	}

	public String login() {
		try {
			String unumber = ServletActionContext.getRequest().getParameter(
					"unumber");
			String upwd = ServletActionContext.getRequest()
					.getParameter("upwd");
			String role = ServletActionContext.getRequest()
					.getParameter("role");
			role = new String(role.getBytes("ISO-8859-1"), "utf-8");
			if (role.equals("管理员")) {
				List<User> users = userService.login(unumber, upwd);
				if (users.size() > 0) {
					String urole = users.get(0).getUrole();
					if (urole.equals("项目管理员")) {
						ServletActionContext.getRequest().getSession()
								.setAttribute("unumber", user.getUnumber());
						ServletActionContext.getRequest().getSession()
								.setAttribute("user", users.get(0));
						return "project";
					} else if (urole.equals("部门管理员")) {
						ServletActionContext.getRequest().getSession()
								.setAttribute("unumber", user.getUnumber());
						ServletActionContext.getRequest().getSession()
								.setAttribute("user", users.get(0));
						return "department";
					} else if (urole.equals("工业管理员")) {
						ServletActionContext.getRequest().getSession()
								.setAttribute("unumber", user.getUnumber());
						ServletActionContext.getRequest().getSession()
								.setAttribute("user", users.get(0));
						return "industry";
					} else if (urole.equals("设备管理员")) {
						ServletActionContext.getRequest().getSession()
								.setAttribute("unumber", user.getUnumber());
						ServletActionContext.getRequest().getSession()
								.setAttribute("user", users.get(0));
						return "device";
					} else {
						ServletActionContext.getRequest().getSession()
								.setAttribute("unumber", user.getUnumber());
						ServletActionContext.getRequest().getSession()
								.setAttribute("user", users.get(0));
						return "admin";
					}
				} else {
					return "fail";
				}
			} else {
				List<Employee> employees = employeeService.login(unumber, upwd);
				if (employees.size() > 0) {
					ServletActionContext.getRequest().getSession()
							.setAttribute("enumber", unumber);
					ServletActionContext.getRequest().getSession()
							.setAttribute("employee", employees.get(0));
					return "employee";
				} else {
					return "fail";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

	public String selfInfo() {
		try {
			String unumber = request.getSession().getAttribute("unumber").toString();
			user = userService.findByUnumber(unumber);
			if(user != null) {
				request.setAttribute("user", user);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "selfInfo";
	}

	public String toUpdateInfoPage() {
		try {
			String unumber = request.getSession().getAttribute("unumber").toString();
			user = userService.findByUnumber(unumber);
			if(user != null) {
				request.setAttribute("user", user);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "toUpdateInfoPage";
	}

	public String update() {
		try {
			String unumber = ServletActionContext.getRequest().getParameter(
					"unumber");
			String upwd = ServletActionContext.getRequest()
					.getParameter("upwd");
			String urole = ServletActionContext.getRequest().getParameter(
					"urole");
			urole = new String(urole.getBytes("ISO-8859-1"), "utf-8");
			String username = ServletActionContext.getRequest().getParameter("username");
			username = new String(username.getBytes("ISO-8859-1"), "utf-8");
			user.setUnumber(unumber);
			user.setUpwd(upwd);
			user.setUrole(urole);
			user.setUsername(username);
			userService.update(user);
			return "update";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	public String toAddPage() {
		return "toAddPage";
	}
	
	public String judgeUnumber() {
		try {
			String unumber = ServletActionContext.getRequest().getParameter(
					"unumber");
			user = userService.findByUnumber(unumber);
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/plain;charset=UTF-8");
			if (user == null) {
				response.getWriter().write("该工号可用");
				
			} else {
				response.getWriter().write("该工号不可用");
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
			String unumber = request.getParameter("unumber");
			String username = request.getParameter("username");
			username = new String(username.getBytes("ISO-8859-1"), "utf-8");
			String urole = request.getParameter("urole");
			urole = new String(urole.getBytes("ISO-8859-1"), "utf-8");
			String upwd = request.getParameter("upwd");
			user.setUnumber(unumber);
			user.setUpwd(upwd);
			user.setUrole(urole);
			user.setUsername(username);
			userService.add(user);
		} catch (Exception e) {
			return "error";
		}
		return "add";
	}
	
	public String list() {
		try {
			List<User> users = userService.list();
			ServletActionContext.getRequest().setAttribute("user", users);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "list";
	}
	
	public String deleteByUnumber() {
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			String unumber = request.getParameter("unumber");
			user = userService.findByUnumber(unumber);
			if(user != null) {
				userService.deleteByUnumber(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "deleteByUnumber";
	}
	
	public String delete() {
		try {
			List<User> users = userService.list();
			for (User user : users) {
				userService.deleteByUnumber(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "delete";
	}

}
