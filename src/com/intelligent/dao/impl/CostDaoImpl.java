package com.intelligent.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.intelligent.dao.CostDao;
import com.intelligent.pojo.Cost;

public class CostDaoImpl extends HibernateDaoSupport implements CostDao {

	@Override
	public void add(Cost cost) {
		this.getHibernateTemplate().save(cost);
	}

	@SuppressWarnings("all")
	@Override
	public int findCount() {
		List<Object>list = (List<Object>) this.getHibernateTemplate().find("select count(*) from Cost ");
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
	public List<Cost> findListPage(int begin, int pageSize) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Cost.class);
		List<Cost> list = (List<Cost>) this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);
		return list;
	}

	@Override
	public Cost findByCid(int parseInt) {
		return this.getHibernateTemplate().get(Cost.class, parseInt);
	}

	@Override
	public void update(Cost cost) {
		this.getHibernateTemplate().update(cost);
	}

	@Override
	public void deleteByCid(Cost cost) {
		this.getHibernateTemplate().delete(cost);
	}

	@SuppressWarnings("all")
	@Override
	public List<Cost> all() {
		return (List<Cost>) this.getHibernateTemplate().find("from Cost");
	}

}
