package com.intelligent.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.intelligent.dao.EmployeeDao;
import com.intelligent.pojo.Employee;
import com.intelligent.pojo.PageBean;

@Transactional
public class EmployeeService {
	private EmployeeDao employeeDao;
	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
	public void add(Employee employee) {
		employeeDao.add(employee);
	}
	
	public Employee findByEnumber(String enumber) {
		return employeeDao.findByEnumber(enumber);
	}
	
	public PageBean list(Integer currentPage) {
		PageBean pageBean = new PageBean();
		//当前页数
		pageBean.setCurrentPage(currentPage);
		//总记录数
		int totalCount = employeeDao.findCount();
		pageBean.setTotalCount(totalCount);
		//页记录数
		int pageSize = 20;
		pageBean.setPageSize(pageSize);
		//总页数
		int totalPage = 0;
		if(totalCount%pageSize==0){
			totalPage = totalCount/pageSize;
		}else{
			totalPage = totalCount/pageSize+1;
		}
		pageBean.setTotalPage(totalPage);
		//页开始记录数
		int begin = (currentPage-1)*pageSize;
		pageBean.setBegin(begin);
		List<Employee> list = employeeDao.findListPage(begin,pageSize);
		pageBean.setListEmployees(list);
		return pageBean;
	}
	public void update(Employee employee) {
		employeeDao.update(employee);
	}
	
	public void deleteByEmployee(Employee employee) {
		employeeDao.deleteByEmployee(employee);
	}
	public List<Employee> all() {
		return employeeDao.all();
	}
	public void delete(List<Employee> employees) {
		employeeDao.delete(employees);
	}
	
	public List<Employee> findByGroup(String gname) {
		return employeeDao.findByGroup(gname);
	}
	
	public List<Employee> login(String unumber, String upwd) {
		return employeeDao.login(unumber,upwd);
	}

}
