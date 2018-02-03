package com.intelligent.pojo;

import java.util.List;

public class PageBean {
	
	private Integer currentPage;
	private Integer totalCount;
	private Integer totalPage;
	private Integer begin;
	private Integer pageSize;
	private List<Project> listProjects;
	private List<Employee> listEmployees;
	private List<EmployeeDelete> listEmployeeDeletes;
	private List<Support> listSupports;
	private List<Industry> listIndustries;
	private List<Cost> listCosts;
	private List<Device> listDevices;
	private List<Notice> listNotices;
	public List<Notice> getListNotices() {
		return listNotices;
	}
	public void setListNotices(List<Notice> listNotices) {
		this.listNotices = listNotices;
	}
	public List<Device> getListDevices() {
		return listDevices;
	}
	public void setListDevices(List<Device> listDevices) {
		this.listDevices = listDevices;
	}
	public List<Cost> getListCosts() {
		return listCosts;
	}
	public void setListCosts(List<Cost> listCosts) {
		this.listCosts = listCosts;
	}
	public List<Industry> getListIndustries() {
		return listIndustries;
	}
	public void setListIndustries(List<Industry> listIndustries) {
		this.listIndustries = listIndustries;
	}
	public List<Support> getListSupports() {
		return listSupports;
	}
	public void setListSupports(List<Support> listSupports) {
		this.listSupports = listSupports;
	}
	public List<EmployeeDelete> getListEmployeeDeletes() {
		return listEmployeeDeletes;
	}
	public void setListEmployeeDeletes(List<EmployeeDelete> listEmployeeDeletes) {
		this.listEmployeeDeletes = listEmployeeDeletes;
	}
	public List<Employee> getListEmployees() {
		return listEmployees;
	}
	public void setListEmployees(List<Employee> listEmployees) {
		this.listEmployees = listEmployees;
	}
	public List<Project> getListProjects() {
		return listProjects;
	}
	public void setListProjects(List<Project> listProjects) {
		this.listProjects = listProjects;
	}
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public Integer getBegin() {
		return begin;
	}
	public void setBegin(Integer begin) {
		this.begin = begin;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

}
