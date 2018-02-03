package com.intelligent.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.intelligent.dao.IndustryDao;
import com.intelligent.pojo.Industry;

public class IndustryDaoImpl extends HibernateDaoSupport implements IndustryDao {

	@Override
	public void add(Industry industry) {
		this.getHibernateTemplate().save(industry);
	}

	@SuppressWarnings("all")
	@Override
	public int findCount() {
		List<Object>list = (List<Object>) this.getHibernateTemplate().find("select count(*) from Industry ");
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
	public List<Industry> findListPage(int begin, int pageSize) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Industry.class);
		List<Industry> list = (List<Industry>) this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);
		return list;
	}

	@Override
	public Industry findById(int parseInt) {
		return this.getHibernateTemplate().get(Industry.class, parseInt);
	}

	@Override
	public void update(Industry industry) {
		this.getHibernateTemplate().update(industry);
	}

	@Override
	public void deleteById(Industry industry) {
		this.getHibernateTemplate().delete(industry);
	}

	@SuppressWarnings("all")
	@Override
	public List<Industry> all() {
		return (List<Industry>) this.getHibernateTemplate().find("from Industry");
	}

}
