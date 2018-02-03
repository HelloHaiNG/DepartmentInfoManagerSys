package com.intelligent.action;

import org.apache.struts2.ServletActionContext;

import com.intelligent.pojo.Project;
import com.intelligent.pojo.Soft;
import com.intelligent.service.ProjectService;
import com.intelligent.service.SoftService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("all")
public class SoftAction extends ActionSupport implements ModelDriven<Soft>{
	private Soft soft = new Soft();
	private ProjectService projectService;
	private SoftService softService;
	public void setProjectService(ProjectService projectService) {
		this.projectService = projectService;
	}
	public void setSoftService(SoftService softService) {
		this.softService = softService;
	}
	@Override
	public Soft getModel() {
		return soft;
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
			String snumber = ServletActionContext.getRequest().getParameter("snumber");
			snumber = new String(snumber.getBytes("ISO-8859-1"), "utf-8");
			String sversion = ServletActionContext.getRequest().getParameter("sversion");
			sversion = new String(sversion.getBytes("ISO-8859-1"), "utf-8");
			String sremark = ServletActionContext.getRequest().getParameter("sremark");
			sremark = new String(sremark.getBytes("ISO-8859-1"), "utf-8");
			String pnumber = ServletActionContext.getRequest().getParameter("pnumber");
			pnumber = new String(pnumber.getBytes("ISO-8859-1"), "utf-8");
			Project project = projectService.findByPnumber(pnumber);
			soft.setSnumber(snumber);
			soft.setProject(project);
			soft.setSremark(sremark);
			soft.setSversion(sversion);
			softService.add(soft);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "add";
	}

}
