package com.intelligent.pojo;

import java.util.HashSet;
import java.util.Set;

public class Group {
	
	private String gname;
	private Set<Employee> setEmployees = new HashSet<Employee>();
	private Set<EmployeeDelete> setEmployeeDeletes = new HashSet<EmployeeDelete>();
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public Set<Employee> getSetEmployees() {
		return setEmployees;
	}
	public void setSetEmployees(Set<Employee> setEmployees) {
		this.setEmployees = setEmployees;
	}
	public Set<EmployeeDelete> getSetEmployeeDeletes() {
		return setEmployeeDeletes;
	}
	public void setSetEmployeeDeletes(Set<EmployeeDelete> setEmployeeDeletes) {
		this.setEmployeeDeletes = setEmployeeDeletes;
	}
	

}
