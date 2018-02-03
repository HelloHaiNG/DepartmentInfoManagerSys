package com.intelligent.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.intelligent.dao.DepartmentDao;
import com.intelligent.pojo.Department;

@Transactional
public class DepartmentService {
	private DepartmentDao departmentDao;
	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}
	public List<Department> list() {
		return departmentDao.list();
	}
	public Department findByDename(String dname) {
		return departmentDao.findByDename(dname);
	}
	
	public void add(Department department) {
		departmentDao.add(department);
	}
	
	public void deleteByDname(Department department) {
		departmentDao.deleteByDname(department);
	}

}
