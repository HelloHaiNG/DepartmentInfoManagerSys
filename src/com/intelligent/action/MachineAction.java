package com.intelligent.action;

import org.apache.struts2.ServletActionContext;

import com.intelligent.pojo.Machine;
import com.intelligent.pojo.Project;
import com.intelligent.service.MachineService;
import com.intelligent.service.ProjectService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("all")
public class MachineAction extends ActionSupport implements ModelDriven<Machine>{
	private Machine machine = new Machine();
	private MachineService machineService;
	private ProjectService projectService;
	public void setMachineService(MachineService machineService) {
		this.machineService = machineService;
	}
	public void setProjectService(ProjectService projectService) {
		this.projectService = projectService;
	}
	@Override
	public Machine getModel() {
		return machine;
	}
	
	public String toAddPage() {
		try {
			String pnumber = ServletActionContext.getRequest().getParameter("pnumber");
			Project project = projectService.findByPnumber(pnumber);
			if(project != null) {
				ServletActionContext.getRequest().setAttribute("project", project);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "toAddPage";
	}
	
	public String add() {
		try {
			String mnumber = ServletActionContext.getRequest().getParameter("mnumber");
			mnumber = new String(mnumber.getBytes("ISO-8859-1"), "utf-8");
			String mversion = ServletActionContext.getRequest().getParameter("mversion");
			mversion = new String(mversion.getBytes("ISO-8859-1"), "utf-8");
			String mremark = ServletActionContext.getRequest().getParameter("mremark");
			mremark = new String(mremark.getBytes("ISO-8859-1"), "utf-8");
			String pnumber = ServletActionContext.getRequest().getParameter("pnumber");
			pnumber = new String(pnumber.getBytes("ISO-8859-1"), "utf-8");
			Project project = projectService.findByPnumber(pnumber);
			machine.setMnumber(mnumber);
			machine.setMremark(mremark);
			machine.setMversion(mversion);
			machine.setProject(project);
			machineService.add(machine);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "add";
	}

}
