package com.intelligent.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.intelligent.dao.EmployeeDao;
import com.intelligent.pojo.Employee;

public class EmployeeDaoImpl extends HibernateDaoSupport implements EmployeeDao {

	@Override
	public void add(Employee employee) {
		this.getHibernateTemplate().save(employee);
	}

	@Override
	public Employee findByEnumber(String enumber) {
		return this.getHibernateTemplate().get(Employee.class, enumber);
	}

	@SuppressWarnings("all")
	@Override
	public int findCount() {
		List<Object>list = (List<Object>) this.getHibernateTemplate().find("select count(*) from Employee");
		if(list.size()!=0 && list!=null){
			Object obj = list.get(0);
			Long lobj = (Long) obj;
			int totalCount = lobj.intValue();
			return totalCount;
		}
		return 0;
	}

	@SuppressWarnings("all")
	@Override
	public List<Employee> findListPage(int begin, int pageSize) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Employee.class);
		List<Employee> list = (List<Employee>) this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);
		return list;
	}

	@Override
	public void update(Employee employee) {
		this.getHibernateTemplate().update(employee);
	}

	@Override
	public void deleteByEmployee(Employee employee) {
		this.getHibernateTemplate().delete(employee);
	}

	@SuppressWarnings("all")
	@Override
	public List<Employee> all() {
		return (List<Employee>) this.getHibernateTemplate().find("from Employee");
	}

	@Override
	public void delete(List<Employee> employees) {
		this.getHibernateTemplate().deleteAll(employees);
	}

	@SuppressWarnings("all")
	@Override
	public List<Employee> findByGroup(String gname) {
		return (List<Employee>) this.getHibernateTemplate().find("from Employee where gid=?", gname);
	}

	@SuppressWarnings("all")
	@Override
	public List<Employee> login(String unumber, String upwd) {
		return (List<Employee>) this.getHibernateTemplate().find("from Employee where enumber=? and epwd=?", unumber,upwd);
	}

}
