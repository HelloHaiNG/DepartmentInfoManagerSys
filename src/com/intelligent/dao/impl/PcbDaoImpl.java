package com.intelligent.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.intelligent.dao.PcbDao;
import com.intelligent.pojo.Pcb;

public class PcbDaoImpl extends HibernateDaoSupport implements PcbDao {

	@Override
	public void add(Pcb pcb) {
		this.getHibernateTemplate().save(pcb);
	}

	@SuppressWarnings("all")
	@Override
	public List<Pcb> findByPnumber(String pnumber) {
		return (List<Pcb>) this.getHibernateTemplate().find("from Pcb where pnumber=?", pnumber);
	}

	@SuppressWarnings("all")
	@Override
	public List<Pcb> list() {
		return (List<Pcb>) this.getHibernateTemplate().find("from Pcb");
	}

	@Override
	public void delete(List<Pcb> pcbs) {
		this.getHibernateTemplate().deleteAll(pcbs);
	}

}
