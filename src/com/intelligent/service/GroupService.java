package com.intelligent.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.intelligent.dao.GroupDao;
import com.intelligent.pojo.Group;

@Transactional
public class GroupService {
	private GroupDao groupDao;
	public void setGroupDao(GroupDao groupDao) {
		this.groupDao = groupDao;
	}
	public List<Group> list() {
		return groupDao.list();
	}
	public Group findByGname(String gname) {
		return groupDao.findByGname(gname);
	}
	public Group listByGname(String gname) {
		return groupDao.listByGname(gname);
	}
	public void add(Group group) {
		groupDao.add(group);
	}
	public void delete(List<Group> list) {
		groupDao.delete(list);
	}
	

}
