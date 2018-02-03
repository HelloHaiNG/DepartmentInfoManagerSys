package com.intelligent.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.intelligent.dao.MachineDao;
import com.intelligent.pojo.Machine;

public class MachineDaoImpl extends HibernateDaoSupport implements MachineDao {

	@Override
	public void add(Machine machine) {
		this.getHibernateTemplate().save(machine);
	}

	@SuppressWarnings("all")
	@Override
	public List<Machine> findByPnumber(String pnumber) {
		return (List<Machine>) this.getHibernateTemplate().find("from Machine where pnumber=?", pnumber);
	}

	@SuppressWarnings("all")
	@Override
	public List<Machine> list() {
		return (List<Machine>) this.getHibernateTemplate().find("from Machine");
	}

	@Override
	public void delete(List<Machine> machines) {
		this.getHibernateTemplate().deleteAll(machines);
	}

}
