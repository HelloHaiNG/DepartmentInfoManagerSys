package com.intelligent.dao;

import java.util.List;

import com.intelligent.pojo.User;

public interface UserDao {

	List<User> login(String unumber, String upwd);

	User findByUnumber(String unumber);

	void update(User user);

	void add(User user);

	List<User> list();

	void deleteByUnumber(User user);

}
