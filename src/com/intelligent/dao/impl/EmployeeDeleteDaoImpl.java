package com.intelligent.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.intelligent.dao.EmployeeDeleteDao;
import com.intelligent.pojo.EmployeeDelete;

public class EmployeeDeleteDaoImpl extends HibernateDaoSupport implements EmployeeDeleteDao {

	@SuppressWarnings("all")
	@Override
	public int findCount() {
		List<Object>list = (List<Object>) this.getHibernateTemplate().find("select count(*) from EmployeeDelete ");
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
	public List<EmployeeDelete> findListPage(int begin, int pageSize) {
		DetachedCriteria criteria = DetachedCriteria.forClass(EmployeeDelete.class);
		List<EmployeeDelete> list = (List<EmployeeDelete>) this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);
		return list;
	}

	@Override
	public EmployeeDelete findByEdnumber(String ednumber) {
		return this.getHibernateTemplate().get(EmployeeDelete.class, ednumber);
	}

	@Override
	public void deleteByEnumber(EmployeeDelete employeeDelete) {
		this.getHibernateTemplate().delete(employeeDelete);
	}

	@SuppressWarnings("all")
	@Override
	public List<EmployeeDelete> all() {
		return (List<EmployeeDelete>) this.getHibernateTemplate().find("from EmployeeDelete");
	}

	@Override
	public void delete(List<EmployeeDelete> employeeDeletes) {
		this.getHibernateTemplate().deleteAll(employeeDeletes);
	}

	@SuppressWarnings("all")
	@Override
	public List<EmployeeDelete> findByGroup(String gname) {
		return (List<EmployeeDelete>) this.getHibernateTemplate().find("from EmployeeDelete where gid=?", gname);
	}

	@Override
	public void add(EmployeeDelete employeeDelete) {
		this.getHibernateTemplate().save(employeeDelete);
	}

}
