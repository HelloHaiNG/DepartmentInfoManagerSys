package com.intelligent.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.intelligent.dao.GroupDao;
import com.intelligent.pojo.Group;

public class GroupDaoImpl extends HibernateDaoSupport implements GroupDao {

	@SuppressWarnings("all")
	@Override
	public List<Group> list() {
		return (List<Group>) this.getHibernateTemplate().find("from Group");
	}

	@Override
	public Group findByGname(String gname) {
		return this.getHibernateTemplate().get(Group.class, gname);
	}

	@Override
	public Group listByGname(String gname) {
		return this.getHibernateTemplate().get(Group.class, gname);
	}

	@Override
	public void add(Group group) {
		this.getHibernateTemplate().save(group);
	}

	@Override
	public void delete(List<Group> list) {
		this.getHibernateTemplate().deleteAll(list);
	}

}
