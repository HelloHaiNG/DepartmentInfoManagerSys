package com.intelligent.pojo;

public class Machine {
	private Integer mid;
	private String mnumber;
	private String mversion;
	private String mremark;
	private Project project;
	public Integer getMid() {
		return mid;
	}
	public void setMid(Integer mid) {
		this.mid = mid;
	}
	public String getMnumber() {
		return mnumber;
	}
	public void setMnumber(String mnumber) {
		this.mnumber = mnumber;
	}
	public String getMversion() {
		return mversion;
	}
	public void setMversion(String mversion) {
		this.mversion = mversion;
	}
	public String getMremark() {
		return mremark;
	}
	public void setMremark(String mremark) {
		this.mremark = mremark;
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}

}
