package com.intelligent.action;

import org.apache.struts2.ServletActionContext;

import com.intelligent.pojo.Pcb;
import com.intelligent.pojo.Project;
import com.intelligent.service.PcbService;
import com.intelligent.service.ProjectService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("all")
public class PcbAction extends ActionSupport implements ModelDriven<Pcb>{
	private Pcb pcb = new Pcb();
	private PcbService pcbService;
	private ProjectService projectService;
	public void setProjectService(ProjectService projectService) {
		this.projectService = projectService;
	}

	public void setPcbService(PcbService pcbService) {
		this.pcbService = pcbService;
	}

	@Override
	public Pcb getModel() {
		return pcb;
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
			String pcbnumber = ServletActionContext.getRequest().getParameter("pcbnumber");
			pcbnumber = new String(pcbnumber.getBytes("ISO-8859-1"), "utf-8");
			String pcbname = ServletActionContext.getRequest().getParameter("pcbname");
			pcbname = new String(pcbname.getBytes("ISO-8859-1"), "utf-8");
			String pcbversion = ServletActionContext.getRequest().getParameter("pcbversion");
			pcbversion = new String(pcbversion.getBytes("ISO-8859-1"), "utf-8");
			String pcbremark = ServletActionContext.getRequest().getParameter("pcbremark");
			pcbremark = new String(pcbremark.getBytes("ISO-8859-1"), "utf-8");
			String pnumber = ServletActionContext.getRequest().getParameter("pnumber");
			pnumber = new String(pnumber.getBytes("ISO-8859-1"), "utf-8");
			Project project = projectService.findByPnumber(pnumber);
			pcb.setPcbname(pcbname);
			pcb.setPcbnumber(pcbnumber);
			pcb.setPcbremark(pcbremark);
			pcb.setPcbversion(pcbversion);
			pcb.setProject(project);
			pcbService.add(pcb);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "add";
	}

}
