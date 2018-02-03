package com.intelligent.dao;

import java.util.List;

import com.intelligent.pojo.Group;

public interface GroupDao {

	List<Group> list();

	Group findByGname(String gname);

	Group listByGname(String gname);

	void add(Group group);

	void delete(List<Group> list);

}
