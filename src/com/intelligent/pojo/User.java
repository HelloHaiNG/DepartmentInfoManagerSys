package com.intelligent.pojo;

import java.util.HashSet;
import java.util.Set;

public class User {
	private String unumber;
	private String upwd;
	private String urole;
	private String username;
	private Set<Project> setProjects = new HashSet<Project>();
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Set<Project> getSetProjects() {
		return setProjects;
	}
	public void setSetProjects(Set<Project> setProjects) {
		this.setProjects = setProjects;
	}
	public String getUnumber() {
		return unumber;
	}
	public void setUnumber(String unumber) {
		this.unumber = unumber;
	}
	public String getUpwd() {
		return upwd;
	}
	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}
	public String getUrole() {
		return urole;
	}
	public void setUrole(String urole) {
		this.urole = urole;
	}
	
}
