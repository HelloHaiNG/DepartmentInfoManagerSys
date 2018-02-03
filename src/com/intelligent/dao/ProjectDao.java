package com.intelligent.dao;

import java.util.List;

import com.intelligent.pojo.Project;

public interface ProjectDao {

	List<Project> projectList();

	void add(Project project);

	int findCountByUnumber(String unumber);

	List<Project> findListPage(int begin, int pageSize);

	Project findByPnumber(String pnumber);

	void update(Project project);

	void deleteByPnumber(Project project);

	void delete(List<Project> projects);

	List<Project> all();

	int findCount();

}
