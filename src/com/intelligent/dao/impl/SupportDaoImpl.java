package com.intelligent.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.intelligent.dao.SupportDao;
import com.intelligent.pojo.Support;

public class SupportDaoImpl extends HibernateDaoSupport implements SupportDao {

	@Override
	public void add(Support support) {
		this.getHibernateTemplate().save(support);
	}

	@SuppressWarnings("all")
	@Override
	public int findCountByEmployee(String sresname) {
		List<Object>list = (List<Object>) this.getHibernateTemplate().find("select count(*) from Support where sresname=?",sresname);
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
	public List<Support> findListPage(int begin, int pageSize) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Support.class);
		List<Support> list = (List<Support>) this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);
		return list;
	}

	@Override
	public Support findBySid(String sid) {
		return this.getHibernateTemplate().get(Support.class, Integer.parseInt(sid));
	}

	@Override
	public void deleteBySid(Support support) {
		this.getHibernateTemplate().delete(support);
	}

	@SuppressWarnings("all")
	@Override
	public List<Support> listBySname(String sresname) {
		return (List<Support>) this.getHibernateTemplate().find("from Support where sresname=?", sresname);
	}

	@SuppressWarnings("all")
	@Override
	public int findCount() {
		List<Object>list = (List<Object>) this.getHibernateTemplate().find("select count(*) from Support ");
		if(list.size()!=0 && list!=null){
			Object obj = list.get(0);
			Long lobj = (Long) obj;
			int totalCount = lobj.intValue();
			return totalCount;
		}
		return 0;
	}

	@Override
	public void update(Support support) {
		this.getHibernateTemplate().update(support);
	}

	@SuppressWarnings("all")
	@Override
	public List<Support> findListPageByEmployee(int begin, int pageSize,
			String sresname) {
		Query query = currentSession().createQuery("from Support where sresname=?");
		query.setParameter(0, sresname);
		query.setFirstResult(begin);
		query.setMaxResults(pageSize);
		return query.list();
	}

	@SuppressWarnings("all")
	@Override
	public List<Support> all() {
		return (List<Support>) this.getHibernateTemplate().find("from Support");
	}

}
