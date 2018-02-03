package com.intelligent.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.intelligent.dao.SoftDao;
import com.intelligent.pojo.Soft;

public class SoftDaoImpl extends HibernateDaoSupport implements SoftDao {

	@Override
	public void add(Soft soft) {
		this.getHibernateTemplate().save(soft);
	}

	@SuppressWarnings("all")
	@Override
	public List<Soft> findByPnumber(String pnumber) {
		return (List<Soft>) this.getHibernateTemplate().find("from Soft where pnumber=?", pnumber);
	}

	@SuppressWarnings("all")
	@Override
	public List<Soft> list() {
		return (List<Soft>) this.getHibernateTemplate().find("from Soft");
	}

	@Override
	public void delete(List<Soft> softs) {
		this.getHibernateTemplate().deleteAll(softs);
	}

}
