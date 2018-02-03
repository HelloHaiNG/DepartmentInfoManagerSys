package com.intelligent.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.intelligent.dao.NoticeDao;
import com.intelligent.pojo.Notice;

public class NoticeDaoImpl extends HibernateDaoSupport implements NoticeDao {

	@Override
	public void add(Notice notice) {
		this.getHibernateTemplate().save(notice);
	}

	@SuppressWarnings("all")
	@Override
	public List<Notice> list() {
		Query query = currentSession().createQuery("from Notice order by nid desc");
		query.setMaxResults(3);
		return (List<Notice>) query.list();
	}

	@Override
	public Notice findByNid(int parseInt) {
		return this.getHibernateTemplate().get(Notice.class, parseInt);
	}

	@Override
	public void deleteByNid(Notice notice) {
		this.getHibernateTemplate().delete(notice);
	}

	@SuppressWarnings("all")
	@Override
	public List<Notice> all() {
		return (List<Notice>) this.getHibernateTemplate().find("from Notice");
	}

	@SuppressWarnings("all")
	@Override
	public int findCount() {
		List<Object>list = (List<Object>) this.getHibernateTemplate().find("select count(*) from Notice");
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
	public List<Notice> findListPage(int begin, int pageSize) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Notice.class);
		List<Notice> list = (List<Notice>) this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);
		return list;
	}

}
