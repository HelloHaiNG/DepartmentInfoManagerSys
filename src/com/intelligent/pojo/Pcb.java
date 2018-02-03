package com.intelligent.pojo;

public class Pcb {
	private Integer pcbid;
	private String  pcbnumber;
	private String  pcbname;
	private String  pcbversion;
	private String  pcbremark;
	private Project project;
	public Integer getPcbid() {
		return pcbid;
	}
	public void setPcbid(Integer pcbid) {
		this.pcbid = pcbid;
	}
	public String getPcbnumber() {
		return pcbnumber;
	}
	public void setPcbnumber(String pcbnumber) {
		this.pcbnumber = pcbnumber;
	}
	public String getPcbname() {
		return pcbname;
	}
	public void setPcbname(String pcbname) {
		this.pcbname = pcbname;
	}
	public String getPcbversion() {
		return pcbversion;
	}
	public void setPcbversion(String pcbversion) {
		this.pcbversion = pcbversion;
	}
	public String getPcbremark() {
		return pcbremark;
	}
	public void setPcbremark(String pcbremark) {
		this.pcbremark = pcbremark;
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}

}
