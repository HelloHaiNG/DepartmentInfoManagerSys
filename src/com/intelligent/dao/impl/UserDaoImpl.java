package com.intelligent.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.intelligent.dao.UserDao;
import com.intelligent.pojo.User;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

	@SuppressWarnings("all")
	@Override
	public List<User> login(String unumber, String upwd) {
		return (List<User>) this.getHibernateTemplate().find("from User where unumber=? and upwd=?", unumber,upwd);
	}

	@Override
	public User findByUnumber(String unumber) {
		return this.getHibernateTemplate().get(User.class, unumber);
	}

	@Override
	public void update(User user) {
		this.getHibernateTemplate().update(user);
	}

	@Override
	public void add(User user) {
		this.getHibernateTemplate().save(user);
	}

	@SuppressWarnings("all")
	@Override
	public List<User> list() {
		String urole = "超级";
		return (List<User>) this.getHibernateTemplate().find("from User where urole not like '"+urole+"%' ");
	}

	@Override
	public void deleteByUnumber(User user) {
		this.getHibernateTemplate().delete(user);
	}

}
