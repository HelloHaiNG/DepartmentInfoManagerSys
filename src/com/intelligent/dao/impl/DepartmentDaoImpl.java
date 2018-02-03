package com.intelligent.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.intelligent.dao.DepartmentDao;
import com.intelligent.pojo.Department;

public class DepartmentDaoImpl extends HibernateDaoSupport implements DepartmentDao {

	@SuppressWarnings("all")
	@Override
	public List<Department> list() {
		return (List<Department>) this.getHibernateTemplate().find("from Department");
	}

	@Override
	public Department findByDename(String dname) {
		return this.getHibernateTemplate().get(Department.class, dname);
	}

	@Override
	public void add(Department department) {
		this.getHibernateTemplate().save(department);
	}

	@Override
	public void deleteByDname(Department department) {
		this.getHibernateTemplate().delete(department);
	}

}
