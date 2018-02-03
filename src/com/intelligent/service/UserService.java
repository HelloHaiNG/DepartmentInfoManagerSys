package com.intelligent.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.intelligent.dao.UserDao;
import com.intelligent.pojo.User;

@Transactional
public class UserService {
	private UserDao userDao;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public List<User> login(String unumber, String upwd) {
		return userDao.login(unumber,upwd);
	}

	public User findByUnumber(String unumber) {
		return userDao.findByUnumber(unumber);
	}

	public void update(User user) {
		userDao.update(user);
	}

	public void add(User user) {
		userDao.add(user);
	}

	public List<User> list() {
		return userDao.list();
	}

	public void deleteByUnumber(User user) {
		userDao.deleteByUnumber(user);
	}

}
